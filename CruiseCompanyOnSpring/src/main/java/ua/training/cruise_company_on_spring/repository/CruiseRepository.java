package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.cruise_company_on_spring.entity.Cruise;

import java.time.LocalDate;
import java.util.List;

public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    List<Cruise> findAllByOrderByStartingDateAsc();

    List<Cruise> findByStartingDateGreaterThanEqualOrderByStartingDateAsc(LocalDate date);
    List<Cruise> findAllByStartingDateGreaterThanEqualAndVacanciesGreaterThanOrderByStartingDateAsc(LocalDate date, int minVacancies);
}
