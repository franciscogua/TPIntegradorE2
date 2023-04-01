package edu.g7l;

import lombok.Getter;

import java.util.Objects;

public class Partido {

    // Atributos
    @Getter
    Equipo equipo1;
    @Getter
    Equipo equipo2;
    @Getter
    int golesEquipo1;
    @Getter
    int golesEquipo2;


    // Constructor
    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }


    // Este método devuelve el estatus del equipo usado como argumento (GANADOR o PERDEDOR), o EMPATE si es empate
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


    // Este método compara si los equipos usados como argumento coinciden con los del partido
    public boolean compararPartido(Equipo equipo1, Equipo equipo2) {
        boolean a = this.equipo1.equals(equipo1);
        boolean b = this.equipo2.equals(equipo2);
        boolean c = this.equipo1.equals(equipo2);
        boolean d = this.equipo2.equals(equipo1);
        return (a && b) || (c && d);
    }



    // Sobreescribimos estos métodos para poder comparar Partidos.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;
        return equipo1.equals(partido.equipo1) && equipo2.equals(partido.equipo2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipo1, equipo2);
    }
}
