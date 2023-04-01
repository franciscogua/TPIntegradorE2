package edu.g7l;

import lombok.Getter;

import java.util.List;

public class Persona {
    @Getter
    private String nombre;
    private List<Pronostico> pronosticoList;


    public void addPronostico(Pronostico pronostico) {
        this.pronosticoList.add(pronostico);
    }




}
