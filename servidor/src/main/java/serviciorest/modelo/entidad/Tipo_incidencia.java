package serviciorest.modelo.entidad;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.annotation.DocumentId;

@Component
public class Tipo_incidencia {
	@DocumentId
	private int pk;
	private String nombre;

	
	public Tipo_incidencia() {
		super();
	}


	public Tipo_incidencia(int id, String nombre) {
		super();
		
		this.pk = id;
		this.nombre = nombre;
	}


	public int getPK() {
		return this.pk;
	}
	
	public void setPK(int pk) {
		this.pk = pk;
	}
	
	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
