package serviciorest.modelo.persistencia;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import serviciorest.modelo.entidad.Ticket;

/**
 * Patron DAO (Data Access Object), objeto que se encarga de hacer las consultas
 * a algun motor de persistencia (BBDD, Ficheros, etc).
 * 
 * 
 * Mediante la anotacion @Component, damos de alta un unico objeto de esta clase
 * dentro del contexto de Spring, su ID sera el nombre de la case en notacion
 * lowerCamelCase
 * 
 */
@Component
public class DaoTicket {


	
	/**
	 * Cuando se cree el objeto dentro del contexto de Spring, se ejecutara
	 * su constructor
	 */
	public DaoTicket() {
	}
	
	/**
	 * Devuelve un ticket a partir de su posicion del array
	 * @param posicion la posicion del array que buscamos
	 * @return el ticket seleccionado
	 */
	public Ticket get(int posicion) {
		Ticket resultado = new Ticket();
		
		try {
		
			return resultado;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * Metodo que devuelve todos los ticket
	 * @return una lista con todos los ticket
	 */
	public List<Ticket> list() {
		List<Ticket> resultado = new ArrayList<Ticket>(); 
		return resultado;
	}
	
	/**
	 * Metodo que introduce un ticket
	 * @param p el ticket que queremos introducir
	 */
	public void add(Ticket t) {
	}
	
	/**
	 * Borramos un ticket
	 * @param posicion la pk a borrar
	 * @return devolvemos el ticket que hemos quitado , 
	 * o null en caso de que no exista.
	 */
	public Ticket delete(int posicion) {
		Ticket resultado = null;
		try {
		} catch (Exception ex) {
			return null;
		}		
		return resultado;
	}
	
	/**
	 * Metodo que modifica un ticket
	 * @param ticke contiene todos los datos que queremos modifica
	 * @return el ticket modificado en caso de que exista, null en caso
	 * contrario
	 */
	public Ticket update(Ticket ticke) {
		Ticket resultado = null;
		try {
		} catch (IndexOutOfBoundsException iobe) {
			return null;
		}
		return resultado;
	}
	
}
