from fastapi import APIRouter
from pydantic import BaseModel
from schemas.usuario import Usu_email
from schemas.usuario import Usu, Usu_alta

from bbdd.acceso import AccesoBBDD



router = APIRouter()

@router.post("/login/nombre")
async def login_nombre(usu: Usu):
    acceso = AccesoBBDD()
    resultado = acceso.login_nombre(usu.nombre,usu.contrasenya)
    return resultado

@router.post("/login/email")
async def login_nombre(usu: Usu_email):
    acceso = AccesoBBDD()
    resultado = acceso.login_email(usu.email,usu.contrasenya)
    return resultado


@router.put("/alta/solicitar")
async def solicitar_alta(usu_alta: Usu):
    acceso = AccesoBBDD()
    resultado = acceso.solicitar_alta(usu_alta)
    return resultado


@router.put("/alta/aceptar/{nombre}")
async def aceptar_alta(nombre: str):
    acceso = AccesoBBDD()
    resultado = acceso.aceptar_alta(nombre)
    return resultado



