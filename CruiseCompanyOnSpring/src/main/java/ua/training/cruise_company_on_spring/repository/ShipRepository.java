package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.cruise_company_on_spring.entity.Ship;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findAllByOrderByName();

    Optional<Ship> findByName(String name);
}
