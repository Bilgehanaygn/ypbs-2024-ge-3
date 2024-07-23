package user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjeRepository extends JpaRepository<Proje, Long> {
    Proje findByName(String name);
}
