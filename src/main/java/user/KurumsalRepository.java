package user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KurumsalRepository extends JpaRepository<Kurumsal, Long> {
    Kurumsal findByName(String name);
}
