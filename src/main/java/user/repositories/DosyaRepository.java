package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Dosya;

public interface DosyaRepository extends JpaRepository<Dosya, Long> {
    Dosya findByName(String name);
}
