package com.desarrolloweb.entornoservidor.tema3practica.repositories;

import com.desarrolloweb.entornoservidor.tema3practica.models.Potion;

public interface IPotionRepository {
    public Potion findById(int id);
}
