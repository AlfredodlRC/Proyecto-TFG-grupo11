import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
from schemas_API.incidencia import Incidencia

from schemas_bbdd.prioridad import Prioridad
from schemas_bbdd.tipo_incidencia import Tipo_incidencia
from schemas_bbdd.estado import Estado

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
    
    #
    # Operaciones de usuarios
    #
    def login(self,usuario:str, contrasenya:str):
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

    def listar_incidencia(self,nombre: str, id: int,tipo_usuario: str = None):
        pass

    def crear_incidencia(self,incidencia: Incidencia):
        pass

    def cerrar_incidencia(self,nombre: str, id: int):
        pass

    def rechazar_incidencia(self,nombre: str, id: int):
        pass

    def anyadir_mensaje(self, texto: str, nombre: str = None, id: int = None, id_usuario: int = None):
        pass

    def eliminar_mensaje(self, id: int):
        pass

    def anyadir_comentario_incidencia(self, texto: str, id: int = None, id_usuario: int = None):
        pass

    def eliminar_comentario_incidencia(self, id: int):
        pass

    def anyadir_comentario_mensaje(self, texto: str, id: int, id_usuario: int = None):
        pass

    def eliminar_comentario_mensaje(self, id: int):
        pass
