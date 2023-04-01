package edu.g7l;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    // Atributos con Getters de Lombok:
    @Getter
    private final int rondaID;
    @Getter
    private final List<Partido> partidos;


    // Constructor
    public Ronda(int rondaID) {
        this.rondaID = rondaID;
        this.partidos = new ArrayList<>();
    }

    // Este método agrega partidos a la ronda.
    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }


    // Este método devuelve el partido de la ronda que coincide con los argumentos.
    public Partido returnPartido(Equipo equipo1, Equipo equipo2) throws Exception {
        Partido result = null;
        for (Partido partido : partidos) {
            if (partido.compararPartido(equipo1, equipo2)) {
                result = partido;
                break;
            }
        }
        if (result == null) throw new Exception();
        return result;
    }


    /*
    public int puntos() {
        return 1;
    }
    */
}
