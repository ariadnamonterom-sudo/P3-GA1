package com.desarrolloweb.entornoservidor.tema3practica.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.desarrolloweb.entornoservidor.tema3practica.models.Error;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.HauntedHouseClosedException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidIdException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.InvalidScareLevelException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.MonsterNotFoundException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.PotionExpiredException;
import com.desarrolloweb.entornoservidor.tema3practica.exceptions.TooScaryException;

@RestControllerAdvice 
public class HandlerExceptionController {
    
    @ExceptionHandler(MonsterNotFoundException.class)
    public Error handlerMonsterNotFound(MonsterNotFoundException ex) {
        return new Error(ex.getMessage(), "Monstruo no encontrado", 
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    @ExceptionHandler(PotionExpiredException.class)
    public Error handlerPotionExpired(PotionExpiredException ex) {
        return new Error(ex.getMessage(), "La poción ha expirado",
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    @ExceptionHandler(HauntedHouseClosedException.class)
    public Error handlerHauntedHouseClosed(HauntedHouseClosedException ex) {
        return new Error(ex.getMessage(), "La Haunted House esta cerrada",
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    //Excepción para controlar el nivel de miedo (salta al ser un nivel mayor de 8)
    @ExceptionHandler(TooScaryException.class)
    public Error handlerTooScary(TooScaryException ex) {
        return new Error(ex.getMessage(), "La experiencia da demasiado miedo",
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    //Excepción para controlar que el nivel de miedo este entre 1-10
    @ExceptionHandler(InvalidScareLevelException.class)
    public Error handlerInvalidScareLevel(InvalidScareLevelException ex) {
        return new Error(ex.getMessage(), "Nivel inválido",
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    //Excepción para controlar que el id exista o sea válido
    @ExceptionHandler(InvalidIdException.class)
    public Error handlerInvalidId(InvalidIdException ex) {
        return new Error(ex.getMessage(), "Id inválido",
        HttpStatus.BAD_REQUEST.value(), new Date());
    }

    //Excepción para controlar que el id no sea un String
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> handlerStringId(MethodArgumentTypeMismatchException ex) {
        Error errorPersonalizado = new Error(
            "El parámetro ID debe ser un número entero válido, no se admiten cadenas de texto.", 
            "Tipo de parámetro inválido", 
            HttpStatus.BAD_REQUEST.value(), 
            new Date()
    );
        return new ResponseEntity<>(errorPersonalizado, HttpStatus.BAD_REQUEST);
    }

    //Excepción para controlar que el usuario haya introducido el parámetro id (Ejemplo de error: /monster/ )
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Error> handleMissingId(NoResourceFoundException ex) {
        
        Error errorResponseBody = new Error(
            "Falta el ID en la petición", 
            "¡Cuidado! Te has olvidado de poner el ID del monstruo en la URL", 
            HttpStatus.BAD_REQUEST.value(), 
            new Date() 
        );

        return new ResponseEntity<>(errorResponseBody, HttpStatus.BAD_REQUEST);
    }

}
