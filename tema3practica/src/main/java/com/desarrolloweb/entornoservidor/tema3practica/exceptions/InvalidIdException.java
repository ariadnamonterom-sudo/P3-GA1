package com.desarrolloweb.entornoservidor.tema3practica.exceptions;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String message) {
        super(message);
    }
}
