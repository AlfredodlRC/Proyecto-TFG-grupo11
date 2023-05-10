from pydantic import BaseModel

class Estado(BaseModel):
    pk: str
    nombre: str | None = None