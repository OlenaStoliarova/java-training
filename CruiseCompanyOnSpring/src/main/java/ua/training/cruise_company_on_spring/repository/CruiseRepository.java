package ua.training.cruise_company_on_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.training.cruise_company_on_spring.entity.Cruise;

import java.time.LocalDate;
import java.util.List;

public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    List<Cruise> findAllByOrderByStartingDateAsc();

    List<Cruise> findByStartingDateGreaterThanEqual(LocalDate date);

    @Query(value = "SELECT * FROM cruise_company.cruise " +
            "WHERE ship_id=?1 AND " +
            "(((starting_date < ?2) AND (finishing_date > ?2))" +
            "OR" +
            "((starting_date < ?3) AND (finishing_date > ?3)))",
            nativeQuery = true)
    List<Cruise> findCollisionOnAddNew(Long shipId, LocalDate newStart, LocalDate newEnd);

}
