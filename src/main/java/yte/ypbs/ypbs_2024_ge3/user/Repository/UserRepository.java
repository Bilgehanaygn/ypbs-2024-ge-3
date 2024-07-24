package yte.ypbs.ypbs_2024_ge3.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE MONTH(u.dogumTarihi) = :month AND DAY(u.dogumTarihi) = :day")
    List<User> findByBirthdayMonthAndDay(@Param("month") int month, @Param("day") int day);

    @Query(value = "SELECT concat(u.isim, ' ', u.soyisim) as nameSurname, k.unvan as unvan, k.gorev as gorev, k.birim as birim, k.proje as proje, u.email as email, u.telefon as telefon " +
            "FROM User u JOIN Kurumsal k ON k.user = u " +
            "WHERE CONCAT(u.isim, ' ', u.soyisim) LIKE %:name_surname% " +
            "AND k.unvan LIKE %:unvan% " +
            "AND k.gorev LIKE %:gorev% " +
            "AND k.birim LIKE %:birim% " +
            "AND k.proje LIKE %:proje%"
    )
    List<Map<String, Object>> searchUsersWithFilters(@Param("name_surname") String nameSurname,
                                               @Param("unvan") String unvan,
                                               @Param("gorev") String gorev,
                                               @Param("birim") String birim,
                                               @Param("proje") String proje);


}
