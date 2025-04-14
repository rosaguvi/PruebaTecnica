
@echo off
echo Eliminando contenedores anteriores...
docker rm -f servicio-autenticacion servicio-conversion-divisas 2>NUL

echo Construyendo servicio-autenticacion...
cd workspace\servicio-autenticacion
docker build -t servicio-autenticacion .

echo Ejecutando servicio-autenticacion...
docker run -d -p 8081:8080 --name servicio-autenticacion servicio-autenticacion

echo Construyendo servicio-conversion-divisas...
cd ..\servicio-conversion-divisas
docker build -t servicio-conversion-divisas .

echo Ejecutando servicio-conversion-divisas...
docker run -d -p 8082:8080 --name servicio-conversion-divisas servicio-conversion-divisas

cd ..\..\..
echo Servicios desplegados en:
echo - Autenticación: http://localhost:8081/swagger-ui.html
echo - Conversión Divisas: http://localhost:8082/swagger-ui.html
pause
