package com.example.ticktask;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String nombre;
    private String descripcion;
    private String departamentoAsignado;
    private String personaAsignada;

    public Ticket(String nombre, String descripcion, String departamentoAsignado, String personaAsignada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamentoAsignado = departamentoAsignado;
        this.personaAsignada = personaAsignada;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDepartamentoAsignado() {
        return departamentoAsignado;
    }

    public String getPersonaAsignada() {
        return personaAsignada;
    }

    // Setters
    public void setNombre(String nombre) {
        //para que el nombre no sea nullo ni vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ticket no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDepartamentoAsignado(String departamentoAsignado) {
        //para que el campo no sea nullo ni vacio
        if (departamentoAsignado == null || departamentoAsignado.trim().isEmpty()) {
            throw new IllegalArgumentException("El departamento asignado no puede estar vacío.");
        }
        this.departamentoAsignado = departamentoAsignado;
    }

    public void setPersonaAsignada(String personaAsignada) {
        //para que el campo no sea nullo ni vacio
        if (personaAsignada == null || personaAsignada.trim().isEmpty()) {
            throw new IllegalArgumentException("La persona asignada no puede estar vacía.");
        }
        this.personaAsignada = personaAsignada;
    }


    //  fines de depuración y registro, y cuando el objeto Ticket como una cadena en tu interfaz de usuario.
    @Override
    public String toString() {
        return "Ticket{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", departamentoAsignado='" + departamentoAsignado + '\'' +
                ", personaAsignada='" + personaAsignada + '\'' +
                '}';
    }

}



