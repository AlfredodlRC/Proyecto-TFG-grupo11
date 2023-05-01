package serviciorest.modelo.entidad;

import org.springframework.stereotype.Component;

import com.google.cloud.firestore.annotation.DocumentId;

@Component
public class Usuario {
	@DocumentId
	private int pk;
	private String nombre;
	private String email;
	private String password;
	private long fk_departamento;
	
	public Usuario() {
		super();
	}


	public Usuario(int pk, String nombre, String email, String password, long fk_departamento) {
		super();
		this.pk = pk;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fk_departamento = fk_departamento;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getFk_departamento() {
		return fk_departamento;
	}


	public void setFk_departamento(long fk_departamento) {
		this.fk_departamento = fk_departamento;
	}


}
