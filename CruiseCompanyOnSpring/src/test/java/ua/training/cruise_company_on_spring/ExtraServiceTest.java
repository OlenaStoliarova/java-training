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
        /*
        assert( extraService.saveExtra(new Extra("Gym", "Спортивна зала")) );
        assert( extraService.saveExtra(new Extra("Swimming pool", "Басейн")) );
        assert( extraService.saveExtra(new Extra("Cinema hall", "Кінозала")) );
        assert( extraService.saveExtra(new Extra("SPA", "СПА салон")) );

        assert( extraService.saveExtra(new Extra("Theater","Театр")) );
        assert( extraService.saveExtra(new Extra("Disco","Дискотека")) );
        assert( extraService.saveExtra(new Extra("Beauty salon","Салон краси")) );
        assert( extraService.saveExtra(new Extra("Sauna","Сауна")) );
        assert( extraService.saveExtra(new Extra("Jacuzzi","Джакузі")) );*/

        assert( extraService.saveExtra(new Extra("Casino","Казино")) );
        assert( extraService.saveExtra(new Extra("Water slide","Водна гірка")) );
        assert( extraService.saveExtra(new Extra("Mini golf","Міні-гольф")) );
        assert( extraService.saveExtra(new Extra("Surf simulator","Симулятор серфінгу")) );
        assert( extraService.saveExtra(new Extra("Children room","Дитяча кімната")) );
        assert( extraService.saveExtra(new Extra("Children's pool","Дитячий басейн")) );
    }
}
