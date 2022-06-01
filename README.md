# mendel-challenge

- Para poder ejecutar el proyecto Dockerizado, una vez Clonado el Repo, deben ejecutar los siguientes comandos
- mvn clean package                        --> con este comando creamos el .jar
- docker build -t mendel/myapp .           --> con este comando creamos la imagen
- docker run -p 8080:8080 mendel/myapp     --> con este comando podemos ejecutar el proyecto desde Docker

- El proyecto esta Documentado con Swagger y luego de que hayan ejecutado el Docker Run puede acceder desde:

 http://localhost:8080/swagger-ui.html#/



