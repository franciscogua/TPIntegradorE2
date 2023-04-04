package edu.g7l;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void contarPuntos() {

        // Equipos:
        Equipo equipo1 = new Equipo("A");
        Equipo equipo2 = new Equipo("B");

        // Ronda 1, partidos y pronósticos:
        Partido partido1 = new Partido(equipo1, equipo2, 2, 1);
        Pronostico pronosticoLucas1 = new Pronostico(1, partido1, equipo1, ResultadoEnum.GANADOR);
        Pronostico pronosticoFede1 = new Pronostico(1, partido1,equipo1, ResultadoEnum.GANADOR);

        // Ronda 2, partidos y pronósticos:
        Partido partido2 = new Partido(equipo1, equipo2, 1, 2);
        Pronostico pronosticoLucas2 = new Pronostico(2, partido2, equipo2, ResultadoEnum.GANADOR);
        Pronostico pronosticoFede2 = new Pronostico(2, partido2, equipo1, ResultadoEnum.EMPATE);

        // Personas con su respectivo pronóstico:
        Persona persona1 = new Persona("Lucas");
        persona1.addPronostico(pronosticoLucas1);
        persona1.addPronostico(pronosticoLucas2);
        Persona persona2 = new Persona("Fede");
        persona2.addPronostico(pronosticoFede1);
        persona2.addPronostico(pronosticoFede2);

        // Pruebas:
        assertEquals(2, Calculadora.contarPuntos(persona1));
        assertEquals(1, Calculadora.contarPuntos(persona2));
    }
}