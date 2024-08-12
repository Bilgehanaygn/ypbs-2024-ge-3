package yte.ypbs.ypbs_2024_ge3.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByName(String name);

    @Query("SELECT DISTINCT o.name FROM Organization o JOIN o.kurumsals ORDER BY o.name ASC")
    List<String> findDistinctAndSortedOrganizationsThatHaveEmployee();
}
