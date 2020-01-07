package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.cruise_company_on_spring.entity.Seaport;

import java.util.List;
import java.util.Optional;

public interface SeaportRepository extends JpaRepository<Seaport, Long> {
    List<Seaport> findAllByOrderByNameEnAsc();

    List<Seaport> findByCountryEn(String countryEn);
    List<Seaport> findByCountryUkr(String countryUkr);

    Optional<Seaport> findByNameEn(String nameEn);
    Optional<Seaport> findByNameUkr(String nameUkr);
}