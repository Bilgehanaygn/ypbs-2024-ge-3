package yte.ypbs.ypbs_2024_ge3.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.ypbs.ypbs_2024_ge3.user.entity.Proje;

import java.util.List;

public interface ProjeRepository extends JpaRepository<Proje, Long> {

    @Query("SELECT DISTINCT p.projeAdi FROM Proje p ORDER BY p.projeAdi ASC")
    List<String> findDistinctAndSortedProjectNames();

    @Query("SELECT DISTINCT p.takim FROM Proje p ORDER BY p.takim ASC")
    List<String> findDistinctAndSortedTeams();
}