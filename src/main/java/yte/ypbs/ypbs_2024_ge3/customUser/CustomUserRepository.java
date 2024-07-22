package yte.ypbs.ypbs_2024_ge3.customUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findByUsername(String username);
}
