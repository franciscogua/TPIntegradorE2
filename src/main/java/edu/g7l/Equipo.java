package edu.g7l;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

public class Equipo {

    // Atributos con Getters y Setters de Lombok:
    @Getter
    private final String nombre;
    @Getter @Setter
    private String descripcion;


    // Constructor, por ahora no usamos el atributo descripción
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
    }

    // Hacemos override a estos métodos para poder comparar Equipos entre sí
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return nombre.equals(equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
