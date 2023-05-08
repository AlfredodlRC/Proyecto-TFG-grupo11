from pydantic import BaseModel

class Usu(BaseModel):
    nombre: str
    contrasenya: str

class Usu_alta(BaseModel):
    nombre: str
    contrasenya: str
    departamento: str