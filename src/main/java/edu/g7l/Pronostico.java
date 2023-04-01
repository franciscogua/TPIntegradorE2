package edu.g7l;

import lombok.Getter;

public class Pronostico {

    //Atributos:
    private final int rondaID;
    @Getter
    private final Partido partido;
    @Getter
    private final Equipo equipo;
    @Getter
    private final ResultadoEnum resultado;


    // Constructor
    public Pronostico(int rondaID, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.rondaID = rondaID;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }


    // Este método devuelve el puntaje del pronóstico
    public int puntos() {
        ResultadoEnum resultadoPartido = this.partido.resultado(this.equipo);
        return resultadoPartido.equals(resultado) ? 1 : 0;  // Operador ternario, version más simple del if()
    }

    @Override
    public String toString() {
        return "\n\t\tRonda: " + rondaID +
                " | partido: " + partido +
                " | " + equipo.getNombre() +
                " " + resultado;
    }
}
