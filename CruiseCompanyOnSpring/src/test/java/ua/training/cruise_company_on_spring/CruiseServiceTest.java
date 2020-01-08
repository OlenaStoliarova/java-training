package ua.training.cruise_company_on_spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Cruise;
import ua.training.cruise_company_on_spring.entity.Ship;
import ua.training.cruise_company_on_spring.service.CruiseService;
import ua.training.cruise_company_on_spring.service.NoEntityFoundException;
import ua.training.cruise_company_on_spring.service.ShipService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class CruiseServiceTest {
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private ShipService shipService;

    @Test
    public void addCruise(){
        Ship ship;
        try {
            ship = shipService.getShipByName("Aegean Odyssey");
        }
        catch (NoEntityFoundException ex){
            assert(false);
            return;
        }

        LocalDate startingDate = LocalDate.of(2020, Month.MARCH, 8);
        LocalDate finishingDate = startingDate.plusDays(ship.getRoute().getDurationDays());

        boolean result = cruiseService.saveCruise(
                Cruise.builder()
                        .ship(ship)
                        .startingDate(startingDate)
                        .finishingDate(finishingDate)
                        .vacanciesInFirstClass( ship.getFirstClassCapacity())
                        .vacanciesInSecondClass( ship.getSecondClassCapacity())
                        .vacanciesInThirdClass( ship.getThirdClassCapacity())
                        .firstClassPrice(new BigDecimal(800))
                        .secondClassPrice(new BigDecimal(600))
                        .thirdClassPrice(new BigDecimal(490))
                        .build());
        assert (result);
    }
}
