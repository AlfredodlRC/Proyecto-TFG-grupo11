package com.example.ticktask;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String titulo;
    private String prioridad;
    private String tipoIncidencia;
    private String fechaCreacion;
    private String personaCreadora;
    private String departamentoAsignado;
    private String personaAsignada;
    private String descripcion;


    //Creamos el constructor
    public Ticket(String titulo, String prioridad, String tipoIncidencia, String fechaCreacion,
                  String personaCreadora, String departamentoAsignado, String personaAsignada, String descripcion) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.tipoIncidencia = tipoIncidencia;
        this.fechaCreacion = fechaCreacion;
        this.personaCreadora = personaCreadora;
        this.departamentoAsignado = departamentoAsignado;
        this.personaAsignada = personaAsignada;
        this.descripcion = descripcion;
    }

    public Ticket() {

    }
    // Getters


    public String getTitulo() {
        return titulo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getPersonaCreadora() {
        return personaCreadora;
    }

    public String getDepartamento() {
        return departamentoAsignado;
    }

    public String getPersonaAsignada() {
        return personaAsignada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setPersonaCreadora(String personaCreadora) {
        this.personaCreadora = personaCreadora;
    }

    public void setDepartamentoAsignado(String departamentoAsignado) {
        this.departamentoAsignado = departamentoAsignado;
    }

    public void setPersonaAsignada(String personaAsignada) {
        this.personaAsignada = personaAsignada;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getId() {
        return 0;
    }
}

