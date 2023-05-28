package com.example.ticktask.retrofit.POJOS;

public class Incidencia {

    private int pk = 0;
    private String descripcion;
    private String fecha_creacion;
    private String fecha_finalizacion;
    private String departamento_destino;
    private String estado;
    private String persona_destino;
    private String persona_origen;
    private String prioridad;
    private String tipo_incidencia;
    private String nombre;
    private int tiempo_resolucion;

    public Incidencia() {
        }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDepartamento_destino() {
        return departamento_destino;
    }

    public void setDepartamento_destino(String departamento_destino) {
        this.departamento_destino = departamento_destino;
    }

    public float getTiempo_resolucion() {
        return tiempo_resolucion;
    }

    public void setTiempo_resolucion(int tiempo_resolucion) {
        this.tiempo_resolucion = tiempo_resolucion;
    }

    public String getPersona_destino() {
        return persona_destino;
    }

    public void setPersona_destino(String persona_destino) {
        this.persona_destino = persona_destino;
    }

    public String getPersona_origen() {
        return persona_origen;
    }

    public void setPersona_origen(String persona_origen) {
        this.persona_origen = persona_origen;
    }

    public String getTipo_incidencia() {
        return tipo_incidencia;
    }

    public void setTipo_incidencia(String tipo_incidencia) {
        this.tipo_incidencia = tipo_incidencia;
    }
}
