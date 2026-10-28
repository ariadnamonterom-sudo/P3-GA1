package com.desarrolloweb.entornoservidor.tema3practica.exceptions;

public class PotionExpiredException extends RuntimeException{
    public PotionExpiredException(String message) {
        super(message);
    }
}
