package serviciorest.bbdd;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.type.DateTime;

import serviciorest.modelo.entidad.Comentario;
import serviciorest.modelo.entidad.Departamento;
import serviciorest.modelo.entidad.Estado;
import serviciorest.modelo.entidad.Incidencia;
import serviciorest.modelo.entidad.Mensaje;
import serviciorest.modelo.entidad.Prioridad;
import serviciorest.modelo.entidad.Tipo_incidencia;
import serviciorest.modelo.entidad.Usuario;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;



@Service
public class CRUD_firebase {

	public List<Departamento> leer_departamentos() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("departamentos");
        List<Departamento> resultado = new ArrayList<Departamento>();
        
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
				System.out.println(depart.getId()+"-"+depart.get().get().getString("nombre"));
				resultado.add(new Departamento(Integer.valueOf(depart.getId()),depart.get().get().getString("nombre")));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
		return resultado;
	}
	

	
	public List<Prioridad> leer_prioridades() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("prioridades");
        List<Prioridad> resultado = new ArrayList<Prioridad>();
        
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
				System.out.println(depart.getId()+"-"+depart.get().get().getString("nombre"));
				resultado.add(new Prioridad(Integer.valueOf(depart.getId()),depart.get().get().getString("nombre")));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
		return resultado;
	}
	
	
	public List<Tipo_incidencia> leer_tipos_incidencias() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("tipos_incidencias");
        List<Tipo_incidencia> resultado = new ArrayList<Tipo_incidencia>();
        
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
				System.out.println(depart.getId()+"-"+depart.get().get().getString("nombre"));
				resultado.add(new Tipo_incidencia(Integer.valueOf(depart.getId()),depart.get().get().getString("nombre")));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}
	
	
	
	public List<Estado> leer_estados() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("estados");
        List<Estado> resultado = new ArrayList<Estado>();
        
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
				System.out.println(depart.getId()+"-"+depart.get().get().getString("nombre"));
				resultado.add(new Estado(Integer.valueOf(depart.getId()),depart.get().get().getString("nombre")));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}
	
	public List<Usuario> leer_usuarios() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("usuarios");
        List<Usuario> resultado = new ArrayList<Usuario>();
        int pk;
        String nombre;
        String email;
        String password;
        long fk_departamento;
        
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
            	
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                email = depart.get().get().getString("email");
                password = depart.get().get().getString("password");
                fk_departamento = depart.get().get().getLong("fk_departamento");

            	
				resultado.add(new Usuario(pk, nombre, email, password, fk_departamento));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}
	
	
	
	public List<Incidencia> leer_todas_incidencias() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("incidencias");
        List<Incidencia> resultado = new ArrayList<Incidencia>();
        Incidencia nueva;
        
        int pk;
        String nombre;
        String descripción;
        int fk_tipo_incidencia;
        int fk_prioridad;        
    	int fk_persona_origen;
    	int fk_departamento_destino;
    	int fk_persona_destino;
    	Date fecha_creación;
    	Date fecha_finalizacion;
    	int tiempo_resolucion;
    	int fk_estado;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                descripción = depart.get().get().getString("descripción");
                fk_tipo_incidencia = depart.get().get().getLong("fk_tipo_incidencia").intValue();
                fk_prioridad = depart.get().get().getLong("fk_prioridad").intValue();
            	fk_persona_origen = depart.get().get().getLong("fk_persona_origen").intValue();
            	fk_departamento_destino = depart.get().get().getLong("fk_departamento_destino").intValue();
            	fk_persona_destino = depart.get().get().getLong("fk_persona_destino").intValue();
            	fecha_creación = depart.get().get().getDate("fecha_creación");
            	fecha_finalizacion = depart.get().get().getDate("fecha_finalizacion");
            	tiempo_resolucion = depart.get().get().getLong("tiempo_resolucion").intValue();
            	fk_estado = depart.get().get().getLong("fk_estado").intValue();
            	nueva = new Incidencia(pk, nombre, descripción, fk_tipo_incidencia, fk_prioridad,
            			fk_persona_origen, fk_departamento_destino, fk_persona_destino, fecha_creación,
            			fecha_finalizacion, tiempo_resolucion, fk_estado);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}
	

	
	
	
	
	public List<Mensaje> leer_todos_mensajes() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("mensajes");
        List<Mensaje> resultado = new ArrayList<Mensaje>();
        Mensaje nueva;
        
    	int pk;
    	Date fecha_creacion;
    	int fk_incidencia;
    	int fk_usuario;
    	String texto;
    	
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
            	fecha_creacion = depart.get().get().getDate("fecha_creacion");
            	fk_incidencia = depart.get().get().getLong("fk_incidencia").intValue();
            	fk_usuario = depart.get().get().getLong("fk_usuario").intValue();
            	texto = depart.get().get().getString("texto");
            	nueva = new Mensaje(pk, fecha_creacion, fk_incidencia, fk_usuario, texto);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}

	public List<Comentario> leer_todos_comentarios() {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("comentarios");
        List<Comentario> resultado = new ArrayList<Comentario>();
        Comentario nueva;
        
    	int pk;
    	Date fecha_creacion;
    	int fk_incidencia;
    	int fk_mensaje;
    	String texto;
    	int fk_usuario;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
            	fecha_creacion = depart.get().get().getDate("fecha_creacion");
            	fk_incidencia = depart.get().get().getLong("fk_incidencia").intValue();
            	fk_usuario = depart.get().get().getLong("fk_usuario").intValue();
            	fk_mensaje = depart.get().get().getLong("fk_mensaje").intValue();
            	texto = depart.get().get().getString("texto");
            	nueva = new Comentario(pk, fecha_creacion, fk_incidencia, fk_mensaje, fk_usuario, texto);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Incidencia> leer_incidencias_creada_usuario_id(int id_usuario) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("incidencias");
        List<Incidencia> resultado = new ArrayList<Incidencia>();
        Incidencia nueva;
        
        int pk;
        String nombre;
        String descripción;
        int fk_tipo_incidencia;
        int fk_prioridad;        
    	int fk_persona_origen;
    	int fk_departamento_destino;
    	int fk_persona_destino;
    	Date fecha_creación;
    	Date fecha_finalizacion;
    	int tiempo_resolucion;
    	int fk_estado;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                descripción = depart.get().get().getString("descripción");
                fk_tipo_incidencia = depart.get().get().getLong("fk_tipo_incidencia").intValue();
                fk_prioridad = depart.get().get().getLong("fk_prioridad").intValue();
            	fk_persona_origen = depart.get().get().getLong("fk_persona_origen").intValue();
            	fk_departamento_destino = depart.get().get().getLong("fk_departamento_destino").intValue();
            	fk_persona_destino = depart.get().get().getLong("fk_persona_destino").intValue();
            	fecha_creación = depart.get().get().getDate("fecha_creación");
            	fecha_finalizacion = depart.get().get().getDate("fecha_finalizacion");
            	tiempo_resolucion = depart.get().get().getLong("tiempo_resolucion").intValue();
            	fk_estado = depart.get().get().getLong("fk_estado").intValue();
            	nueva = new Incidencia(pk, nombre, descripción, fk_tipo_incidencia, fk_prioridad,
            			fk_persona_origen, fk_departamento_destino, fk_persona_destino, fecha_creación,
            			fecha_finalizacion, tiempo_resolucion, fk_estado);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}

	public List<Incidencia> leer_incidencias_creada_usuario_nombre(String nombre_usuario) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("incidencias");
        List<Incidencia> resultado = new ArrayList<Incidencia>();
        Incidencia nueva;
        
        int pk;
        String nombre;
        String descripción;
        int fk_tipo_incidencia;
        int fk_prioridad;        
    	int fk_persona_origen;
    	int fk_departamento_destino;
    	int fk_persona_destino;
    	Date fecha_creación;
    	Date fecha_finalizacion;
    	int tiempo_resolucion;
    	int fk_estado;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                descripción = depart.get().get().getString("descripción");
                fk_tipo_incidencia = depart.get().get().getLong("fk_tipo_incidencia").intValue();
                fk_prioridad = depart.get().get().getLong("fk_prioridad").intValue();
            	fk_persona_origen = depart.get().get().getLong("fk_persona_origen").intValue();
            	fk_departamento_destino = depart.get().get().getLong("fk_departamento_destino").intValue();
            	fk_persona_destino = depart.get().get().getLong("fk_persona_destino").intValue();
            	fecha_creación = depart.get().get().getDate("fecha_creación");
            	fecha_finalizacion = depart.get().get().getDate("fecha_finalizacion");
            	tiempo_resolucion = depart.get().get().getLong("tiempo_resolucion").intValue();
            	fk_estado = depart.get().get().getLong("fk_estado").intValue();
            	nueva = new Incidencia(pk, nombre, descripción, fk_tipo_incidencia, fk_prioridad,
            			fk_persona_origen, fk_departamento_destino, fk_persona_destino, fecha_creación,
            			fecha_finalizacion, tiempo_resolucion, fk_estado);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Incidencia> leer_incidencias_asignada_usuario_id(int id_usuario) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("incidencias");
        List<Incidencia> resultado = new ArrayList<Incidencia>();
        Incidencia nueva;
        
        int pk;
        String nombre;
        String descripción;
        int fk_tipo_incidencia;
        int fk_prioridad;        
    	int fk_persona_origen;
    	int fk_departamento_destino;
    	int fk_persona_destino;
    	Date fecha_creación;
    	Date fecha_finalizacion;
    	int tiempo_resolucion;
    	int fk_estado;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                descripción = depart.get().get().getString("descripción");
                fk_tipo_incidencia = depart.get().get().getLong("fk_tipo_incidencia").intValue();
                fk_prioridad = depart.get().get().getLong("fk_prioridad").intValue();
            	fk_persona_origen = depart.get().get().getLong("fk_persona_origen").intValue();
            	fk_departamento_destino = depart.get().get().getLong("fk_departamento_destino").intValue();
            	fk_persona_destino = depart.get().get().getLong("fk_persona_destino").intValue();
            	fecha_creación = depart.get().get().getDate("fecha_creación");
            	fecha_finalizacion = depart.get().get().getDate("fecha_finalizacion");
            	tiempo_resolucion = depart.get().get().getLong("tiempo_resolucion").intValue();
            	fk_estado = depart.get().get().getLong("fk_estado").intValue();
            	nueva = new Incidencia(pk, nombre, descripción, fk_tipo_incidencia, fk_prioridad,
            			fk_persona_origen, fk_departamento_destino, fk_persona_destino, fecha_creación,
            			fecha_finalizacion, tiempo_resolucion, fk_estado);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}

	public List<Incidencia> leer_incidencias_asignada_usuario_nombre(String nombre_usuario) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference ref_coleccion = dbFirestore.collection("incidencias");
        List<Incidencia> resultado = new ArrayList<Incidencia>();
        Incidencia nueva;
        
        int pk;
        String nombre;
        String descripción;
        int fk_tipo_incidencia;
        int fk_prioridad;        
    	int fk_persona_origen;
    	int fk_departamento_destino;
    	int fk_persona_destino;
    	Date fecha_creación;
    	Date fecha_finalizacion;
    	int tiempo_resolucion;
    	int fk_estado;
        for(DocumentReference depart : ref_coleccion.listDocuments()) {
            try {
                pk = Integer.valueOf(depart.getId());
                nombre = depart.get().get().getString("nombre");
                descripción = depart.get().get().getString("descripción");
                fk_tipo_incidencia = depart.get().get().getLong("fk_tipo_incidencia").intValue();
                fk_prioridad = depart.get().get().getLong("fk_prioridad").intValue();
            	fk_persona_origen = depart.get().get().getLong("fk_persona_origen").intValue();
            	fk_departamento_destino = depart.get().get().getLong("fk_departamento_destino").intValue();
            	fk_persona_destino = depart.get().get().getLong("fk_persona_destino").intValue();
            	fecha_creación = depart.get().get().getDate("fecha_creación");
            	fecha_finalizacion = depart.get().get().getDate("fecha_finalizacion");
            	tiempo_resolucion = depart.get().get().getLong("tiempo_resolucion").intValue();
            	fk_estado = depart.get().get().getLong("fk_estado").intValue();
            	nueva = new Incidencia(pk, nombre, descripción, fk_tipo_incidencia, fk_prioridad,
            			fk_persona_origen, fk_departamento_destino, fk_persona_destino, fecha_creación,
            			fecha_finalizacion, tiempo_resolucion, fk_estado);
				resultado.add(nueva);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		return resultado;
	}

	


}
