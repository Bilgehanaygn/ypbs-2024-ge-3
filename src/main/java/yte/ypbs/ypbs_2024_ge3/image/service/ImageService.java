package yte.ypbs.ypbs_2024_ge3.image.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yte.ypbs.ypbs_2024_ge3.image.entity.Image;
import yte.ypbs.ypbs_2024_ge3.image.repository.ImageRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.service.UserService;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final UserService userService;

    @Autowired
    public ImageService(ImageRepository imageRepository, UserService userService) {
        this.imageRepository = imageRepository;
        this.userService = userService;
    }

    public Image saveImage(MultipartFile file) throws IOException {
        User loggedInUser = userService.getLoggedInUser();
        Image image = new Image();
        image.setUser(loggedInUser);
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        Image savedImage = imageRepository.save(image);
        loggedInUser.setPhoto(savedImage);
        userService.updateUser(loggedInUser);

        return savedImage;
    }


    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public ResponseEntity<ByteArrayResource> getImageById(Long id) {
        return imageRepository.findById(id)
                .map(image -> ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                        .body(new ByteArrayResource(image.getData())))
                .orElse(ResponseEntity.notFound().build());
    }
}
