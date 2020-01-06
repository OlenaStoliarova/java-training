package ua.training.cruise_company_on_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.training.cruise_company_on_spring.entity.Extra;
import ua.training.cruise_company_on_spring.service.ExtraService;

@SpringBootTest
public class ExtraServiceTest {
    @Autowired
    private ExtraService extraService;

    @Test
    void addExtras(){
        assert( extraService.saveExtra(new Extra("Gym", "Спортивна зала")) );
        assert( extraService.saveExtra(new Extra("Swimming pool", "Басейн")) );
        assert( extraService.saveExtra(new Extra("Cinema hall", "Кінозала")) );
        assert( extraService.saveExtra(new Extra("SPA", "СПА салон")) );
    }
}
