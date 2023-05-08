from pydantic import BaseModel

class Prioridad(BaseModel):
    pk: str
    nombre: str | None = None