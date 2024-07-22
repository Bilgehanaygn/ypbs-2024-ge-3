package yte.ypbs.ypbs_2024_ge3.Organization;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByName(String name);
}
