package yte.ypbs.ypbs_2024_ge3.born_this_month.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yte.ypbs.ypbs_2024_ge3.user.entity.User;

import java.util.List;

@Repository
public interface BornThisMonthRepository extends JpaRepository<User, Long> {


    List<User> findByDogumTarihiAyDegeri(int month);
}
