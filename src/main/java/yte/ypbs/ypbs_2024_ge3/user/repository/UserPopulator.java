package yte.ypbs.ypbs_2024_ge3.user.repository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationPopulator;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.time.LocalDate;
import java.util.List;

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


        User user1 = new User("Cemre", "Çelik", "cemrecelik",passwordEncoder.encode("cemre"), "cemre.celik@tubitak.gov.tr", "065555555555", LocalDate.of(2020, 7, 24), null);

        userRepository.save(user1);

        Kurumsal kurumsal1 = new Kurumsal(
                user1,
                "Uzman Araştırmacı",
                organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(),
                List.of(new Proje("proje adi", "takim","görev"),
                        new Proje("proje adı 2", " takim 2", "görev 23"),
                        new Proje("proje 3","takim3","gorev3"))
        );
        kurumsalRepository.save(kurumsal1);



    }
}