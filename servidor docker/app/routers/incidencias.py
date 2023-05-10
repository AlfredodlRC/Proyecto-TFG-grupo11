from fastapi import APIRouter
from app.schemas.incidencia import Incidencia_API

from app.bbdd.acceso import AccesoBBDD


router = APIRouter()
# crear incidecia 
@router.put("/incidencia/crear/")
async def crear_incidencia(incidencia: Incidencia_API):
    acceso = AccesoBBDD()
    resultado = acceso.crear_incidencia(incidencia)
    return resultado
# cerrar incidencia
@router.post("/incidencia/cerrar/id/{id}")
async def cerrar_incidencia(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.cerrar_incidencia(id)
    return resultado
# rechazar incidencia
@router.post("/incidencia/rechazar/id/{id}")
async def rechazar_incidencia(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.rechazar_incidencia(id)
    return resultado
# traer incidencias por creador id-nombre activas-resueltas-rechazadas
@router.get("/incidencias/creador/id/{id}")
async def listar_incidencia_creador(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.listar_incidencias(id,"creador")
    return resultado
# traer incidencias por solucionador id-nombre activas-resueltas-rechazadas
@router.get("/incidencias/solucionador/id/{id}")
async def listar_incidencia_solucionador(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.listar_incidencias(id,"solucionador")
    return resultado
# agregar mensaje a incidencia(pk-nombre) usuario (nombre)
@router.post("/incidencia/id/{id}/mensaje/nuevo/{texto}/usuario/id{id_usuario}")
async def anyadir_mensaje(id: int | None, texto: str, id_usuario: int | None):
    acceso = AccesoBBDD()
    resultado = acceso.anyadir_mensaje(texto, id, id_usuario)
    return resultado
# eliminar mensaje(id) de incidencia(pk-nombre) usuario (nombre)
@router.post("/mensaje/eliminar/{id}")
async def eliminar_mensaje(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.eliminar_mensaje(id)
    return resultado
# agregar comentario a incidencia(pk-nombre) usuario (nombre)
@router.post("/incidencia/id/{nombre}/comentario/nuevo/{texto}/usuario/id{id_usuario}")
async def anyadir_comentario_incidencia(id: int, texto: str, id_usuario: int):
    acceso = AccesoBBDD()
    resultado = acceso.anyadir_comentario_incidencia(texto, id, id_usuario)
    return resultado
# eliminar comentario(id)
@router.post("/comentario/eliminar/{id}")
async def eliminar_comentario_incidencia(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.eliminar_comentario(id)
    return resultado
# agregar comentario a mensaje(pk-nombre) usuario (nombre)
@router.post("/mensaje/{id}/comentario/nuevo/{texto}/usuario/id/{d_usuario}")
async def anyadir_comentario_mensaje(id: int, texto: str, id_usuario: int):
    acceso = AccesoBBDD()
    resultado = acceso.anyadir_comentario_mensaje(texto, id, id_usuario)
    return resultado

