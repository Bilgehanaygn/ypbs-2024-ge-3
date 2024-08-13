package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.ypbs.ypbs_2024_ge3.user.entity.KurumsalProje;

import java.util.List;

public interface KurumsalProjeRepository extends JpaRepository<KurumsalProje, Long> {

    @Query("SELECT DISTINCT kp.gorev FROM KurumsalProje kp ORDER BY kp.gorev ASC")
    List<String> findDistinctAndSortedGorevs();
}