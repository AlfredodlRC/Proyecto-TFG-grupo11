@echo off
echo Iniciando.
title Iniciando en local.
docker-compose up --build -d
echo.
echo.
echo.
docker ps -a
echo.
echo.
echo.
echo                      Presiona una tecla para salir. 
echo.
echo                      Se abrira Chrome con la pagina de Swagger.
echo.
echo.
echo.
pause > nul
start Chrome  http://localhost:9123/docs