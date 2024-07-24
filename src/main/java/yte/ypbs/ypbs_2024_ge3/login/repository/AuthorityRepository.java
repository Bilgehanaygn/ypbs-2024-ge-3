package yte.ypbs.ypbs_2024_ge3.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.ypbs.ypbs_2024_ge3.login.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
