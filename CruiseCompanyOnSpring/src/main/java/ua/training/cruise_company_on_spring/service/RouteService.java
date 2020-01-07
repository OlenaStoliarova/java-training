package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.cruise_company_on_spring.dto.RouteDTO;
import ua.training.cruise_company_on_spring.entity.Route;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.repository.RouteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<RouteDTO> allRouts(){
        List<Route> rawRouts = routeRepository.findAllByOrderByNameEnAsc();
        return rawRouts.stream().map(RouteService::routeToDTO).collect(Collectors.toList());
    }

    public Route findByNameEn(String nameEn) throws NoEntityFoundException {
        return routeRepository.findByNameEn(nameEn)
                                .orElseThrow(() -> new NoEntityFoundException("There is no rout with name (" + nameEn + ")"));
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

    static RouteDTO routeToDTO(Route route){
        List<Seaport> portsList = new ArrayList<>();
        portsList.add( route.getStartingAt());
        portsList.addAll(route.getIntermediatePorts());
        portsList.add( route.getFinishingAt());

        return RouteDTO.builder()
                .id(route.getId())
                .nameEn(route.getNameEn())
                .nameUkr(route.getNameUkr())
                .durationDays(route.getDurationDays())
                .durationNights(route.getDurationNights())
                .portsList(portsList)
                .build();
    }
}
