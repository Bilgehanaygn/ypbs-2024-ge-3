package yte.ypbs.ypbs_2024_ge3.common.populator;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.ypbs.ypbs_2024_ge3.Organization.OrganizationRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalProjeRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.KurumsalRepository;
import yte.ypbs.ypbs_2024_ge3.user.repository.ProjeRepository;
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

        Proje mgm = new Proje("MGM", "Team A", LocalDate.of(2020, 2,2), LocalDate.of(2020, 2,2));
        Proje eTedarik = new Proje("E-Tedarik", "Team B", LocalDate.of(2020, 2,2), LocalDate.of(2020, 2,2));
        Proje pybs = new Proje("PYBS", "Team C", LocalDate.of(2020, 2,2), LocalDate.of(2020, 2,2));
        projeRepository.saveAll(List.of(mgm, eTedarik, pybs));

        User cemre = new User("Cemre",
                "Çelik",
                "a",
                passwordEncoder.encode("a"),
                "cemre.celik@tubitak.gov.tr",
                "065555555555", LocalDate.of(1990, 5, 15),
                null, Set.of());
        User serkan = new User("Serkan",
                "Yılmaz",
                "b",
                passwordEncoder.encode("123"),
                "serkan.yilmaz@tubitak.gov.tr",
                "05345812322", LocalDate.of(2003, 4, 14),
                null, Set.of());

        userRepository.saveAll(List.of(cemre,serkan));

        Kurumsal kurumsalCemre = new Kurumsal(cemre,
                "Uzman Araştırmacı",
                organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(),
                null);
        Kurumsal kurumsalSerkan = new Kurumsal(serkan,
                "Stajyer",
                organizationRepository.findByName("Yazılım Geliştirme Teknolojileri EMY").orElseThrow(),
                null);

        kurumsalRepository.saveAll(List.of(kurumsalCemre,kurumsalSerkan));

        KurumsalProje kurumsalProje1 = new KurumsalProje(kurumsalCemre, mgm, "İş Analisti");
        KurumsalProje kurumsalProje2 = new KurumsalProje(kurumsalCemre, eTedarik, "Proje Yönetici Yrd.");
        KurumsalProje kurumsalProje3 = new KurumsalProje(kurumsalCemre, pybs, "Mentör");
        KurumsalProje kurumsalProje4 = new KurumsalProje(kurumsalSerkan,pybs, "Full-Stack Developer");
        kurumsalProjeRepository.saveAll(List.of(kurumsalProje1, kurumsalProje2, kurumsalProje3, kurumsalProje4));

        Proje project1 = new Proje("CRM System", "Team A");
        Proje project2 = new Proje("HR Management", "Team B");
        Proje project3 = new Proje("Supply Chain", "Team C");
        Proje project4 = new Proje("E-Commerce Platform", "Team A");
        Proje project5 = new Proje("Data Analytics", "Team D");

// Saving additional Proje instances
        projeRepository.saveAll(List.of(project1, project2, project3, project4, project5));

        User alice = new User("Alice",
                "Johnson",
                "alice.johnson",
                passwordEncoder.encode("password123"),
                "alice.johnson@company.com",
                "05412345678", LocalDate.of(1985, 1, 20),
                null, Set.of());
        User bob = new User("Bob",
                "Smith",
                "bob.smith",
                passwordEncoder.encode("securePass"),
                "bob.smith@company.com",
                "05498765432", LocalDate.of(1992, 6, 30),
                null, Set.of());
        User charlie = new User("Charlie",
                "Brown",
                "charlie.brown",
                passwordEncoder.encode("charliePass"),
                "charlie.brown@company.com",
                "05466677889", LocalDate.of(1998, 11, 10),
                null, Set.of());
        User diana = new User("Diana",
                "Prince",
                "diana.prince",
                passwordEncoder.encode("wonderWoman"),
                "diana.prince@company.com",
                "05333344455", LocalDate.of(1989, 3, 8),
                null, Set.of());
        User edward = new User("Edward",
                "Kenway",
                "edward.kenway",
                passwordEncoder.encode("pirate123"),
                "edward.kenway@company.com",
                "05411223344", LocalDate.of(1995, 7, 17),
                null, Set.of());

// Saving additional User instances
        userRepository.saveAll(List.of(alice, bob, charlie, diana, edward));


        Kurumsal kurumsalAlice = new Kurumsal(alice,
                "Project Manager",
                organizationRepository.findByName("İş Gelistirme ve Sözleşme Birimi").orElseThrow(),
                null);
        Kurumsal kurumsalBob = new Kurumsal(bob,
                "Software Engineer",
                organizationRepository.findByName("İnsan Kaynakları").orElseThrow(),
                null);
        Kurumsal kurumsalCharlie = new Kurumsal(charlie,
                "Data Analyst",
                organizationRepository.findByName("Yazılım Geliştirme").orElseThrow(),
                null);
        Kurumsal kurumsalDiana = new Kurumsal(diana,
                "UX Designer",
                organizationRepository.findByName("Dijital Strateji ve  Dönüşüm Planlama").orElseThrow(),
                null);
        Kurumsal kurumsalEdward = new Kurumsal(edward,
                "Network Engineer",
                organizationRepository.findByName("Yazılım Geliştirme Teknolojileri EMY").orElseThrow(),
                null);

// Saving additional Kurumsal instances
        kurumsalRepository.saveAll(List.of(kurumsalAlice, kurumsalBob, kurumsalCharlie, kurumsalDiana, kurumsalEdward));

        KurumsalProje kurumsalProje5 = new KurumsalProje(kurumsalAlice, project1, "Project Lead");
        KurumsalProje kurumsalProje6 = new KurumsalProje(kurumsalBob, project2, "Backend Developer");
        KurumsalProje kurumsalProje7 = new KurumsalProje(kurumsalCharlie, project3, "Data Specialist");
        KurumsalProje kurumsalProje8 = new KurumsalProje(kurumsalDiana, project4, "UI/UX Designer");
        KurumsalProje kurumsalProje9 = new KurumsalProje(kurumsalEdward, project5, "System Administrator");
        KurumsalProje kurumsalProje10 = new KurumsalProje(kurumsalBob, project1, "Frontend Developer");
        KurumsalProje kurumsalProje11 = new KurumsalProje(kurumsalCharlie, project5, "Data Analyst");
        KurumsalProje kurumsalProje12 = new KurumsalProje(kurumsalDiana, project2, "UX Consultant");
        KurumsalProje kurumsalProje13 = new KurumsalProje(kurumsalEdward, project3, "Network Architect");

// Saving additional KurumsalProje instances
        kurumsalProjeRepository.saveAll(List.of(kurumsalProje5, kurumsalProje6, kurumsalProje7, kurumsalProje8, kurumsalProje9, kurumsalProje10, kurumsalProje11, kurumsalProje12, kurumsalProje13));

    }
}