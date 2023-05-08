from pydantic import BaseModel

class Incidencia(BaseModel):
    nombre: str

class Mensaje(BaseModel):
    texto:str

class Comentario(BaseModel):
    texto:str
