package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.controller.response.UserHeaderResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KurumsalService {
    private KurumsalRepository kurumsalRepository;

    public KurumsalService(KurumsalRepository kurumsalRepository) {
        this.kurumsalRepository = kurumsalRepository;
    }

    public List<String> findUnvans() {
        return kurumsalRepository.findAll()
                .stream()
                .map(Kurumsal::getUnvan)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }

    public List<String> findBirims() {
        return kurumsalRepository.findAll()
                .stream()
                .map(kurumsal -> kurumsal.getBirim().getName())
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }
}

