package com.desarrolloweb.entornoservidor.tema3practica.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.entornoservidor.tema3practica.models.HauntedHouse;
import com.desarrolloweb.entornoservidor.tema3practica.services.IHauntedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/enter")
public class HauntedHouseController {
    
    @Autowired 
    private IHauntedService hauntedService;

    @GetMapping("/{id}")
    public HauntedHouse getHauntedHouse(@PathVariable int id) {
        return hauntedService.findById(id);
    }
    
}
