package edu.g7l;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Este programa requiere dos argumentos: Los nombres de los archivos de resultados y pronósticos
// en la carpeta 'resources', en ese orden.

public class Calculadora {
    public static void main(String[] args) {
        List<String> resultados;  // Inicializamos las listas
        List<String> pronostico;

        try {
            resultados = FileReader(args[0]);  // Leemos los archivos, si existen
            pronostico = FileReader(args[1]);

            System.out.println("Bienvenido a la calculadora de puntajes.");  // Mensaje de bienvenida


            List<Ronda> rondaList = new ArrayList<>();
            rondaList.add(new Ronda(1));

            // Bloque para poblar la lista de rondaList creada con partidos, omitiendo la primera línea (encabezado)
            for (int i = 1; i < resultados.size(); i++) {
                String[] linea = resultados.get(i).split(",");

                // Agregar test para que la línea sea adecuada (tamaño y que sea transformable a int)


                int estaRondaID = Integer.parseInt(linea[0]);
                boolean rondaExiste = false;

                // Este for crea la ronda, si esta no existe
                for(Ronda ronda: rondaList) {
                    if (ronda.getRondaID() == estaRondaID) {
                        rondaExiste = true;
                        break;
                    }
                }

                if (!rondaExiste) {
                    rondaList.add(new Ronda(estaRondaID));
                }

                for(Ronda ronda: rondaList) {
                    if (ronda.getRondaID() == estaRondaID) {
                        ronda.addPartido(new Partido(new Equipo(linea[1]),
                                new Equipo(linea[4]),
                                Integer.parseInt(linea[2]),
                                Integer.parseInt(linea[3])));
                    }
                }
            }

            for (Ronda ronda : rondaList) {
                System.out.println(ronda.toString());
            }

            // Creamos una lista para las personas
            List<Persona> personaList = new ArrayList<>();



            // Poblamos la lista de pronósticos, omitiendo la primera línea (encabezado)
            for (int i = 1; i < pronostico.size(); i++) {
                String[] linea = pronostico.get(i).split(",");  // Aislamos la línea



                // La clase pronóstico tiene cuatro argumentos, tres de ellos son declarados aquí.
                String estaPersona = linea[0];
                int estaRondaID = Integer.parseInt(linea[1]);
                Partido partido = null;
                Equipo equipo;
                ResultadoEnum resultado;

                if (personaList.size() == 0) {
                    personaList.add(new Persona(estaPersona));
                }


                Equipo equipo1 = new Equipo(linea[2]);  // Creamos los equipos del pronóstico
                Equipo equipo2 = new Equipo(linea[6]);

                // Buscamos el partido correspondiente en la ronda
                for (Ronda ronda : rondaList) {
                    if (ronda.getRondaID() == estaRondaID) {
                        partido = ronda.returnPartido(equipo1, equipo2);
                        break;
                    }
                }

                // Aquí definimos un array de boolean para codificar el pronóstico
                boolean[] comparador = new boolean[3];
                for (int j = 3; j < 6; j++) {
                    comparador[j - 3] = linea[j].equals("X");
                }

                if (Arrays.equals(comparador, new boolean[]{true, false, false})) {  // Significa que gana el equipo 1
                    equipo = equipo1;  // El equipo ganador
                    resultado = ResultadoEnum.GANADOR;
                } else if (Arrays.equals(comparador, new boolean[]{false, false, true})) {  // Significa que gana el equipo 2
                    equipo = equipo2;  // El equipo ganador
                    resultado = ResultadoEnum.GANADOR;
                } else if (Arrays.equals(comparador, new boolean[]{false, true, false})) {  // Significa empate
                    equipo = equipo1;  // Si hay empate esto no importa, pero igual se define (también puede ser equipo2)
                    resultado = ResultadoEnum.EMPATE;
                } else {
                    System.out.printf("ERROR en el formato del pronóstico numero %d", i);
                    throw new RuntimeException();  // Si el pronóstico tiene un error, devuelve este error.
                }

                // Por último agregamos un pronóstico a la lista, con las variables que procesamos de la línea

                for (Persona persona : personaList) {
                    if (persona.getNombre().equals(estaPersona)) {
                        persona.addPronostico(new Pronostico(estaRondaID, partido, equipo, resultado));
                    }
                }
            }

            // Declaramos e inicializamos el puntaje


            // Iterando por los pronósticos de la lista de pronósticos, vamos sumando el puntaje
            for (Persona p : personaList) {
                int puntaje = 0;
                for (Pronostico q : p.getPronosticoList()) {
                    puntaje += q.puntos();
                }
                System.out.printf("Participante: %s, Puntaje = %d%n", p.getNombre(), puntaje);
            }



        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR! Argumentos incorrectos.");
        }
        catch (RuntimeException ignored) {}
        catch (IOException ioe) {
            System.out.println("ERROR! Algún archivo de entrada no encontrado.");
        }
        catch (Exception e) {
            System.out.println("ERROR! Algún pronóstico no coincide con los partidos de los resultados.");
        }
    }


    public static List<String> FileReader(String archivo) throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/" + archivo));
    }


}