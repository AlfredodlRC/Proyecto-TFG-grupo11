@echo off
docker ps -a
echo.
echo.
docker-compose stop
echo.
echo.
docker ps -a
echo.
echo.
echo Presiona una tecla para salir.
pause > nul