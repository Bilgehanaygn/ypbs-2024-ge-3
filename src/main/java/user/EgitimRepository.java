package user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EgitimRepository extends JpaRepository<Egitim, Long> {
    Egitim findByName(String name);
}
