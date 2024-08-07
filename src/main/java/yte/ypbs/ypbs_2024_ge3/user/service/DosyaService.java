package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDosyaRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Dosya;
import yte.ypbs.ypbs_2024_ge3.user.mapper.DosyaMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.DosyaRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.DosyaMapper.toNewDosya;

@Service
public class DosyaService {

    private final UserService userService;
    private final DosyaRepository dosyaRepository;

    public DosyaService(UserService userService, DosyaRepository dosyaRepository) {
        this.userService = userService;
        this.dosyaRepository = dosyaRepository;
    }

    public List<UsersDosyaDetailResponse> getUserDosyaDetails() {
        Set<Dosya> dosyaSet = userService.getUser().getDosyalar();
        return dosyaSet.stream().map(DosyaMapper::toUsersDosyaDetailResponse).toList();
    }

    public UsersDosyaFileResponse getUserDosyaFile(Long id) {
        Dosya dosya = dosyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Dosyal Not Found"));

    }

    @Transactional
    public void storeUserDosya(UsersDosyaRequest usersDosyaRequest) throws IOException {
        Dosya newDosya = toNewDosya(usersDosyaRequest);
        dosyaRepository.save(newDosya);
        userService.getUser().addDosya(newDosya);
    }
}
