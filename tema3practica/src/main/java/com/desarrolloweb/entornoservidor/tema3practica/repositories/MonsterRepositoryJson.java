package com.desarrolloweb.entornoservidor.tema3practica.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.entornoservidor.tema3practica.models.Monster;

import tools.jackson.databind.ObjectMapper;

@Repository 
public class MonsterRepositoryJson  implements  IMonsterRepository{
    
    //Creamos la lista de monstruos que guardará los datos json.
    private List<Monster> monsters = new ArrayList<>();

    //El constructor busca el archivo json de monstruo.
    public MonsterRepositoryJson() {
        Resource resource = new ClassPathResource("json/monsters.json");
        readValueJson(resource);
    }

    //Método que lee el archivo json y lo convierte en objetos Java.
    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Convierte el json en una lista de monstruos y lo pasa a una Lista.
            monsters = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Monster[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public Monster findById(int id) {
        return monsters.stream().filter((m -> m.getId() == id))//Filtra los monstruos que coincidan en id
            .findFirst().orElse(null);//Muestra el primero que encuentra sino, devuelve nulo.
    }
}
