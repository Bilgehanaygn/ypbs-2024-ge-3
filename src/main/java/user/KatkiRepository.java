package user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KatkiRepository extends JpaRepository<Katki, Long> {
    Katki findByName(String name);
}
