package edu.g7l;


import java.util.ArrayList;
import java.util.List;

public class Ronda {

    // Atributos
    private int rondaID;
    private List<Partido> partidos;  // Que les parece que usemos listas en vez de array aqui?


    // Constructor
    public Ronda(int rondaID) {
        this.rondaID = rondaID;
        this.partidos = new ArrayList<>();
    }

    // Getters
    public int getrondaID() {
        return rondaID;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }


    // Este metodo agrega partidos a la ronda.
    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }


    // Este metodo devuelve el partido de la ronda que concide con los argumentos.
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
