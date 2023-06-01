package com.example.ticktask.retrofit;

import com.example.ticktask.retrofit.POJOS.Departamento;
import com.example.ticktask.retrofit.POJOS.Estado;
import com.example.ticktask.retrofit.POJOS.Incidencia;
import com.example.ticktask.retrofit.POJOS.Prioridad;
import com.example.ticktask.retrofit.POJOS.Tipo_incidencia;
import com.example.ticktask.retrofit.POJOS.Respuesta_usuario_login;
import com.example.ticktask.retrofit.POJOS.Usuario_login_email;
import com.example.ticktask.retrofit.POJOS.Usuario_login_nombre;
import com.example.ticktask.retrofit.POJOS.Usuario_simple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MyApiService {
    @POST("/login/nombre")
    Call<Respuesta_usuario_login> getLogin_nombre(
            @Body Usuario_login_nombre usuario
            );

    @POST("/login/email")
    Call<Respuesta_usuario_login> getLogin_email(@Body Usuario_login_email usuario);
    @GET("/departamentos")
    Call<List<Departamento>> get_departamentos();
    @GET("/estados")
    Call<List<Estado>> get_estados();
    @GET("/prioridades")
    Call<List<Prioridad>> get_Prioridades();
    @GET("/tipo_incidenias/")
    Call<List<Tipo_incidencia>> get_tipo_incidencias();
    @GET("/usuarios/departamento/{id}")
    Call<List<Usuario_simple>> get_usuarios_de_departamento(@Path("id") int id);
    @PUT("/incidencia/crear/")
    Call<Boolean> put_crear_incidencia(@Body Incidencia incidencia);
    @POST("/incidencia/cerrar/id/{id}")
    Call<Boolean> post_cerrar_incidencia(@Path("id") int id);
    @POST("/incidencia/rechazar/id/{id}")
    Call<Boolean> post_rechazar_incidencia(@Path("id") int id, Incidencia incidencia);
    @GET("/incidencias/creador/id/{id}")
    Call<List<Incidencia>> get_incidencias_de_creador(@Path("id") int id);
    @GET("/incidencias/solucionador/id/{id}")
    Call<List<Incidencia>> get_incidencias_de_solucionador(@Path("id") int id);
    @POST("/incidencia/id/{id}/mensaje/nuevo/{texto}/usuario/id{id_usuario}")
    Call<Boolean> post_nuevo_mensaje_en_incidencia(@Path("id_usuario") int id_usuario);
    @POST("/mensaje/eliminar/{id}")
    Call<Boolean> post_eliminar_mensaje(@Path("id") int id);
    @POST("/incidencia/id/{nombre}/comentario/nuevo/{texto}/usuario/id{id_usuario}")
    Call<Boolean> post_nuevo_comentario_de_incidencia(@Path("id_usuario") int id_usuario);
    @POST("/comentario/eliminar/{id}")
    Call<Boolean> post_liminar_comentario(@Path("id") int id);
    @POST("/mensaje/{id}/comentario/nuevo/{texto}/usuario/id/{id_usuario}")
    Call<Boolean> post_nuevo_comentario_en_mensaje(@Path("id_usuario") int id_usuario);
    // Suponemos que el endpoint para cambiar el estado de un ticket es "/incidencia/actualizar/{id}"

    @PUT("/incidencia/actualizar/{id}")
    Call<Boolean> put_actualizar_incidencia(@Path("id") int id, @Body Incidencia incidencia);

    @PUT("/incidencia/{id}/asignar")
    Call<Boolean> asignarIncidenciaAUsuario(@Path("id") int id, @Body Usuario_simple usuario);




}
