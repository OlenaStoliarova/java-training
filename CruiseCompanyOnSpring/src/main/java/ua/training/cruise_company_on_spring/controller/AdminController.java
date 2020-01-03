package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String updateUserRole(@RequestParam(required = true) String email,
                                 @RequestParam(required = true) String userRoles,
                                 Model model){
        userService.updateUserRole(email, UserRole.valueOf(userRoles));
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/seaports")
    public String getAllPortsList(Model model) {
        model.addAttribute("all_ports", seaportService.allPorts());
        return "/admin/seaports";
    }
}
