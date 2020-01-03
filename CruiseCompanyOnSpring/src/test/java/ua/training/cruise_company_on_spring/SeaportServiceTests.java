package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.service.SeaportService;

import java.util.Locale;

@SpringBootTest
public class SeaportServiceTests {
    @Autowired
    private SeaportService seaportService;

    @Test
    void addPort() {
        boolean result = seaportService.savePort(Seaport.builder()
                .nameEn("Thessaloniki")
                .countryEn("Greece")
                .nameUkr("Салоніки")
                .countryUkr("Греція")
                .build());
        assert(result);

        result = seaportService.savePort(Seaport.builder()
                .nameEn("Athens")
                .countryEn("Greece")
                .nameUkr("Афіни")
                .countryUkr("Греція")
                .build());
        assert(result);
        /*
        boolean result = seaportService.savePort(Seaport.builder()
                .nameEn("Izmir")
                .countryEn("Turkey")
                .nameUkr("Ізмір")
                .countryUkr("Турція")
                .build());
        assert(result);
         */
    }

    @Test
    void testFindPort() {

    }
}
