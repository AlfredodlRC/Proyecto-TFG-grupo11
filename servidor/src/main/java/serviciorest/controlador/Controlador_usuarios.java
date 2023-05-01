package serviciorest.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.bbdd.CRUD_firebase;
import serviciorest.modelo.entidad.Usuario;

@RestController
public class Controlador_usuarios {

	@Autowired
	CRUD_firebase acceso;
	
	@GetMapping(path="personas/listado",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Usuario>> get_tipos() {
		List<Usuario> resultado = new ArrayList<Usuario>();
		resultado = acceso.leer_usuarios();
		return new ResponseEntity<List<Usuario>>(resultado,HttpStatus.OK);//200 OK
	}


	
}
