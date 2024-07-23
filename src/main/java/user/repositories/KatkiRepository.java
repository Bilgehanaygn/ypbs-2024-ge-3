package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Katki;

public interface KatkiRepository extends JpaRepository<Katki, Long> {
    Katki findByName(String name);
}
