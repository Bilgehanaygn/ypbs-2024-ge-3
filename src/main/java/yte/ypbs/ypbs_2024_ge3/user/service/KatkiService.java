package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersKatkiRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiDetailResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersKatkiFileResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Katki;
import yte.ypbs.ypbs_2024_ge3.user.enums.EtkinlikTuru;
import yte.ypbs.ypbs_2024_ge3.user.mapper.KatkiMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.KatkiRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.KatkiMapper.*;

@Service
public class KatkiService {

    private final UserService userService;
    private final KatkiRepository katkiRepository;

    public KatkiService(UserService userService, KatkiRepository katkiRepository) {
        this.userService = userService;
        this.katkiRepository = katkiRepository;
    }

    public List<UsersKatkiDetailResponse> getUserKatkiDetails() {
        Set<Katki> katkiSet = userService.getLoggedInUser().getKatkilar();
        return katkiSet.stream().map(KatkiMapper::toUsersKatkiDetailResponse).toList();
    }

    public UsersKatkiFileResponse getUserKatkiFile(Long id) {
        Katki katki = katkiRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Katki not found"));
        return toUsersKatkiFileResponse(katki);
    }

    public List<String> getKatkiEnums(){
        return Stream.of(EtkinlikTuru.values()).map(Enum::name).toList();
    }

    @Transactional
    public void updateUserKatki(Long id, UsersKatkiRequest katkiRequest) {
        Katki katki = katkiRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Katki not found"));
        try {
            toKatkiEntity(katki, katkiRequest);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        katkiRepository.save(katki);
    }

    @Transactional
    public void deleteUserKatki(Long id) {
        userService.getLoggedInUser().removeKatki(katkiRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Katki not found")));
        katkiRepository.deleteById(id);
    }

    @Transactional
    public void addUserKatki(UsersKatkiRequest katkiRequest) throws IOException {
        Katki katki = toNewKatki(katkiRequest);
        katkiRepository.save(katki);
        userService.getLoggedInUser().addKatki(katki);
    }

}
