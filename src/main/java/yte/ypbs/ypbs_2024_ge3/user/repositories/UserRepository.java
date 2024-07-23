package yte.ypbs.ypbs_2024_ge3.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.ypbs.ypbs_2024_ge3.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
