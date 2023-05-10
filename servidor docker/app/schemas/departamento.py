from pydantic import BaseModel

class Departamento(BaseModel):
    pk: str
    nombre: str | None = None