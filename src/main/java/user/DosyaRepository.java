package user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DosyaRepository extends JpaRepository<Dosya, Long> {
    Dosya findByName(String name);
}
