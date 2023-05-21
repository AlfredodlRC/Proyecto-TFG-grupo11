package com.example.ticktask.retrofit.POJOS;

public class Incidencia {
        private String descripcion;
        private String fecha_creacion;
        private String fecha_finalizacion;
        private String nombre;
        private float fk_prioridad;
        private float fk_estado;
        private float fk_departamento_destino;
        private float tiempo_resolucion;
        private float fk_persona_destino;
        private float fk_persona_origen;
        private float fk_tipo_incidencia;

        public Incidencia() {
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getFecha_creacion() {
            return fecha_creacion;
        }

        public String getFecha_finalizacion() {
            return fecha_finalizacion;
        }

        public String getNombre() {
            return nombre;
        }

        public float getFk_prioridad() {
            return fk_prioridad;
        }

        public float getFk_estado() {
            return fk_estado;
        }

        public float getFk_departamento_destino() {
            return fk_departamento_destino;
        }

        public float getTiempo_resolucion() {
            return tiempo_resolucion;
        }

        public float getFk_persona_destino() {
            return fk_persona_destino;
        }

        public float getFk_persona_origen() {
            return fk_persona_origen;
        }

        public float getFk_tipo_incidencia() {
            return fk_tipo_incidencia;
        }

        // Setter Methods

        public void setDescripcion( String descripcion ) {
            this.descripcion = descripcion;
        }

        public void setFecha_creacion( String fecha_creacion ) {
            this.fecha_creacion = fecha_creacion;
        }

        public void setFecha_finalizacion( String fecha_finalizacion ) {
            this.fecha_finalizacion = fecha_finalizacion;
        }

        public void setNombre( String nombre ) {
            this.nombre = nombre;
        }

        public void setFk_prioridad( float fk_prioridad ) {
            this.fk_prioridad = fk_prioridad;
        }

        public void setFk_estado( float fk_estado ) {
            this.fk_estado = fk_estado;
        }

        public void setFk_departamento_destino( float fk_departamento_destino ) {
            this.fk_departamento_destino = fk_departamento_destino;
        }

        public void setTiempo_resolucion( float tiempo_resolucion ) {
            this.tiempo_resolucion = tiempo_resolucion;
        }

        public void setFk_persona_destino( float fk_persona_destino ) {
            this.fk_persona_destino = fk_persona_destino;
        }

        public void setFk_persona_origen( float fk_persona_origen ) {
            this.fk_persona_origen = fk_persona_origen;
        }

        public void setFk_tipo_incidencia( float fk_tipo_incidencia ) {
            this.fk_tipo_incidencia = fk_tipo_incidencia;
        }
}
