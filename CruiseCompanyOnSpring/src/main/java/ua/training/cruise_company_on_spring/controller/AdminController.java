package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.entity.UserRole;
import ua.training.cruise_company_on_spring.service.ExtraService;
import ua.training.cruise_company_on_spring.service.SeaportService;
import ua.training.cruise_company_on_spring.service.ShipService;
import ua.training.cruise_company_on_spring.service.UserService;

import java.util.Arrays;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private SeaportService seaportService;
    @Autowired
    private ShipService shipService;
    @Autowired
    private ExtraService extraService;

    @GetMapping("/admin/users")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("roles", Arrays.asList(UserRole.values()) );
        return "admin/users";
    }

    @PostMapping("/admin/updateUserRole")
    public String updateUserRole(@RequestParam String email,
                                 @RequestParam String userRoles,
                                 Model model){
        userService.updateUserRole(email, UserRole.valueOf(userRoles));
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/seaports")
    public String getAllPortsList(Model model) {
        model.addAttribute("all_ports", seaportService.allPorts());
        model.addAttribute("new_port", new Seaport());
        return "/admin/seaports";
    }

    @PostMapping("/admin/addPort")
    public String addSeaport(@ModelAttribute Seaport seaport){

        boolean result = seaportService.savePort(seaport);

        //if port was not added
        if ( !result) {
            return "redirect:/admin/seaports?error";
        }

        return "redirect:/admin/seaports";
    }

    @GetMapping("/admin/ships")
    public String viewAllShips(Model model){
        model.addAttribute("all_ships",  shipService.allShips());
        model.addAttribute("all_ship_facilities", extraService.allExtras());
        return "/admin/ships";
    }
}
