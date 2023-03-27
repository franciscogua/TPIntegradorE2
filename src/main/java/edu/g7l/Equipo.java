package edu.g7l;

import java.util.Objects;

public class Equipo {

    // Atributos
    private final String nombre;
    private String descripcion;


    // Constructor, por ahora no usamos el atributo descripcion
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
    }


    // Getters y Setters (solo los que deberian ser usados)
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    // Hacemos override a estos metodos para poder comparar Equipos entre si
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
