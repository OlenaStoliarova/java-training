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
@Table(name="ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int firstClassCapacity;
    @Column(nullable = false)
    private int secondClassCapacity;
    @Column(nullable = false)
    private int thirdClassCapacity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "route_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Route route;

    @ManyToMany
    @JoinTable(name = "ship_extras",
            joinColumns = @JoinColumn(name = "ship_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id", referencedColumnName = "id"))
    private Set<Extra> extras = new HashSet<>();

    public Ship() {
        route = new Route();
    }
}
