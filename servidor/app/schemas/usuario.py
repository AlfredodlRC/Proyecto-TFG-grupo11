from pydantic import BaseModel

class Usu(BaseModel):
    nombre: str
    contrasenya: str

class Usu_email(BaseModel):
    email: str
    contrasenya: str

class Usu_alta(BaseModel):
    nombre: str
    contrasenya: str
    departamento: str

class Usu_pk(BaseModel):
    pk: str
    nombre: str | None = None
