package edu.g7l;

import java.util.Objects;

public class Partido {

    // Atributos
    int rondaID;
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;


    // Constructor
    public Partido(int rondaID, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.rondaID = rondaID;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }


    //Getters
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }


    // Este metodo devuelve el estatus del equipo usado como argumento (GANADOR o PERDEDOR), o EMPATE si es empate
    public ResultadoEnum resultado(Equipo equipo) {
        ResultadoEnum resultado = null;
        if (equipo.equals(this.equipo1) || equipo.equals(this.equipo2)) {
            if (this.golesEquipo1 == this.golesEquipo2) {
                resultado = ResultadoEnum.EMPATE;
            } else if (this.golesEquipo1 > this.golesEquipo2) {
                resultado = equipo.equals(this.equipo1) ? ResultadoEnum.GANADOR : ResultadoEnum.PERDEDOR;
            } else {
                resultado = equipo.equals(this.equipo1) ? ResultadoEnum.PERDEDOR : ResultadoEnum.GANADOR;
            }
        }
        return resultado;
    }


    // Este metodo compara si los equipos usados como argumento coinciden con los del partido
    public boolean compararPartido(Equipo equipo1, Equipo equipo2) {
        boolean a = this.equipo1.equals(equipo1);
        boolean b = this.equipo2.equals(equipo2);
        boolean c = this.equipo1.equals(equipo2);
        boolean d = this.equipo2.equals(equipo1);
        if ((a && b) || (c && d)) {
            return true;
        } else {
            return false;
        }
    }



    // Sobreescribimos estos metodos para poder comparar Partidos.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido)) return false;
        Partido partido = (Partido) o;
        return rondaID == partido.rondaID && equipo1.equals(partido.equipo1) && equipo2.equals(partido.equipo2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rondaID, equipo1, equipo2);
    }
}
