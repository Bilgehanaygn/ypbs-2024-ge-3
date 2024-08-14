package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersDosyaRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersDosyaFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Dosya;
import yte.ypbs.ypbs_2024_ge3.user.enums.DosyaTuru;
import yte.ypbs.ypbs_2024_ge3.user.mapper.DosyaMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.DosyaRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.DosyaMapper.toNewDosya;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.DosyaMapper.toUsersDosyaFileResponse;

@Service
public class DosyaService {

    private final UserService userService;
    private final DosyaRepository dosyaRepository;

    public DosyaService(UserService userService, DosyaRepository dosyaRepository) {
        this.userService = userService;
        this.dosyaRepository = dosyaRepository;
    }

    public List<UsersDosyaDetailResponse> getUserDosyaDetails() {
        Set<Dosya> dosyaSet = userService.getLoggedInUser().getDosyalar();
        return dosyaSet.stream().map(DosyaMapper::toUsersDosyaDetailResponse).toList();
    }

    public UsersDosyaFileResponse getUserDosyaFile(Long id) {
        Dosya dosya = dosyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Dosyal Not Found"));
        return toUsersDosyaFileResponse(dosya);
    }

    public List<String> getDosyaEnums() {
        return Stream.of(DosyaTuru.values()).map(Enum::name).toList();
    }

    @Transactional
    public void deleteUserDosya(Long id){
        userService.getLoggedInUser().removeDosya(dosyaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dosyal Not Found")));
        dosyaRepository.deleteById(id);
    }

    @Transactional
    public void storeUserDosya(UsersDosyaRequest usersDosyaRequest) throws IOException {
        Dosya newDosya = toNewDosya(usersDosyaRequest);
        dosyaRepository.save(newDosya);
        userService.getLoggedInUser().addDosya(newDosya);
    }
}
