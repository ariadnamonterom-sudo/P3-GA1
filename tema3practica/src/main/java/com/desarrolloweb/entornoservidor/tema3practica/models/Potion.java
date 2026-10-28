package com.desarrolloweb.entornoservidor.tema3practica.models;

import java.util.Date;

public class Potion {
    private int id; 
    private String name; 
    private String effect; 
    private Date expirationDate; 

    public Potion() {

    }

    public Potion(int id, String name, String effect, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.expirationDate = expirationDate;
    }

    //Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    public String toString() {
        return "Potion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                ", expiration date='" + expirationDate + '\'' +
                '}';
    }
}
