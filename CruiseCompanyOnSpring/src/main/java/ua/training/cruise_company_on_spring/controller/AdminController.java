package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.entity.UserRole;
import ua.training.cruise_company_on_spring.service.SeaportService;
import ua.training.cruise_company_on_spring.service.UserService;

import java.util.Arrays;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private SeaportService seaportService;

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
        return "/admin/seaports";
    }

    @PostMapping("/admin/addPort")
    public String addSeaport(@RequestParam String nameEn,
                             @RequestParam String countryEn,
                             @RequestParam String nameUkr,
                             @RequestParam String countryUkr,
                             Model model){

        boolean result = seaportService.savePort(Seaport.builder()
                .nameEn(nameEn)
                .countryEn(countryEn)
                .nameUkr(nameUkr)
                .countryUkr(countryUkr)
                .build());

        //if port was not added
        if ( !result) {
            return "redirect:/admin/seaports?error";
        }

        return "redirect:/admin/seaports";
    }
}
