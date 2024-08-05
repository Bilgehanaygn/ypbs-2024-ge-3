package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;
import yte.ypbs.ypbs_2024_ge3.user.response.UserDataResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "JOIN u.kurumsal k " +
            "LEFT JOIN k.birim b " +
            "LEFT JOIN k.projects p " +
            "WHERE LOWER(CONCAT(u.isim, ' ', u.soyisim)) LIKE LOWER(CONCAT('%', :nameSurname, '%')) " +
            "AND (:unvan IS NULL OR LOWER(k.unvan) LIKE LOWER(CONCAT('%', :unvan, '%'))) " +
            "AND (:birim IS NULL OR LOWER(b.name) LIKE LOWER(CONCAT('%', :birim, '%'))) " +
            "AND (:gorev IS NULL OR LOWER(p.gorev) LIKE LOWER(CONCAT('%', :gorev, '%'))) " +
            "AND (:proje IS NULL OR LOWER(p.projeAdi) LIKE LOWER(CONCAT('%', :proje, '%')))")
    List<User> findUsersWithFilters(
            @Param("nameSurname") String nameSurname,
            @Param("unvan") String unvan,
            @Param("birim") String birim,
            @Param("gorev") String gorev,
            @Param("proje") String proje
    );

    /*
     * Katkı ve Takım araması yapmıyor. Düzeltilmeli.
     */
}
