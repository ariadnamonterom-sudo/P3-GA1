package com.desarrolloweb.entornoservidor.tema3practica.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.entornoservidor.tema3practica.models.Monster;
import com.desarrolloweb.entornoservidor.tema3practica.services.IMonsterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired 
    private IMonsterService monsterService;
    
    @GetMapping("/{id}")
    public Monster getMonster(@PathVariable(required = false) int id) {
        return monsterService.findById(id);
    }
    
}
