package yte.ypbs.ypbs_2024_ge3.user.repository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationPopulator;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserPopulator {
    private final UserRepository userRepository;
    private final KurumsalRepository kurumsalRepository;
    private final OrganizationPopulator organizationPopulator;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProjeRepository projeRepository;
    private final KurumsalProjeRepository kurumsalProjeRepository;


    @Autowired
    public UserPopulator(UserRepository userRepository , KurumsalRepository kurumsalRepository, OrganizationPopulator organizationPopulator, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder, ProjeRepository projeRepository, KurumsalProjeRepository kurumsalProjeRepository) {
        this.userRepository = userRepository;
        this.kurumsalRepository = kurumsalRepository;
        this.organizationPopulator = organizationPopulator;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
        this.projeRepository = projeRepository;
        this.kurumsalProjeRepository = kurumsalProjeRepository;
    }

    @Transactional
    @PostConstruct
    public void populateUsers() {

        organizationPopulator.populate();


//        User user1 = new User("Cemre", "Çelik", "cemrecelik",passwordEncoder.encode("cemre"), "cemre.celik@tubitak.gov.tr", "065555555555", LocalDate.of(2020, 7, 24), null);
//        User user2 = new User("Serkan", "Yılmaz", "serkanyilmaz",passwordEncoder.encode("123"), "serkan.yilmaz@tubitak.gov.tr", "05345812322", LocalDate.of(2003, 4, 14), null);
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//        Kurumsal kurumsal1 = new Kurumsal(
//                user1,
//                "Uzman Araştırmacı",
//                organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(),
//                List.of(new Proje("MGM", "A takımı","İş Analisti"),
//                        new Proje("E-Tedarik", "B takımı", "Proje Yönetici Yrd."),
//                        new Proje("proje 3","takim3","gorev3"))
//        );
//        Kurumsal kurumsal2 = new Kurumsal(
//                user2,
//                "Stajyer",
//                organizationRepository.findByName("Yazılım Geliştirme Teknolojileri EMY").orElseThrow(),
//                List.of(new Proje("YPBS", "GE3","Full-Stack Developer"))
//        );
//        kurumsalRepository.save(kurumsal1);
//        kurumsalRepository.save(kurumsal2);
        Proje projectAlpha = new Proje("Project Alpha", "Team A");
        Proje projectBeta = new Proje("Project Beta", "Team B");
        projeRepository.saveAll(List.of(projectAlpha, projectBeta));

        // Create sample users
        User user = new User("Cemre", "Çelik", "cemre.celik", "password123", "cemre.celik@tubitak.gov.tr", "065555555555", LocalDate.of(1990, 5, 15), null);
        userRepository.save(user);

        // Create sample kurumsal data
        Kurumsal kurumsal = new Kurumsal(user, "Researcher", organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(), null);
        kurumsalRepository.save(kurumsal);

        // Create sample kurumsal_proje data
        KurumsalProje kurumsalProje1 = new KurumsalProje(kurumsal, projectAlpha, "Lead Developer");
        KurumsalProje kurumsalProje2 = new KurumsalProje(kurumsal, projectBeta, "Project Manager");
        kurumsalProjeRepository.saveAll(List.of(kurumsalProje1, kurumsalProje2));


    }
}