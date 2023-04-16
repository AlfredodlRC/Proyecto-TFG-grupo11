package serviciorest.controlador;
import serviciorest.modelo.entidad.Ticket;
import serviciorest.modelo.persistencia.DaoTicket;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorTicket {

	
	@Autowired
	private DaoTicket dao_ticket;
	
	@GetMapping(path="ticket/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Ticket> get_ticket(@PathVariable("id") int id) {
		Ticket t = dao_ticket.get(id);
		if(t != null) {
			return new ResponseEntity<Ticket>(t,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	@PostMapping(path="tickets",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> alta_ticket(@RequestBody Ticket t) {
		dao_ticket.add(t);
		return new ResponseEntity<Ticket>(t,HttpStatus.CREATED);//201 CREATED
	}
	
	
	@GetMapping(path="tickets",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> listar_tickets() {
		List<Ticket> lista_tickets = null;
		lista_tickets = dao_ticket.list();			
		System.out.println(lista_tickets);
		return new ResponseEntity<List<Ticket>>(lista_tickets,HttpStatus.OK);
	}
	
	@PutMapping(path="ticket/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ticket> modificar_ticket(
			@PathVariable("id") int id, 
			@RequestBody Ticket t) {
		// Realizar los cambios
		Ticket tUpdate = dao_ticket.update(t);
		if(tUpdate != null) {
			return new ResponseEntity<Ticket>(t,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	@DeleteMapping(path="tickets/{id}")
	public ResponseEntity<Ticket> borrar_ticket(@PathVariable("id") int id) {
		System.out.println("ID a borrar: " + id);
		Ticket t = dao_ticket.delete(id);
		if(t != null) {
			return new ResponseEntity<Ticket>(t,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
}
