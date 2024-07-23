package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Egitim;

public interface EgitimRepository extends JpaRepository<Egitim, Long> {
    Egitim findByName(String name);
}
