package com.desarrolloweb.entornoservidor.tema3practica.exceptions;

public class HauntedHouseClosedException extends RuntimeException{
    public HauntedHouseClosedException(String message) {
        super(message); //Envía el mensaje a la clase padre (RuntimeException)
    }
    
}
