package ua.training.cruise_company_on_spring.dto;

import lombok.*;
import ua.training.cruise_company_on_spring.entity.Extra;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ShipDTO {
    private Long id;
    private String name;

    private int totalCapacity;
    private int firstClassCapacity;
    private int secondClassCapacity;
    private int thirdClassCapacity;

    private RouteDTO route;
    private List<Extra> extras;
}
