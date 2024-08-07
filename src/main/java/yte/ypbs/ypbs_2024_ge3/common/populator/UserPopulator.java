package yte.ypbs.ypbs_2024_ge3.common.populator;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.Dosya;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.enums.DosyaTuru;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Configuration
public class UserPopulator {
    private final UserRepository userRepository;
    private final KurumsalRepository kurumsalRepository;
    private final OrganizationPopulator organizationPopulator;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserPopulator(UserRepository userRepository , KurumsalRepository kurumsalRepository, OrganizationPopulator organizationPopulator, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.kurumsalRepository = kurumsalRepository;
        this.organizationPopulator = organizationPopulator;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @PostConstruct
    public void populateUsers() {

        organizationPopulator.populate();


        User user1 = new User(
                "Cemre",
                "Çelik",
                "a",
                passwordEncoder.encode("a"),
                "cemre.celik@tubitak.gov.tr",
                "065555555555",
                LocalDate.of(2020, 7, 24),
                null,
                Set.of(new Dosya(DosyaTuru.CV,"cv deneme","denene dosya", null),
                        new Dosya(DosyaTuru.DIPLOMA,"diploma deneme","diploma dosya", null))
                );

        userRepository.save(user1);

        Kurumsal kurumsal1 = new Kurumsal(
                user1,
                "Uzman Araştırmacı",
                organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(),
                List.of(new Proje("proje adi", "takim","görev", LocalDate.of(2020, 12, 12), LocalDate.of(2020, 12, 12)),
                        new Proje("proje adı 2", " takim 2", "görev 23", LocalDate.of(2020, 12, 12), LocalDate.of(2020, 12, 12)),
                        new Proje("proje 3"," takim3", "gorev3", LocalDate.of(2020, 12, 12), LocalDate.of(2020, 12, 12)))
        );
        kurumsalRepository.save(kurumsal1);



    }
}