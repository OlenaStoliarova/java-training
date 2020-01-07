package ua.training.cruise_company_on_spring.dto;

import lombok.*;
import ua.training.cruise_company_on_spring.entity.Seaport;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RouteDTO {
    private Long id;

    private String nameEn;
    private String nameUkr;

    private int durationDays;
    private int durationNights;

    private List<Seaport> portsList;
}