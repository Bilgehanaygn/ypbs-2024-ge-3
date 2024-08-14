package yte.ypbs.ypbs_2024_ge3.image.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yte.ypbs.ypbs_2024_ge3.image.entity.Image;
import yte.ypbs.ypbs_2024_ge3.image.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.saveImage(file);
    }

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable Long id) {
        return imageService.getImageById(id);
    }
}