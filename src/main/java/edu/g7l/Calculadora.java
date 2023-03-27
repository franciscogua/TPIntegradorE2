package edu.g7l;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Este programa requiere dos argumentos: Los nombres de los archivos de resultados y pronosticos
// en la carpeta 'resources', en ese orden.

public class Calculadora {
    public static void main(String[] args) {
        List<String> resultados;  // Inicializamos las listas
        List<String> pronostico;

        try {
            resultados = FileReader(args[0]);  // Leemos los archivos, si existen
            pronostico = FileReader(args[1]);

            System.out.println("Bienvenido a la calculadora de puntajes.");  // Mensaje de bienvenida
            int rondaID = 1; // En esta entrega, existe una unica ronda

            Ronda ronda = new Ronda(rondaID);

            // Bloque para poblar la ronda creada con partidos, omitiendo la primera linea (encabezado)
            for (int i = 1; i < resultados.size(); i++) {
                String[] linea = resultados.get(i).split(",");
                ronda.addPartido(new Partido(ronda.getrondaID(),
                        new Equipo(linea[0]),
                        new Equipo(linea[3]),
                        Integer.parseInt(linea[1]),
                        Integer.parseInt(linea[2])));
            }

            // Creamos una lista para los pronosticos
            List<Pronostico> pronosticoList = new ArrayList<>();

            // Poblamos la lista de pronosticos, omitiendo la primera linea (encabezado)
            for (int i = 1; i < pronostico.size(); i++) {
                // La clase pronostico tiene cuatro argumentos, tres de ellos son declarados aqui.
                Partido partido;
                Equipo equipo;
                ResultadoEnum resultado;

                String[] linea = pronostico.get(i).split(",");  // Aislamos la linea
                Equipo equipo1 = new Equipo(linea[0]);  // Creamos los equipos del pronostico
                Equipo equipo2 = new Equipo(linea[4]);
                partido = ronda.returnPartido(equipo1, equipo2);  // Buscamos el partido correspondiente en la ronda

                // Aqui definimos un array de boolean para codificar el pronostico
                boolean[] comparador = new boolean[3];
                for (int j = 1; j < 4; j++) {
                    comparador[j - 1] = linea[j].equals("X");
                }

                if (Arrays.equals(comparador, new boolean[]{true, false, false})) {  // Significa que gana el equipo 1
                    equipo = equipo1;  // El equipo ganador
                    resultado = ResultadoEnum.GANADOR;
                } else if (Arrays.equals(comparador, new boolean[]{false, false, true})) {  // Significa que gana el equipo 2
                    equipo = equipo2;  // El equipo ganador
                    resultado = ResultadoEnum.GANADOR;
                } else if (Arrays.equals(comparador, new boolean[]{false, true, false})) {  // Significa empate
                    equipo = equipo1;  // Si hay empate esto no importa, pero igual se define (tambien puede ser equipo2)
                    resultado = ResultadoEnum.EMPATE;
                } else {
                    System.out.printf("ERROR en el formato del pronostico numero %d", i);
                    throw new RuntimeException();  // Si el pronostico tiene un error, devuelve este error.
                }

                // Por ultimo agregamos un pronostico a la lista, con las variables que procesamos de la linea
                pronosticoList.add(new Pronostico(rondaID, partido, equipo, resultado));
            }

            // Declaramos e inicializamos el puntaje
            int puntaje = 0;

            // Iterando por los pronosticos de la lista de pronosticos, vamos sumando el puntaje
            for (Pronostico p : pronosticoList) {
                puntaje += p.puntos();
            }

            System.out.printf("Puntaje = %d%n", puntaje);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR! Argumentos incorrectos.");
        }
        catch (RuntimeException ignored) {}
        catch (IOException ioe) {
            System.out.println("ERROR! Algun archivo de entrada no encontrado.");
        }
        catch (Exception e) {
            System.out.println("ERROR! Algun pronostico no coincide con los partidos de los resultados.");
        }
    }


    public static List<String> FileReader(String archivo) throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/" + archivo));
    }
}