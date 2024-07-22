package yte.ypbs.ypbs_2024_ge3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import yte.ypbs.ypbs_2024_ge3.customUser.CustomUserRepository;

import java.util.List;

@Configuration
public class TempDatabasePopulate {

    private CustomUserRepository CustomUserRepository;

    public TempDatabasePopulate(CustomUserRepository customUserRepository) {
        this.CustomUserRepository = customUserRepository;
    }

    @PostConstruct
    public void populate(){
    }
}
