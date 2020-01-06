package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.entity.Route;
import ua.training.cruise_company_on_spring.repository.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> allRouts(){
        return routeRepository.findAllByOrderByNameEnAsc();
    }


    public boolean saveRoute(Route route) {
        if ( route.getId() == null) {
            //adding new route
            Optional<Route> routeFromDB = routeRepository.findByNameEn(route.getNameEn());
            if (routeFromDB.isPresent()) {
                return false;
            }
            routeRepository.save(route);
            return true;
        } else{
            //editing existing route
            Optional<Route> routeFromDB = routeRepository.findById(route.getId());
            if (routeFromDB.isPresent()) {
                routeRepository.save(route);
                return true;
            }
            return false;
        }
    }
}
