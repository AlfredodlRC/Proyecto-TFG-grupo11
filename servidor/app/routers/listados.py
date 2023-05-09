from fastapi import APIRouter

from bbdd.acceso import AccesoBBDD


router = APIRouter()

@router.get("/departamentos/")
async def leer_estados():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_departamentos()
    return resultado

@router.get("/estados/")
async def leer_estados():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_estados()
    return resultado

@router.get("/prioridades/")
async def leer_prioridades():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_tipo_incidencias()
    return resultado

@router.get("/tipo_incidenias/")
async def leer_tipo_incidencias():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_prioridades()
    return resultado

@router.get("/usuarios/departamento/{id}")
async def leer_prioridades(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.obtener_usuarios(id)
    return resultado

