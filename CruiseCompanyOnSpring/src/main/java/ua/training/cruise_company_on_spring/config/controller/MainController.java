package ua.training.cruise_company_on_spring.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "/" })
    public String firstPage(Model model) {
        return "index";
    }

    @RequestMapping(value = { "/main" })
    public String openMain(Model model) {
        return "tourist/tourist_main";
    }

    @RequestMapping(value = { "/login" })
    public String staticResource(Model model) {
        return "login";
    }

}
