package ua.training.cruise_company_on_spring.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/login" })
    public String staticResource(Model model) {
        return "login";
    }

}
