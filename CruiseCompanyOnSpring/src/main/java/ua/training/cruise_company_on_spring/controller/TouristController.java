package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ua.training.cruise_company_on_spring.dto.RouteDTO;
import ua.training.cruise_company_on_spring.service.*;

@Controller
public class TouristController {
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private ShipService shipService;
    @Autowired
    private ExtraService extraService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/tourist/routs")
    public String showAllRouts(Model model){
        model.addAttribute("all_routs", routeService.allRouts());
        return "/tourist/routs";
    }

    @GetMapping("/tourist/route/{routeId}")
    public ModelAndView showRouteCruises(@PathVariable Long routeId){
        ModelAndView mav = new ModelAndView("/tourist/route");
        try {
            RouteDTO route = routeService.findById(routeId);
            mav.addObject("route", route);
        }catch (NoEntityFoundException ex){
            mav.addObject("NoRouteException", true);
        }
        mav.addObject("ships_on_route", shipService.allShipsOnRoute(routeId));
        mav.addObject("all_ship_facilities", extraService.allExtras());
        return mav;
    }

    /*
    @GetMapping("/tourist/cruises")
    public String getAllPortsList(Model model) {
        List<CruiseInListForTouristDTO> cruiseInListForTouristDTOS = cruiseService.getCruisesForTourist();
        List<Long> shipIds = cruiseInListForTouristDTOS.stream()
                .map(CruiseInListForTouristDTO::getShipId)
                .collect(Collectors.toList());
        List<ShipDTO> ships = shipService.allShipsByIds(shipIds);

        if(cruiseInListForTouristDTOS.size() == ships.size()) {
            model.addAttribute("ships", ships);
            model.addAttribute("cruises", cruiseInListForTouristDTOS);
        } else{
            //TODO display error
        }
        return "/tourist/cruises";
    }*/
}
