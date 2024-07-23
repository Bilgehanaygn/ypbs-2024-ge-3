package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.Kurumsal;

public interface KurumsalRepository extends JpaRepository<Kurumsal, Long> {
    Kurumsal findByName(String name);
}
