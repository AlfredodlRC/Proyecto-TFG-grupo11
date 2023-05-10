from pydantic import BaseModel

class Tipo_incidencia(BaseModel):
    pk: str
    nombre: str | None = None