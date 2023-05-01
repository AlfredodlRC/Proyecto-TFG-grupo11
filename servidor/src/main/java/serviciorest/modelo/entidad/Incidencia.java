package serviciorest.modelo.entidad;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.type.DateTime;

@Component
public class Incidencia {

	@DocumentId
	private int pk;
	private String nombre;
	private String Descripción;
	private int fk_tipo_incidencia;
	private int fk_prioridad;
	private int fk_persona_origen;
	private int fk_departamento_destino;
	private int fk_persona_destino;
	private Date fecha_creación;
	private Date fecha_finalizacion;
	private int tiempo_resolucion;
	private int fk_estado;
	
	public Incidencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Incidencia(int pk, String nombre, String descripción, int fk_tipo_incidencia, int fk_prioridad,
			int fk_persona_origen, int fk_departamento_destino, int fk_persona_destino, Date fecha_creación,
			Date fecha_finalizacion, int tiempo_resolucion, int fk_estado) {
		super();
		this.pk = pk;
		this.nombre = nombre;
		Descripción = descripción;
		this.fk_tipo_incidencia = fk_tipo_incidencia;
		this.fk_prioridad = fk_prioridad;
		this.fk_persona_origen = fk_persona_origen;
		this.fk_departamento_destino = fk_departamento_destino;
		this.fk_persona_destino = fk_persona_destino;
		this.fecha_creación = fecha_creación;
		this.fecha_finalizacion = fecha_finalizacion;
		this.tiempo_resolucion = tiempo_resolucion;
		this.fk_estado = fk_estado;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return Descripción;
	}

	public void setDescripción(String descripción) {
		Descripción = descripción;
	}

	public int getFk_tipo_incidencia() {
		return fk_tipo_incidencia;
	}

	public void setFk_tipo_incidencia(int fk_tipo_incidencia) {
		this.fk_tipo_incidencia = fk_tipo_incidencia;
	}

	public int getFk_prioridad() {
		return fk_prioridad;
	}

	public void setFk_prioridad(int fk_prioridad) {
		this.fk_prioridad = fk_prioridad;
	}

	public int getFk_persona_origen() {
		return fk_persona_origen;
	}

	public void setFk_persona_origen(int fk_persona_origen) {
		this.fk_persona_origen = fk_persona_origen;
	}

	public int getFk_departamento_destino() {
		return fk_departamento_destino;
	}

	public void setFk_departamento_destino(int fk_departamento_destino) {
		this.fk_departamento_destino = fk_departamento_destino;
	}

	public int getFk_persona_destino() {
		return fk_persona_destino;
	}

	public void setFk_persona_destino(int fk_persona_destino) {
		this.fk_persona_destino = fk_persona_destino;
	}

	public Date getFecha_creación() {
		return fecha_creación;
	}

	public void setFecha_creación(Date fecha_creación) {
		this.fecha_creación = fecha_creación;
	}

	public Date getFecha_finalizacion() {
		return fecha_finalizacion;
	}

	public void setFecha_finalizacion(Date fecha_finalizacion) {
		this.fecha_finalizacion = fecha_finalizacion;
	}

	public int getTiempo_resolucion() {
		return tiempo_resolucion;
	}

	public void setTiempo_resolucion(int tiempo_resolucion) {
		this.tiempo_resolucion = tiempo_resolucion;
	}

	public int getFk_estado() {
		return fk_estado;
	}

	public void setFk_estado(int fk_estado) {
		this.fk_estado = fk_estado;
	}

	
}
