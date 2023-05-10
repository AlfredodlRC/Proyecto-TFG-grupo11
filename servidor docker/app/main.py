from fastapi import FastAPI
from app.routers import listados,usuarios,incidencias
import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore

app = FastAPI()

app.include_router(listados.router)
app.include_router(usuarios.router)
app.include_router(incidencias.router)

cred_obj = firebase_admin.credentials.Certificate('ticktask-e15a9-firebase-adminsdk-m025v-b967ad2a98.json')
firebase_admin.initialize_app(cred_obj)
