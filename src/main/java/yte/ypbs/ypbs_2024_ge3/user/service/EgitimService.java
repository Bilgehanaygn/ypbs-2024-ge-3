package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.EgitimRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.request.EgitimRequest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EgitimService {

    private final UserService userService;
    private final EgitimRepository egitimRepository;
    private final UserRepository userRepository;

    public EgitimService(UserService userService, UserRepository userRepository, EgitimRepository egitimRepository) {
        this.userService = userService;
        this.egitimRepository = egitimRepository;
        this.userRepository = userRepository;
    }

    //Returns the Authenticated User's egitim
    public Set<Egitim> getUserEgitim() {

        User user = userService.getUser();
        Set<Egitim> egitimSet = user.getEgitim();

        return egitimSet;
    }

    public Set<Egitim> getUserEgitim(String username) {

        User user = userService.getUser(username);
        Set<Egitim> egitimSet = user.getEgitim();

        return egitimSet;
    }


    @Transactional
    public void updateUserEgitim(List<EgitimRequest> egitimRequests) {

        User user = userService.getUser();

        Set<Egitim> egitims = egitimRequests.stream().map(EgitimRequest::toEgitim).collect(Collectors.toSet());
        user.setEgitim(egitims);

        userService.updateUser(user);
    }

    @Transactional
    public void deleteUserEgitim(Long id) {
        User user = userService.getUser();

        user.removeEgitim(egitimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id" + id)));
        userRepository.save(user);
    }
}
