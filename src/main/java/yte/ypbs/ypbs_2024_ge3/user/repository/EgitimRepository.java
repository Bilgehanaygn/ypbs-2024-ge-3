package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.ypbs.ypbs_2024_ge3.user.entity.Egitim;

import java.util.Optional;

public interface EgitimRepository extends JpaRepository<Egitim, Long> {
    Optional<Egitim> findById(Long id);
}
