package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UsersProjeResponse;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.mapper.ProjeMapper;

import java.util.List;

@Service
public class ProjeService {

    private final UserService userService;

    public ProjeService(UserService userService) {
        this.userService = userService;
    }

    public List<UsersProjeResponse> getUserProje() {
        List<Proje> projecList = userService.getUser().getKurumsal().getProjects();
        return  projecList.stream().map(ProjeMapper::toUsersProjeResponse).toList();
    }
}
