package yte.ypbs.ypbs_2024_ge3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUser;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUserRepository;

import java.util.List;

@Configuration
public class TempDatabasePopulate {

    private CustomUserRepository customUserRepository;

    public TempDatabasePopulate(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    CustomUser user1 = new CustomUser("user1","123", List.of());
    CustomUser user2 = new CustomUser("user2","123", List.of());
    CustomUser user3 = new CustomUser("user3","123", List.of());

    CustomUser admin1 = new CustomUser("admin1","123", List.of());
    CustomUser admin2 = new CustomUser("admin2","123", List.of());

    @PostConstruct
    public void populate(){
        customUserRepository.saveAll(List.of(user1,user2,user3, admin1, admin2));
    }
}
