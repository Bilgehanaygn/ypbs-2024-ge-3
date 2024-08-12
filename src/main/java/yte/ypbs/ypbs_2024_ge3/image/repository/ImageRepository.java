package yte.ypbs.ypbs_2024_ge3.image.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import yte.ypbs.ypbs_2024_ge3.image.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
