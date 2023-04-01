package edu.g7l;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    @Getter
    private String nombre;
    @Getter
    private final List<Pronostico> pronosticoList;


    public Persona(String nombre) {
        this.nombre = nombre;
        this.pronosticoList = new ArrayList<Pronostico>();
    }


    public void addPronostico(Pronostico pronostico) {
        this.pronosticoList.add(pronostico);
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + "\n" +
                "\tPronosticos: \n\t\t" + pronosticoList;
    }
}
