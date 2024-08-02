package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.enums.EgitimTuru;
import yte.ypbs.ypbs_2024_ge3.user.repository.EgitimRepository;
import yte.ypbs.ypbs_2024_ge3.user.request.EgitimRequest;
import yte.ypbs.ypbs_2024_ge3.user.response.EgitimResponse;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class EgitimService {

    private final UserService userService;
    private final EgitimRepository egitimRepository;

    public EgitimService(UserService userService, EgitimRepository egitimRepository) {
        this.userService = userService;
        this.egitimRepository = egitimRepository;
    }

    //Returns the Authenticated User's egitim
    public List<EgitimResponse> getUserEgitim() {

        Set<Egitim> egitimSet = userService.getUser().getEgitim();
        return egitimSet.stream().map(Egitim::toEgitimResponse).toList();
    }

    public Set<Egitim> getUserEgitim(String username) {
        return userService.getUser(username).getEgitim();
    }

    public List<String> getEgitimEnums(){
        return Stream.of(EgitimTuru.values()).map(Enum::name).toList();
    }


    @Transactional
    public void updateUserEgitim(Long id, EgitimRequest egitimRequests) {

        Egitim egitim = egitimRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Egitim not found with id: " + id));
        egitim.setFromEgitimRequest(egitimRequests);
        egitimRepository.save(egitim);
    }

    @Transactional
    public void deleteUserEgitim(Long id) {

        userService.getUser().removeEgitim(egitimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Egitim not found with id: " + id)));
        egitimRepository.delete(egitimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Egitim not found with id: " + id)));
    }

    @Transactional
    public void addUserEgitim(EgitimRequest egitimRequests) {
        Egitim newEgitim = egitimRequests.toNewEgitim();
        egitimRepository.save(newEgitim);
        userService.getUser().addEgitim(newEgitim);
    }
}
