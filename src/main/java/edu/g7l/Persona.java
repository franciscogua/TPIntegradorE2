package edu.g7l;

import java.util.List;

public class Persona {
    private String nombre;
    private List<Pronostico> pronosticoList;


    public void addPronostico(Pronostico pronostico) {
        this.pronosticoList.add(pronostico);
    }




}
