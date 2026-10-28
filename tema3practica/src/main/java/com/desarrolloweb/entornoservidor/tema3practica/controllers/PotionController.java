package com.desarrolloweb.entornoservidor.tema3practica.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.entornoservidor.tema3practica.models.Potion;
import com.desarrolloweb.entornoservidor.tema3practica.services.IPotionService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/potions")
public class PotionController {

    @Autowired 
    private IPotionService potionService;

    @GetMapping("/{id}")
    public Potion getPotion(@PathVariable int id) {
        return potionService.findById(id);
    }
    
}
