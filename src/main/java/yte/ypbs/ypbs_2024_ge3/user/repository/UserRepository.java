package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "LEFT JOIN u.kurumsal k " +
            "LEFT JOIN k.birim b " +
            "LEFT JOIN k.kurumsalProjeler kp " +
            "LEFT JOIN kp.proje p " +
            "WHERE LOWER(CONCAT(u.isim, ' ', u.soyisim)) LIKE LOWER(CONCAT('%', :nameSurname, '%')) " +
            "AND (:unvan IS NULL OR LOWER(k.unvan) LIKE LOWER(CONCAT('%', :unvan, '%'))) " +
            "AND (:birim IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :birim, '%'))) " +
            "AND (:gorev IS NULL OR LOWER(kp.gorev) LIKE LOWER(CONCAT('%', :gorev, '%'))) " +
            "AND (:proje IS NULL OR LOWER(p.projeAdi) LIKE LOWER(CONCAT('%', :proje, '%')))"+
            "AND (:takim IS NULL OR LOWER(p.takim) LIKE LOWER(CONCAT('%', :takim, '%')))")
    List<User> findUsersWithFilters(
            @Param("nameSurname") String nameSurname,
            @Param("birim") String birim,
            @Param("unvan") String unvan,
            @Param("gorev") String gorev,
            @Param("proje") String proje,
            @Param("takim") String takim
    );

    /*
     * Katkı ve Takım araması yapmıyor. Düzeltilmeli.
     */
}
