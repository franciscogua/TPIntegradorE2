package edu.g7l;

public class Pronostico {

    //Atributos:
    private int rondaID;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;


    // Constructor
    public Pronostico(int rondaID, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.rondaID = rondaID;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    //Getters
    public Partido getPartido() {
        return partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }


    // Este metodo devuelve el puntaje del pronostico
    public int puntos() {
        ResultadoEnum resultadoPartido = this.partido.resultado(this.equipo);
        return resultadoPartido.equals(resultado) ? 1 : 0;  // Operador ternario, version mas simple del if()
    }
}
