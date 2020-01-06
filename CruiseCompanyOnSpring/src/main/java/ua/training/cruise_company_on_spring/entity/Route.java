package ua.training.cruise_company_on_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor

@Entity
@Table(name="route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nameEn;
    @Column(nullable = false)
    private String nameUkr;

    @Column(nullable = false)
    private int durationDays;
    @Column(nullable = false)
    private int durationNights;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "starting_seaport_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seaport startingAt;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "final_seaport_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seaport finishingAt;

    @ManyToMany
    @JoinTable(name = "route_seaport",
                joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "seaport_id", referencedColumnName = "id"))
    private Set<Seaport> intermediatePorts = new HashSet<>();

    public Route() {
        startingAt = new Seaport();
        finishingAt = new Seaport();
    }
}



