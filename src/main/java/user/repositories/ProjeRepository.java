package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Proje;

public interface ProjeRepository extends JpaRepository<Proje, Long> {
    Proje findByName(String name);
}
