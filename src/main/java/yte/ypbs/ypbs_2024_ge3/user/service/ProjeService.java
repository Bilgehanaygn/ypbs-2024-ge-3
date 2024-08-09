package yte.ypbs.ypbs_2024_ge3.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.ypbs.ypbs_2024_ge3.user.controller.request.UsersProjeRequest;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper;
import yte.ypbs.ypbs_2024_ge3.user.repository.ProjeRepository;

import java.util.List;

import static yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper.toNewProje;
import static yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper.toProjeEntity;

@Service
public class ProjeService {

    private final UserService userService;
    private final ProjeRepository projeRepository;

    public ProjeService(UserService userService, ProjeRepository projeRepository) {
        this.userService = userService;
        this.projeRepository = projeRepository;
    }

    public List<UsersProjeResponse> getUserProje() {
        List<Proje> projecList = userService.getUser().getKurumsal().getProjects();
        return  projecList.stream().map(ProjeMapper::toUsersProjeResponse).toList();
    }

    @Transactional
    public void updateUserProje(Long id, UsersProjeRequest projeRequest){
        Proje proje = projeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Proje id: "+id));
        toProjeEntity(proje, projeRequest);
        projeRepository.save(proje);
    }

    @Transactional
    public void deleteUserProje(Long id){
        userService.getUser().getKurumsal().getProjects().remove(
                projeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Proje id: "+id))
        );
        projeRepository.deleteById(id);
    }

    @Transactional
    public void addUserProje(UsersProjeRequest projeRequest){
        Proje proje = toNewProje(projeRequest);
        projeRepository.save(proje);
        userService.getUser().getKurumsal().getProjects().add(proje);
    }
}
