package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersProjeRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.mapper.KurumsalProjeMapper;
import yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalProjeRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.ProjeRepository;

import java.util.List;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.KurumsalProjeMapper.toKurumsalProjeEntity;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper.toNewProje;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper.toProjeEntity;

@Service
public class ProjeService {

    private final UserService userService;
    private final ProjeRepository projeRepository;
    private final KurumsalProjeRepository kurumsalProjeRepository;

    public ProjeService(UserService userService, ProjeRepository projeRepository, KurumsalProjeRepository kurumsalProjeRepository) {
        this.userService = userService;
        this.projeRepository = projeRepository;
        this.kurumsalProjeRepository = kurumsalProjeRepository;
    }

    public List<UsersProjeResponse> getUserProje() { //Returns Users enrolled project details
        return userService.getUser().getKurumsal().getKurumsalProjeler().stream().map(KurumsalProjeMapper::toUsersProjeResponse).toList();
    }

    @Transactional
    public void updateUserProje(Long id, UsersProjeRequest projeRequest){ //Right now this modify's project details thorugh user it should be changed after discuss
        KurumsalProje kurumsalProje = kurumsalProjeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        toKurumsalProjeEntity(kurumsalProje, projeRequest);
        kurumsalProjeRepository.save(kurumsalProje);
    }

    @Transactional
    public void deleteUserProje(Long id){ //Only removes the user from project doesnt delete project just cuts the connections between user
        userService.getUser().getKurumsal().getKurumsalProjeler().remove(
                kurumsalProjeRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
        kurumsalProjeRepository.deleteById(id);
    }

    @Transactional
    public void addUserProje(UsersProjeRequest projeRequest){ // This should add user to an existing projects it should also take the project id however Project creating is not done so empty
//        Proje proje = toNewProje(projeRequest);
//        projeRepository.save(proje);
//        userService.getUser().getKurumsal().getProjects().add(proje);
    }
}
