package serviciorest.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.bbdd.CRUD_firebase;
import serviciorest.modelo.entidad.Comentario;
import serviciorest.modelo.entidad.Estado;
import serviciorest.modelo.entidad.Incidencia;
import serviciorest.modelo.entidad.Mensaje;
import serviciorest.modelo.entidad.Prioridad;
import serviciorest.modelo.entidad.Tipo_incidencia;



@RestController
public class Controlador_incidencias {


	@Autowired
	CRUD_firebase acceso;
	
	@GetMapping(path="incidencia/tipos",produces = MediaType.APPLICATION_JSON_VALUE)	
	//@RequestMapping(method = RequestMethod.GET, value = "incidencia/tipos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tipo_incidencia>> get_tipos() {
		List<Tipo_incidencia> resultado = new ArrayList<Tipo_incidencia>();
		resultado = acceso.leer_tipos_incidencias();
		return new ResponseEntity<List<Tipo_incidencia>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/prioridades",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Prioridad>> get_prioridades() {
		List<Prioridad> resultado = new ArrayList<Prioridad>();
		resultado = acceso.leer_prioridades();
		return new ResponseEntity<List<Prioridad>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/estados",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Estado>> get_estados() {
		List<Estado> resultado = new ArrayList<Estado>();
		resultado = acceso.leer_estados();
		return new ResponseEntity<List<Estado>>(resultado,HttpStatus.OK);//200 OK
	}
	
	@GetMapping(path="incidencia/incidencias",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Incidencia>> get_todas_incidencias() {
		List<Incidencia> resultado = new ArrayList<Incidencia>();
		resultado = acceso.leer_todas_incidencias();
		return new ResponseEntity<List<Incidencia>>(resultado,HttpStatus.OK);//200 OK
	}


	@GetMapping(path="incidencia/mensajes",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Mensaje>> get_todos_mensajes() {
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		resultado = acceso.leer_todos_mensajes();
		return new ResponseEntity<List<Mensaje>>(resultado,HttpStatus.OK);//200 OK
	}


	@GetMapping(path="incidencia/comentarios",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Comentario>> get_todos_comentarios() {
		List<Comentario> resultado = new ArrayList<Comentario>();
		resultado = acceso.leer_todos_comentarios();
		return new ResponseEntity<List<Comentario>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/creada/id/{id_usuario}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Incidencia>> get_incidencia_creada_usuario_id(@PathVariable("id_usuario") int id_usuario ) {
		List<Incidencia> resultado = new ArrayList<Incidencia>();
		resultado = acceso.leer_incidencias_creada_usuario_id(id_usuario);
		return new ResponseEntity<List<Incidencia>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/creada/nombre/{nombre_usuario}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Incidencia>> get_incidencia_creada_usuario_id(@PathVariable("nombre_usuario") String nombre_usuario ) {
		List<Incidencia> resultado = new ArrayList<Incidencia>();
		resultado = acceso.leer_incidencias_creada_usuario_nombre(nombre_usuario);
		return new ResponseEntity<List<Incidencia>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/asignada/id/{id_usuario}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Incidencia>> get_incidencia_asignada_usuario_id(@PathVariable("id_usuario") int id_usuario ) {
		List<Incidencia> resultado = new ArrayList<Incidencia>();
		resultado = acceso.leer_incidencias_asignada_usuario_id(id_usuario);
		return new ResponseEntity<List<Incidencia>>(resultado,HttpStatus.OK);//200 OK
	}

	@GetMapping(path="incidencia/asignada/nombre/{nombre_usuario}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Incidencia>> get_incidencia_asignada_usuario_id(@PathVariable("nombre_usuario") String nombre_usuario ) {
		List<Incidencia> resultado = new ArrayList<Incidencia>();
		resultado = acceso.leer_incidencias_asignada_usuario_nombre(nombre_usuario);
		return new ResponseEntity<List<Incidencia>>(resultado,HttpStatus.OK);//200 OK
	}

	
}
