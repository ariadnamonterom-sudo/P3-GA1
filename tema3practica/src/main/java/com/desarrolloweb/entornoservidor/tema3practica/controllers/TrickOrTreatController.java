package com.desarrolloweb.entornoservidor.tema3practica.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.entornoservidor.tema3practica.exceptions.HauntedHouseClosedException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.MonsterNotFoundException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.PotionExpiredException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.TooScaryException;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class TrickOrTreatController {
    
    @GetMapping("/trickortreat")
    public String TrickOrTreatMessage() {
        
        //Random para elegir entre 2 opciones:
            //1. Truco o trato
            //2. Exception aleatoria
        Random randomOption = new Random();

        int option = randomOption.nextInt(2);//2 posibilidades
        
        //Si la opción es 0 devolvemos el mensaje "Truco o trato" al usuario
        if(option == 0) {
            return "Truco o trato!";
        } else {
            //Si no, con un segundo random se elige un número del 0 al 3
            Random randomException = new Random();
            int exception = randomException.nextInt(4);

            //Dependiendo del número, lanza una excepción u otra.
            switch (exception) {
                case 0:
                    throw new MonsterNotFoundException("¡Susto! El monstruo que buscabas ha huido a esconderse bajo la cama.");
                case 1:
                    throw new PotionExpiredException("¡Puaj! Esta poción de bruja caducó en el siglo XVII y ahora sabe a calcetín usado.");
                case 2: 
                    throw new HauntedHouseClosedException("¡Demasiado tarde! La mansión encantada cerró sus puertas y los fantasmas ya están durmiendo.");
                case 3:
                    throw new TooScaryException("¡ERROR 666! Los niveles de terror han superado el límite permitido para cardíacos.");
                default:
                    return "Truco o trato!";
            }
        }
    }
    
}
