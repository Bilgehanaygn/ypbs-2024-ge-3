package yte.ypbs.ypbs_2024_ge3.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.ypbs.ypbs_2024_ge3.login.entity.CustomUser;

import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByUsername(String username);
}
