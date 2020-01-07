package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Extra;
import ua.training.cruise_company_on_spring.entity.Route;
import ua.training.cruise_company_on_spring.entity.Ship;
import ua.training.cruise_company_on_spring.service.ExtraService;
import ua.training.cruise_company_on_spring.service.NoEntityFoundException;
import ua.training.cruise_company_on_spring.service.RouteService;
import ua.training.cruise_company_on_spring.service.ShipService;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ShipServiceTest {
    @Autowired
    private ShipService shipService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private ExtraService extraService;

    @Test
    void addShip(){
        Route route;
        try {
            route = routeService.findByNameEn("Aegean Sea");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Theater"));
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Beauty salon"));
            extras.add(extraService.findExtraByNameEn("Sauna"));
            extras.add(extraService.findExtraByNameEn("Jacuzzi"));
            extras.add(extraService.findExtraByNameEn("Gym"));
            extras.add(extraService.findExtraByNameEn("SPA"));
            extras.add(extraService.findExtraByNameEn("Swimming pool"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                    Ship.builder()
                            .name("Aegean Odyssey")
                            .route(route)
                            .firstClassCapacity(150)
                            .secondClassCapacity(150)
                            .thirdClassCapacity(78)
                            .extras(extras)
                            .build());
        assert (result);
    }

    @Test
    void addShip2(){
        Route route;
        try {
            route = routeService.findByNameEn("Vamonos");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Theater"));
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Casino"));
            extras.add(extraService.findExtraByNameEn("Beauty salon"));
            extras.add(extraService.findExtraByNameEn("SPA"));
            extras.add(extraService.findExtraByNameEn("Sauna"));
            extras.add(extraService.findExtraByNameEn("Swimming pool"));
            extras.add(extraService.findExtraByNameEn("Jacuzzi"));
            extras.add(extraService.findExtraByNameEn("Gym"));
            extras.add(extraService.findExtraByNameEn("Children room"));
            extras.add(extraService.findExtraByNameEn("Children's pool"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                Ship.builder()
                        .name("Magellan")
                        .route(route)
                        .firstClassCapacity(710)
                        .secondClassCapacity(400)
                        .thirdClassCapacity(342)
                        .extras(extras)
                        .build());
        assert (result);
    }


    @Test
    void addShip3(){
        Route route;
        try {
            route = routeService.findByNameEn("Three northern capitals");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Gym"));
            extras.add(extraService.findExtraByNameEn("Swimming pool"));
            extras.add(extraService.findExtraByNameEn("Cinema hall"));
            extras.add(extraService.findExtraByNameEn("Theater"));
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Sauna"));
            extras.add(extraService.findExtraByNameEn("Jacuzzi"));
            extras.add(extraService.findExtraByNameEn("Mini golf"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                Ship.builder()
                        .name("Viking Star")
                        .route(route)
                        .firstClassCapacity(130)
                        .secondClassCapacity(600)
                        .thirdClassCapacity(200)
                        .extras(extras)
                        .build());
        assert (result);
    }

    @Test
    void addShip4(){
        Route route;
        try {
            route = routeService.findByNameEn("South coast of France plus Monaco");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Casino"));
            extras.add(extraService.findExtraByNameEn("Beauty salon"));
            extras.add(extraService.findExtraByNameEn("Swimming pool"));
            extras.add(extraService.findExtraByNameEn("Surf simulator"));
            extras.add(extraService.findExtraByNameEn("Water slide"));
            extras.add(extraService.findExtraByNameEn("Children room"));
            extras.add(extraService.findExtraByNameEn("Children's pool"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                Ship.builder()
                        .name("Monarch")
                        .route(route)
                        .firstClassCapacity(1000)
                        .secondClassCapacity(1000)
                        .thirdClassCapacity(280)
                        .extras(extras)
                        .build());
        assert (result);
    }

    @Test
    void addShip5(){
        Route route;
        try {
            route = routeService.findByNameEn("Three northern capitals");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Cinema hall"));
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Sauna"));
            extras.add(extraService.findExtraByNameEn("Gym"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                Ship.builder()
                        .name("Nordkapp")
                        .route(route)
                        .firstClassCapacity(0)
                        .secondClassCapacity(450)
                        .thirdClassCapacity(0)
                        .extras(extras)
                        .build());
        assert (result);
    }

    @Test
    void addShip6(){
        Route route;
        try {
            route = routeService.findByNameEn("South coast of France plus Monaco");
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        Set<Extra> extras = new HashSet<>();
        try {
            extras.add(extraService.findExtraByNameEn("Theater"));
            extras.add(extraService.findExtraByNameEn("Disco"));
            extras.add(extraService.findExtraByNameEn("Casino"));
            extras.add(extraService.findExtraByNameEn("Beauty salon"));
            extras.add(extraService.findExtraByNameEn("SPA"));
            extras.add(extraService.findExtraByNameEn("Swimming pool"));
            extras.add(extraService.findExtraByNameEn("Water slide"));
            extras.add(extraService.findExtraByNameEn("Children room"));
            extras.add(extraService.findExtraByNameEn("Children's pool"));
        }
        catch (NoEntityFoundException e){
            assert(false);
            return;
        }

        boolean result = shipService.saveShip(
                Ship.builder()
                        .name("Costa Mediterranea")
                        .route(route)
                        .firstClassCapacity(900)
                        .secondClassCapacity(900)
                        .thirdClassCapacity(400)
                        .extras(extras)
                        .build());
        assert (result);
    }


}
