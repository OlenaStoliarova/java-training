package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Excursion;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.service.ExcursionService;
import ua.training.cruise_company_on_spring.service.NoEntityFoundException;
import ua.training.cruise_company_on_spring.service.SeaportService;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class ExcursionServiceTest {
    @Autowired
    private ExcursionService excursionService;
    @Autowired
    private SeaportService seaportService;

    @Test
    void addExcursion() {
        Seaport seaport;
        try {
            seaport = seaportService.findPortByNameEn("Izmir");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = excursionService.saveExcursion(
                    Excursion.builder()
                            .nameEn("Ephesus")
                            .descriptionEn("Explore the ruins of the ancient city of Ephesus. Visit the terrace houses, the House of the Virgin Mary, St. John’s Basilica, and other sites. Experience the world’s most spectacular open-air museum on a guided tour from Izmir.")
                            .nameUkr("Ефес")
                            .descriptionUkr("Дослідіть руїни стародавнього міста Ефес. Відвідайте терасові будинку, Будинок Діви Марії, базиліку Святого Іоанна та інші об'єкти. Відвідайте найбільш вражаючий в світі музей під відкритим небом під час екскурсії з Ізміра.")
                            .approximateDurationHr(4L)
                            .priceUSD(new BigDecimal(20))
                            .seaport(seaport)
                            .build());
        assert (result);
    }
}
