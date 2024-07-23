package yte.ypbs.ypbs_2024_ge3.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yte.ypbs.ypbs_2024_ge3.user.Entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE MONTH(u.dogumTarihi) = :month AND DAY(u.dogumTarihi) = :day")
    List<User> findByBirthdayMonthAndDay(@Param("month") int month, @Param("day") int day);
}
