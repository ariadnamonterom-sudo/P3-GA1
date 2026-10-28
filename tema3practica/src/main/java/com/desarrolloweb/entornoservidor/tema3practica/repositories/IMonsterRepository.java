package com.desarrolloweb.entornoservidor.tema3practica.repositories;

import com.desarrolloweb.entornoservidor.tema3practica.models.Monster;

public interface IMonsterRepository {
    public Monster findById(int id);
}
