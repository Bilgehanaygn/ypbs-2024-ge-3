package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersEgitimResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;
import yte.ypbs.ypbs_2024_ge3.user.mapper.EgitimMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.EgitimRepository;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersEgitimResponse;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.EgitimMapper.toEgitimEntity;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.EgitimMapper.toNewEgitim;

@Service
public class EgitimService {

    private final UserService userService;
    private final EgitimRepository egitimRepository;

    public EgitimService(UserService userService, EgitimRepository egitimRepository) {
        this.userService = userService;
        this.egitimRepository = egitimRepository;
    }

    //Returns the Authenticated User's egitim
    public List<UsersEgitimResponse> getUserEgitim() {

        Set<Egitim> egitimSet = userService.getLoggedInUser().getEgitim();
        return egitimSet.stream().map(EgitimMapper::toUsersEgitimResponse).toList();
    }

    public Set<Egitim> getUserEgitim(String username) {
        return userService.getLoggedInUser(username).getEgitim();
    }

    public List<String> getEgitimEnums() {
        return Stream.of(EgitimTuru.values()).map(Enum::name).toList();
    }


    @Transactional
    public void updateUserEgitim(Long id, EgitimRequest egitimRequests) {

        Egitim egitim = egitimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Egitim not found with id: " + id));
        toEgitimEntity(egitim, egitimRequests);
        egitimRepository.save(egitim);
    }

    @Transactional
    public void deleteUserEgitim(Long id) {

        userService.getLoggedInUser().removeEgitim(egitimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Egitim not found with id: " + id)));
        egitimRepository.deleteById(id);
    }

    @Transactional
    public void addUserEgitim(EgitimRequest egitimRequests) {
        Egitim newEgitim = toNewEgitim(egitimRequests);
        egitimRepository.save(newEgitim);
        userService.getLoggedInUser().addEgitim(newEgitim);
    }
}
