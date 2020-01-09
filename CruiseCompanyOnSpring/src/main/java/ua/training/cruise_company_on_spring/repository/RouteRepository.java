package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.cruise_company_on_spring.entity.Route;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByOrderByNameEnAsc();
    List<Route> findAllByOrderByDurationDaysAsc();

    Optional<Route> findByNameEn(String nameEn);
}
