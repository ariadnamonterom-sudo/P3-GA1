package com.desarrolloweb.entornoservidor.tema3practica.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidIdException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.PotionExpiredException;
import com.desarrolloweb.entornoservidor.tema3practica.models.Potion;
import com.desarrolloweb.entornoservidor.tema3practica.repositories.IPotionRepository;

@Service 
public class PotionService implements IPotionService{
    
    private IPotionRepository potionRepository;

    public PotionService(IPotionRepository potionRepository) {
        this.potionRepository = potionRepository;
    }

    //Se sobreescribe el método añadido previamente en la interfaz
    @Override 
    public Potion findById(int id) {
        Potion potion = potionRepository.findById(id);

        //Si la pocion no existe salta la excepción añadida "InvalidIdException"
        //Controla las pociones con id inválido
        if (potion == null) {
            throw new InvalidIdException("Poción no encontrada");  
        }
 
        //Se crea la excepción pars comprobar la fecha de caducidad
        // Por un lado comprobamos que el dato de la fecha no esté en nulo
        // y por el otro se compueba que la fecha tenga un valor superior al actual del aquí y el ahora.
        if(potion.getExpirationDate() != null && potion.getExpirationDate().before(new Date())) {
            throw new PotionExpiredException("La poción '" + potion.getName() + "' caducó el " + potion.getExpirationDate());
        }

        return potion;
    }
}
