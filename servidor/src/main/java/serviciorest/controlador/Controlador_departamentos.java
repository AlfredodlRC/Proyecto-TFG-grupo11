package serviciorest.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.bbdd.CRUD_firebase;
import serviciorest.modelo.entidad.Departamento;


@RestController
public class Controlador_departamentos {

	@Autowired
	CRUD_firebase acceso;
	
	@GetMapping(value = "mensaje")
	public String obtenerMensaje() {
		return "Número de departamentos:" ;
		//return "Esto es un mensaje de prueba";
	}
	

	@GetMapping(path="departamentos/listado",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Departamento>> get_departamentos() {
		List<Departamento> resultado = new ArrayList<Departamento>();
		resultado = acceso.leer_departamentos();
		return new ResponseEntity<List<Departamento>>(resultado,HttpStatus.OK);//200 OK
	}
	
	
}

