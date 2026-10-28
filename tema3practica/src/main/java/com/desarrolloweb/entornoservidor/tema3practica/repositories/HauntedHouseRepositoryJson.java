package com.desarrolloweb.entornoservidor.tema3practica.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.entornoservidor.tema3practica.models.HauntedHouse;

import tools.jackson.databind.ObjectMapper;

@Repository
public class HauntedHouseRepositoryJson implements IHauntedHouseRepository{
    
    //Creamos una lista de casas para donde se guardaran los datos del json.
    private List<HauntedHouse> hauntedHouses = new ArrayList<>();

    //El constructor busca el archivo json 
    public HauntedHouseRepositoryJson() {
        Resource resource = new ClassPathResource("json/houses.json");
        readValueJson(resource);
    }

    //Método que lee el archivo json y lo convierte en objetos Java 
    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Convierte el Json en un array de casas y lo pasa a una Lista
            hauntedHouses = Arrays.asList(objectMapper.readValue(resource.getInputStream(), HauntedHouse[].class));
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public HauntedHouse findById(int id) {
        return hauntedHouses.stream().filter(h -> h.getId() == id) //Filtra las casa que contengan el mismo id
            .findFirst().orElse(null); //Elige la primera, si no la encuentra devuelve null.
    }
}
