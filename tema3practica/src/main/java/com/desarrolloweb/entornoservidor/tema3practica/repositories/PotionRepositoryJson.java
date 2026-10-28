package com.desarrolloweb.entornoservidor.tema3practica.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.entornoservidor.tema3practica.models.Potion;

import tools.jackson.databind.ObjectMapper;

@Repository 
public class PotionRepositoryJson implements IPotionRepository{

    //Creamos la lista de monstruos que guardará los datos json.
    private List<Potion> potions = new ArrayList<>();

    //El constructor busca el archivo json de pociones
    public PotionRepositoryJson() {
        Resource resource = new ClassPathResource("json/potions.json");
        readValueJson(resource);
    }

    //Método que lee el archivo json y lo convierte en objetos Java 
    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Convierte el Json en un array de pociones y lo pasa a una Lista
            potions = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Potion[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override 
    public Potion findById(int id) {
        return potions.stream().filter(p -> p.getId() == id)//Filtra las pociones que contengan el mismo id.
            .findFirst().orElse(null);//Devuelve el primero que encuentra sino, devuelve null.
    }
}
