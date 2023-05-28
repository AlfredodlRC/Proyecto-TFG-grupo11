from datetime import datetime
from pydantic import BaseModel

class Incidencia_API(BaseModel):
    pk: int
    descripcion: str
    fecha_creacion: str
    fecha_finalizacion: srt
    departamento_destino: str
    estado: str
    persona_destino: str
    persona_origen: str
    prioridad: str
    tipo_incidencia: str
    nombre: str
    tiempo_resolucion: int

class Incidencia_BBDD(BaseModel):
    descripcion: str
    fecha_creacion: datetime
    fecha_finalizacion: datetime | None = None
    fk_departamento_destino: int
    fk_estado: int
    fk_persona_destino: int
    fk_persona_origen: int
    fk_prioridad: int
    fk_tipo_incidencia: int
    nombre: str
    tiempo_resolucion: int

class Comentario_API(BaseModel):
    fecha_creacion: datetime
    usuario: int
    texto: str
    
class Mensaje_API(BaseModel):
    fecha_creacion: datetime
    usuario: int
    texto: str
    comentarios: list[Comentario_API]

class Incidencia_completa(BaseModel):
    pk: int
    descripcion: str
    fecha_creacion: datetime
    fecha_finalizacion: datetime
    departamento_destino: str
    estado: str
    persona_destino: str
    persona_origen: str
    prioridad: str
    tipo_incidencia: str
    nombre: str
    tiempo_resolucion: int
    comentarios: list[Comentario_API]
    mensajes: list[Mensaje_API]

class Mensaje(BaseModel):
    fecha_creacion: datetime
    fk_incidencia: int
    fk_usuario: int
    texto:str

class Comentario(BaseModel):
    fecha_creacion: datetime
    fk_incidencia: int
    fk_mensaje: int
    fk_usuario: int
    texto:str
