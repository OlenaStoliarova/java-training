package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ua.training.cruise_company_on_spring.entity.Route;
import ua.training.cruise_company_on_spring.service.CruiseService;
import ua.training.cruise_company_on_spring.service.RouteService;
import ua.training.cruise_company_on_spring.service.ShipService;

@Controller
public class TouristController {
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private ShipService shipService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/tourist/routs")
    public String showAllRouts(Model model){
        model.addAttribute("all_routs", routeService.allRouts());
        return "/tourist/routs";
    }

    @GetMapping("/tourist/route/{routeId}")
    public ModelAndView showRouteCruises(@PathVariable("routeId") Route route){
        ModelAndView mav = new ModelAndView("/tourist/route");

        return mav;
    }
}
