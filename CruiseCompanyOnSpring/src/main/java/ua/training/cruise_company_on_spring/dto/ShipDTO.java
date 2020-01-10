package ua.training.cruise_company_on_spring.dto;

import lombok.*;

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

    private RouteDTO route;
    private List<Long> extrasIds;
}
