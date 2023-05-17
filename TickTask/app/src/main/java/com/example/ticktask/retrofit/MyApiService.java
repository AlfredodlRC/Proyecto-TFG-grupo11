package com.example.ticktask.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApiService {
    @POST("login/nombre")
    Call<Boolean> getLogin_nombre(
            @Query("nombre") String username,
            @Query("password") String password
    );

    @POST("login/email")
    Call<Boolean> getLogin_email(
            @Query("email") String username,
            @Query("password") String password
    );

    /**
    @router.get("/departamentos/")
    @router.get("/estados/")
    @router.get("/prioridades/")
    @router.get("/tipo_incidenias/")
    @router.get("/usuarios/departamento/{id}")
     @router.put("/incidencia/crear/")
     @router.post("/incidencia/cerrar/id/{id}")
     @router.post("/incidencia/rechazar/id/{id}")
     @router.get("/incidencias/creador/id/{id}")
     @router.get("/incidencias/solucionador/id/{id}")
     @router.post("/incidencia/id/{id}/mensaje/nuevo/{texto}/usuario/id{id_usuario}")
     @router.post("/mensaje/eliminar/{id}")
     @router.post("/incidencia/id/{nombre}/comentario/nuevo/{texto}/usuario/id{id_usuario}")
     @router.post("/comentario/eliminar/{id}")
     @router.post("/mensaje/{id}/comentario/nuevo/{texto}/usuario/id/{d_usuario}")
    */

}
