from fastapi import APIRouter

from app.bbdd.acceso import AccesoBBDD


router = APIRouter()

# listado de los departamentos de la empresa
@router.get("/departamentos/")
async def leer_estados():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_departamentos()
    return resultado

# listado de los posibles estados de los tickets
@router.get("/estados/")
async def leer_estados():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_estados()
    return resultado

# listado de las prioridades de los tickets
@router.get("/prioridades/")
async def leer_prioridades():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_tipo_incidencias()
    return resultado

# listado de los tipo de tickets
@router.get("/tipo_incidenias/")
async def leer_tipo_incidencias():
    acceso = AccesoBBDD()
    resultado = acceso.obtener_prioridades()
    return resultado

# listados de empleados de un departamento referenciado por su id
@router.get("/usuarios/departamento/{id}")
async def leer_prioridades(id: int):
    acceso = AccesoBBDD()
    resultado = acceso.obtener_usuarios(id)
    return resultado

