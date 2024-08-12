package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.controller.ProjeController;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.ProjeRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjeService{
    private ProjeRepository projeRepository;

    public ProjeService(ProjeRepository projeRepository) {
        this.projeRepository = projeRepository;
    }

    public List<String> findProjectNames() {
        return projeRepository.findDistinctAndSortedProjectNames();
    }

    public List<String> findTeams() {
        return projeRepository.findDistinctAndSortedTeams();
    }
}

