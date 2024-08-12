package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.ypbs.ypbs_2024_ge3.user.entity.Kurumsal;

import java.util.List;

public interface KurumsalRepository extends JpaRepository<Kurumsal, Long> {

    @Query("SELECT DISTINCT k.unvan FROM Kurumsal k ORDER BY k.unvan ASC")
    List<String> findDistinctAndSortedUnvans();

}
