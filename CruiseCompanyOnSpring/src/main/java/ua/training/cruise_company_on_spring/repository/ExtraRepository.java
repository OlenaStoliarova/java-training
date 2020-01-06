package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.cruise_company_on_spring.entity.Extra;

import java.util.Optional;

public interface ExtraRepository extends JpaRepository<Extra, Long> {
    Optional<Extra> findByNameEn(String nameEn);
}
