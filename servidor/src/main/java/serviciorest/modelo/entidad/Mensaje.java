package serviciorest.modelo.entidad;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.annotation.DocumentId;

@Component
public class Mensaje {
	@DocumentId
	private int pk;
	private Date fecha_creacion;
	private int fk_incidencia;
	private int fk_usuario;
	private String texto;

	
	public Mensaje() {
		super();
	}


	public Mensaje(int pk, Date fecha_creacion, int fk_incidencia, int fk_usuario, String texto) {
		super();
		this.pk = pk;
		this.fecha_creacion = fecha_creacion;
		this.fk_incidencia = fk_incidencia;
		this.fk_usuario = fk_usuario;
		this.texto = texto;
	}


	public int getPk() {
		return pk;
	}


	public void setPk(int pk) {
		this.pk = pk;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public int getFk_incidencia() {
		return fk_incidencia;
	}


	public void setFk_incidencia(int fk_incidencia) {
		this.fk_incidencia = fk_incidencia;
	}


	public int getFk_usuario() {
		return fk_usuario;
	}


	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	


}
