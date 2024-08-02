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

    /*
     * Katkı ve Takım araması yapmıyor. Düzeltilmeli.
     */
    @Query("SELECT u " +
            "FROM User u JOIN Kurumsal k ON k.user = u " +
            "WHERE LOWER(CONCAT(u.isim, ' ', u.soyisim)) LIKE LOWER(CONCAT('%', :nameSurname, '%')) " +
            "AND LOWER(k.unvan) LIKE LOWER(CONCAT('%', :unvan, '%')) " +
            "AND LOWER(k.gorev) LIKE LOWER(CONCAT('%', :gorev, '%')) " +
            "AND LOWER(k.birim) LIKE LOWER(CONCAT('%', :birim, '%')) " +
            "AND LOWER(k.proje) LIKE LOWER(CONCAT('%', :proje, '%'))")
    List<User> findUsersWithFilters(@Param("nameSurname") String nameSurname,
                                      @Param("unvan") String unvan,
                                      @Param("gorev") String gorev,
                                      @Param("birim") String birim,
                                      @Param("proje") String proje);
}
