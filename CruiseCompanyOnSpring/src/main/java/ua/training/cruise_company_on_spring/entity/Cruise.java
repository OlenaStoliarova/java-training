package ua.training.cruise_company_on_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor

@Entity
@Table(name="cruise")
public class Cruise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ship_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ship ship;

    @Column(nullable = false)
    private LocalDate startingDate;
    @Column(nullable = false)
    private LocalDate finishingDate;

    @Column(nullable = false)
    private BigDecimal firstClassPrice;
    @Column(nullable = false)
    private BigDecimal secondClassPrice;
    @Column(nullable = false)
    private BigDecimal thirdClassPrice;

    @Column(nullable = false)
    private int vacanciesInFirstClass;
    @Column(nullable = false)
    private int vacanciesInSecondClass;
    @Column(nullable = false)
    private int vacanciesInThirdClass;

    public Cruise() {
        ship = new Ship();
    }
}
