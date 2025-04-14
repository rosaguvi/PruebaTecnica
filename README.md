
# PruebasBBVA - Microservicios con Docker y Swagger

Este repositorio contiene dos microservicios Java:

- `servicio-autenticacion`
- `servicio-conversion-divisas`

Ambos han sido preparados para:

✅ Ejecutarse en contenedores Docker sin necesidad de Java instalado localmente  
✅ Incluir documentación Swagger UI disponible al iniciar  
✅ Facilitar despliegue local con scripts `.bat` (Windows) y `.sh` (Linux)

---

## 🚀 Cómo ejecutar en local (Windows)

1. Asegúrate de tener Docker Desktop instalado y en ejecución.
2. Abre una terminal (CMD o PowerShell) en la carpeta del proyecto.
3. Ejecuta:

```bat
run_all.bat
```

Esto compilará los servicios y los ejecutará en:

- Autenticación: http://localhost:8081/swagger-ui.html
- Conversión Divisas: http://localhost:8082/swagger-ui.html

---

## 🐧 Cómo ejecutar en Linux/Mac

```bash
chmod +x run_all.sh
./run_all.sh
```

---

## 🧪 Probar los servicios

Una vez desplegados, accede a las URLs de Swagger para ver y probar los endpoints disponibles.

---

## 🆙 Cómo subir a GitHub

1. Crea un nuevo repositorio en GitHub.
2. Desde la carpeta del proyecto, ejecuta:

```bash
git init
git add .
git commit -m "Versión inicial con Docker y Swagger"
git remote add origin https://github.com/TU_USUARIO/NOMBRE_REPO.git
git push -u origin master
```

---

📫 Para dudas o sugerencias, ¡bienvenido a contribuir!
