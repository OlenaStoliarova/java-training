package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Route;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.service.NoEntityFoundException;
import ua.training.cruise_company_on_spring.service.RouteService;
import ua.training.cruise_company_on_spring.service.SeaportService;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class RouteServiceTest {
    @Autowired
    private RouteService routeService;
    @Autowired
    private SeaportService seaportService;

    @Test
    void addRoute() {

        Seaport startingAndFinalPort, por2, port3;
        try {
            startingAndFinalPort = seaportService.findPortByNameEn("Izmir");
            por2 = seaportService.findPortByNameEn("Athens");
            port3 = seaportService.findPortByNameEn("Thessaloniki");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = routeService.saveRoute( Route.builder()
                        .nameEn("Aegean Sea")
                        .nameUkr("Егейське море")
                        .startingAt(startingAndFinalPort)
                        .finishingAt(startingAndFinalPort)
                        .intermediatePorts(new HashSet<>(Arrays.asList(por2, port3)))
                        .durationDays(6)
                        .durationNights(5)
                        .build());

        assert (result);
    }

    @Test
    void addRoute2() {

        Seaport startingAndFinalPort, por2, port3;
        try {
            startingAndFinalPort = seaportService.findPortByNameEn("Barcelona");
            por2 = seaportService.findPortByNameEn("Valencia");
            port3 = seaportService.findPortByNameEn("Palma de Mallorca");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = routeService.saveRoute( Route.builder()
                .nameEn("Vamonos")
                .nameUkr("Вамонос")
                .startingAt(startingAndFinalPort)
                .finishingAt(startingAndFinalPort)
                .intermediatePorts(new HashSet<>(Arrays.asList(por2, port3)))
                .durationDays(8)
                .durationNights(8)
                .build());

        assert (result);
    }
}

