package edu.g7l;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private final List<Pronostico> pronosticoList;


    public Persona(String nombre) {
        this.nombre = nombre;
        this.pronosticoList = new ArrayList<Pronostico>();
    }


    public void addPronostico(Pronostico pronostico) {
        this.pronosticoList.add(pronostico);
    }




}
