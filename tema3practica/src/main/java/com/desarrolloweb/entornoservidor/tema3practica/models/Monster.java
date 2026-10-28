package com.desarrolloweb.entornoservidor.tema3practica.models;

public class Monster {
    private int id; 
    private String name; 
    private String species; 
    private int scareLevel; // nivel de miedo 1-10

    
    public Monster() {
    }

    public Monster(int id, String name, String species, int scareLevel) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.scareLevel = scareLevel;
    }

    //Getter y Setters
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    public void setScareLevel(int scareLevel) {
        if(scareLevel < 1 || scareLevel > 10) {
            throw new IllegalArgumentException("El nivel debe estar entre 1 y 10");
        }

        this.scareLevel = scareLevel;
    }


    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specie='" + species + '\'' +
                ", scareLevel='" + scareLevel + '\'' +
                '}';
    }
}
