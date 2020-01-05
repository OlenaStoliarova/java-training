package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.cruise_company_on_spring.entity.Excursion;
import ua.training.cruise_company_on_spring.service.ExcursionService;
import ua.training.cruise_company_on_spring.service.SeaportService;

@Controller
@RequestMapping("/travel_agent")
public class TravelAgentExcursionsController {
    @Autowired
    private ExcursionService excursionService;
    @Autowired
    private SeaportService seaportService;

    @GetMapping("/excursions")
    public String getAllExcursionList(Model model) {
        model.addAttribute("all_excursions", excursionService.allExcursions());
        return "/travel_agent/excursions";
    }

    @GetMapping("/edit_excursion")
    public String showExcursionEditForm(@RequestParam String excursionId,
                                        @RequestParam( value = "error", required = false ) String error,
                                        Model model){
        Excursion excursion = excursionService.getExcursionById(excursionId);
        model.addAttribute("excursion", excursion);
        model.addAttribute("error", error != null);
        model.addAttribute("all_seaports", seaportService.allPorts());
        return "/travel_agent/edit_excursion";
    }

    @PostMapping("/edit_excursion")
    public String saveUpdatedExcursion(@ModelAttribute Excursion excursion,
                                       @RequestParam String seaportId) {

        excursion.setSeaport( seaportService.findPortById(seaportId));
        boolean result = excursionService.saveExcursion(excursion);

        //if excursion was not updated
        if ( !result) {
            return "redirect:/travel_agent/edit_excursion?excursionId="+ excursion.getId() + "&error";
        }

        return "redirect:/travel_agent/excursions";
    }


}
