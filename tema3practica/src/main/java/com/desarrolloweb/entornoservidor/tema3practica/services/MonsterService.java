package com.desarrolloweb.entornoservidor.tema3practica.services;

import org.springframework.stereotype.Service;

import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidScareLevelException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.MonsterNotFoundException;
import com.desarrolloweb.entornoservidor.tema3practica.models.Monster;
import com.desarrolloweb.entornoservidor.tema3practica.repositories.IMonsterRepository;

@Service 
public class MonsterService implements IMonsterService{

    private IMonsterRepository monsterRepository;
    
    public MonsterService(IMonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    //Se sobreescribe el método añadido en la interfaz
    @Override 
    public Monster findById(int id) {
        Monster monster = monsterRepository.findById(id);

        //Si el id es nulo salta la excepción previamente pedida.
        if(monster == null) {
            throw new MonsterNotFoundException("El monstruo con ID " + id + " no existe.");
        }

        //Excepción añadida: Si el nivel de miedo es menor de 0 o mayor que 10 salta la excepción.
        if(monster.getScareLevel() < 0 || monster.getScareLevel() > 10 ) {
            throw new InvalidScareLevelException("Nivel de miedo no válido");
        }

        return monster;
        
    }
    
}
