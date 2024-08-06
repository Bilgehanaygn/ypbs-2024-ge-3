package yte.ypbs.ypbs_2024_ge3.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalProjeRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;
import yte.ypbs.ypbs_2024_ge3.user.response.UserDataResponse;
import yte.ypbs.ypbs_2024_ge3.user.response.UserHeaderResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KurumsalProjeService {
    private KurumsalProjeRepository kurumsalProjeRepository;

    public KurumsalProjeService(KurumsalProjeRepository kurumsalProjeRepository) {
        this.kurumsalProjeRepository = kurumsalProjeRepository;
    }

    public List<String> findGorevs() {
        return kurumsalProjeRepository.findAll()
                .stream()
                .map(KurumsalProje::getGorev)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }

}

