package yte.ypbs.ypbs_2024_ge3.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import yte.ypbs.ypbs_2024_ge3.User.Entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE MONTH(u.birthDate) = :month AND DAY(u.birthDate) = :day")
    List<User> findByBirthdayMonthAndDay(@Param("month") int month, @Param("day") int day);
}
