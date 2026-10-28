package com.desarrolloweb.entornoservidor.tema3practica.models;

public class HauntedHouse {
    private int id;
    private String name;
    private boolean open; 
    private int scareLevel; // 1-10

    public HauntedHouse() {
    }

    public HauntedHouse(int id, String name, boolean open, int scareLevel) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.scareLevel = scareLevel;
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

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    public void setScareLevel(int scareLevel) {
        this.scareLevel = scareLevel;
    }


    public String toString() {
        return "HauntedHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open='" + open + '\'' +
                ", scareLevel='" + scareLevel + '\'' +
                '}';
    }
}
