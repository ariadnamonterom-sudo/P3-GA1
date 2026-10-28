package com.desarrolloweb.entornoservidor.tema3practica.services;

import org.springframework.stereotype.Service;

import com.desarrolloweb.entornoservidor.tema3practica.exceptions.HauntedHouseClosedException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidIdException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidScareLevelException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.TooScaryException;
import com.desarrolloweb.entornoservidor.tema3practica.models.HauntedHouse;
import com.desarrolloweb.entornoservidor.tema3practica.repositories.IHauntedHouseRepository;

@Service 
public class HauntedHouseService implements IHauntedService{
    
    private IHauntedHouseRepository hauntedHouseRepository;

    public HauntedHouseService(IHauntedHouseRepository hauntedHouseRepository) {
        this.hauntedHouseRepository = hauntedHouseRepository;
    }

    //Se sobreescribe el método añadido previamente en la interfaz
    @Override 
    public HauntedHouse findById(int id) {
        HauntedHouse hauntedHouse = hauntedHouseRepository.findById(id);

        //Si la pocion no existe salta la excepción añadida "InvalidIdException"
        //Controla las pociones con id inválido
        if (hauntedHouse == null) {
            throw new InvalidIdException("Haunted House no encontrado.");  
        }

        //Excepcion para controlar el nivel de miedo "InvalidScareLevelException"
        if(hauntedHouse.getScareLevel() < 0 || hauntedHouse.getScareLevel() > 10 ) {
            throw new InvalidScareLevelException("Nivel de miedo no válido");
        }

        //Si Haunted house esta cerrado (false), salta la exception "HauntedHouseClosedException"
        if(hauntedHouse.getOpen() == false) {
            throw new HauntedHouseClosedException("Hautend House esta fuera del horario de sustos");
        }

        //Si el nivel de miedo es mayor a 8, "TooScaryException" salta por demasiado aterradora
        if (hauntedHouse.getScareLevel() > 8) {
            throw new TooScaryException("Experiencia demasiado aterradora");
        }

        return hauntedHouse;
    }
}
