from fastapi import APIRouter
from pydantic import BaseModel
from app.schemas.usuario import Usu, Usu_alta, Usu_email

from app.bbdd.acceso import AccesoBBDD



router = APIRouter()

# realizar un login utilizando el nombre del usuario y su contraseña
@router.post("/login/nombre")
async def login_nombre(usu: Usu):
    acceso = AccesoBBDD()
    resultado = acceso.login_nombre(usu.nombre,usu.contrasenya)
    return resultado

# realizar un login utilizando el email del usuario y su contraseña
@router.post("/login/email")
async def login_email(usu: Usu_email):
    acceso = AccesoBBDD()
    print(usu.email,"--",usu.contrasenya)
    resultado = acceso.login_email(usu.email,usu.contrasenya)
    print(resultado)
    return resultado


# solicitar el alta de un usuario en la BBDD
@router.put("/alta/solicitar")
async def solicitar_alta(usu_alta: Usu):
    acceso = AccesoBBDD()
    resultado = acceso.solicitar_alta(usu_alta)
    return resultado


# realizar el alta de un usuario en la BBDD
@router.put("/alta/aceptar/{nombre}")
async def aceptar_alta(nombre: str):
    acceso = AccesoBBDD()
    resultado = acceso.aceptar_alta(nombre)
    return resultado



