import datetime
import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
from app.schemas.usuario import Usu_pk
from app.schemas.departamento import Departamento
from app.schemas.incidencia import Incidencia_API
from app.schemas.incidencia import Incidencia_BBDD

from app.schemas.prioridad import Prioridad
from app.schemas.tipo_incidencia import Tipo_incidencia
from app.schemas.estado import Estado

class AccesoBBDD():
    def __init__(self):
        self.__db__ = firestore.client()


#
# Listado de caracteristicas
#
    def obtener_usuarios(self,id: int):
        docs = self.__db__.collection(u'usuarios')
        doc_usuario = docs.where(u'fk_departamento',u'==',id)
        docs = doc_usuario.stream()
        resultado = list()
        for doc in docs:
            est = Estado(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado

    def obtener_departamentos(self):
        docs = self.__db__.collection(u'departamentos').stream()
        resultado = list()
        for doc in docs:
            est = Departamento(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado
    
    def obtener_estados(self):
        docs = self.__db__.collection(u'estados').stream()
        resultado = list()
        for doc in docs:
            est = Estado(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado

    def obtener_tipo_incidencias(self):
        docs = self.__db__.collection(u'tipos_incidencias').stream()
        resultado = list()
        for doc in docs:
            est = Tipo_incidencia(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado
    
    def obtener_prioridades(self):
        docs = self.__db__.collection(u'prioridades').stream()
        resultado = list()
        for doc in docs:
            est = Prioridad(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado
    
    def obtener_personas(self):
        docs = self.__db__.collection(u'usuarios').stream()
        resultado = list()
        for doc in docs:
            est = Usu_pk(pk=doc.id, nombre=doc.get('nombre'))
            resultado.append(est)
        return resultado
    
    #
    # Operaciones de usuarios
    #
    def login_nombre (self,usuario:str, contrasenya:str):
        resultado = False
        docs = self.__db__.collection(u'usuarios')
        doc_usuario = docs.where(u'nombre',u'==',usuario)
        docs = doc_usuario.stream()
        for doc in docs:
            print(f'{doc.id} => {doc.to_dict()}')
            print(doc.get('nombre'))
            if doc.get('nombre') == usuario:
                if doc.get('password') == contrasenya:
                    resultado = True
        return resultado
    
    def login_email(self,email:str, contrasenya:str):
        resultado = False
        print(email)
        docs = self.__db__.collection(u'usuarios')
        doc_usuario = docs.where(u'email',u'==',email)
        docs = doc_usuario.stream()
        for doc in docs:
            print(f'{doc.id} => {doc.to_dict()}')
            print(doc.get('nombre'))
            if doc.get('email') == email:
                if doc.get('password') == contrasenya:
                    resultado = True
        return resultado

    
    #
    # De momento estás ds funciones no son necesarias.
    #
    def solicitar_alta(self,usu_alta):
        resultado = False
        return resultado
    
    def aceptar_alta(self,nombre):
        resultado = False
        return resultado

    #
    # operaciones de incidencias
    #

    def listar_incidencias(self, id: int,tipo_usuario: str = None):
        resultado = list()
        departamentos = self.obtener_departamentos()
        estados = self.obtener_estados()
        prioridades = self.obtener_prioridades()
        tipos = self.obtener_tipo_incidencias()
        personas = self.obtener_personas()
            
        docs = self.__db__.collection(u'incidencias')
        if tipo_usuario == "creador":
            doc_usuario = docs.where(u"fk_persona_origen",u'==',id)
        elif tipo_usuario == "solucionador":
            doc_usuario = docs.where(u"fk_persona_destino",u'==',id)
        else:
            return resultado
        docs = doc_usuario.stream()
        resultado = list()
        for doc in docs:
            for ele in departamentos:
                if int(ele.pk) == int(doc.get('fk_departamento_destino')):
                    departamento = ele.nombre
            for ele in estados:
                if int(ele.pk) == int(doc.get('fk_estado')):
                    estado = ele.nombre
            for ele in prioridades:
                if int(ele.pk) == int(doc.get('fk_prioridad')):
                    prioridad = ele.nombre
            for ele in tipos:
                if int(ele.pk) == int(doc.get('fk_tipo_incidencia')):
                    tipo = ele.nombre
            for ele in personas:
                if int(ele.pk) == int(doc.get('fk_persona_destino')):
                    persona_origen = ele.nombre
                if int(ele.pk) == int(doc.get('fk_persona_origen')):
                    persona_destino = ele.nombre
            incidencia_api = Incidencia_API(
                pk=doc.id, 
                nombre=doc.get('nombre'),
                descripcion=doc.get('descripcion'),
                tiempo_resolucion=doc.get('tiempo_resolucion'),
                fecha_creacion=doc.get('fecha_creacion'),
                fecha_finalizacion=doc.get('fecha_finalizacion'),
                departamento_destino=departamento,
                estado=estado,
                persona_origen=persona_origen,
                persona_destino=persona_destino,
                tipo_incidencia=tipo,
                prioridad=prioridad
                )
            resultado.append(incidencia_api)
            print(incidencia_api)
        return resultado
        

    def crear_incidencia(self,incidencia: Incidencia_API):
        docs = self.__db__.collection(u'incidencias')
        departamentos = self.obtener_departamentos()
        for departamento in departamentos:
            if departamento.nombre == incidencia.departamento_destino:
                fk_departamento_destino = departamento.pk
        estados = self.obtener_estados()
        for estado in estados:
            print(estado.nombre,incidencia.estado)
            if estado.nombre == incidencia.estado:
                fk_estado = estado.pk
        print(estados)
        prioridades = self.obtener_prioridades()
        print(prioridades)
        for prioridad in prioridades:
            print(prioridad.nombre,incidencia.prioridad)
            if prioridad.nombre == incidencia.prioridad:
                fk_prioridad = prioridad.pk
        print(fk_prioridad)
        tipos = self.obtener_tipo_incidencias()
        for tipo in tipos:
            if tipo.nombre == incidencia.tipo_incidencia:
                fk_tipo_incidencia = tipo.pk
        
        personas = self.__db__.collection(u'usuarios').stream()
        resultado = list()
        for persona in personas:
            if persona.get('nombre') == incidencia.persona_destino:
                fk_persona_destino = persona.id
            if persona.get('nombre') == incidencia.persona_origen:
                fk_persona_origen = persona.id

        datos = {
            "descripcion": incidencia.descripcion,
            "fecha_creacion": datetime.datetime.now(),
            "fecha_finalizacion": datetime.datetime.now(),
            "nombre": incidencia.nombre,
            "fk_prioridad": fk_prioridad,
            "fk_estado": fk_estado,
            "fk_departamento_destino": fk_departamento_destino,
            "tiempo_resolucion": 0,
            "fk_persona_destino": fk_persona_destino,
            "fk_persona_origen": fk_persona_origen,
            "fk_tipo_incidencia": fk_tipo_incidencia
        }
        print(datos)
        id = self.indice_maximo("incidencias") + 1

        self.__db__.collection("incidencias").document(str(id)).set(datos)
        return True

    def cerrar_incidencia(self,id: int):
        print(str(id))
        doc = self.__db__.collection(u'incidencias').document(str(id))
        doc.update({u'fk_estado': 2})
        return True

    def rechazar_incidencia(self, id: int):
        print(str(id))
        doc = self.__db__.collection(u'incidencias').document(str(id))
        doc.update({u'fk_estado': 3})
        return True

    def anyadir_mensaje(self, texto: str, id: int = None, id_usuario: int = None):
        datos = {
            u'fecha_creacion': firestore.SERVER_TIMESTAMP,
            u'fk_incidencia': id,
            u'fk_usuario': id_usuario,
            u'texto': texto
        }
        id = self.indice_maximo("mensajes") + 1
        doc = self.__db__.collection(u'mensajes').document(str(id))
        doc.set(datos)
        return True

    def eliminar_mensaje(self, id: int):
        doc = self.__db__.collection(u'mensajes').document(str(id)).delete()
        return True

    def anyadir_comentario_incidencia(self, texto: str, id: int = None, id_usuario: int = None):
        datos = {
            u'fecha_creacion': firestore.SERVER_TIMESTAMP,
            u'fk_incidencia': id,
            u'fk_usuario': id_usuario,
            u'texto': texto
        }
        id = self.indice_maximo("mensajes") + 1
        doc = self.__db__.collection(u'comentarios').document(str(id))
        doc.set(datos)
        return True

    def eliminar_comentario(self, id: int):
        doc = self.__db__.collection(u'comentarios').document(str(id)).delete()
        return True

    def anyadir_comentario_mensaje(self, texto: str, id: int, id_usuario: int = None):
        datos = {
            u'fecha_creacion': firestore.SERVER_TIMESTAMP,
            u'fk_mensaje': id,
            u'fk_usuario': id_usuario,
            u'texto': texto
        }
        id = self.indice_maximo("mensajes") + 1
        doc = self.__db__.collection(u'comentarios').document(str(id))
        doc.set(datos)
        return True


    def indice_maximo(self,coleccion: str):
        id = 0
        docs = self.__db__.collection(coleccion).stream()
        for doc in docs:
            if int(doc.id) > id:
                id = int(doc.id)
        return id
