package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Deneyim;

public interface DeneyimRepository extends JpaRepository<Deneyim, Long> {
    Deneyim findByName(String name);
}
