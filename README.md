# pruebaTecnica Registro Usuarios

Guia de despliegue:

- Spring boot 2.7
- IDE: intellij
- Base de datos: h2

# Paso a paso:

1. Importar proyecto al IDE.
2. Por consola maven, hacer un mvn clean e install (mvn clean install)
3. luego ejecutar app con mvn spring-boot:run
4. Una vez iniciado la app, puede acceder a su swagger desde el link de localhost (http://localhost:8080/swagger-ui/index.html#/)


Dentro de Swagger encontrara 3 metodos con sus respectivas descripciones (en ingles). Para más detalle, dentro del codigo estan los javadoc en español.

  - POST: Agregar un nuevo usuario.
  - GET: Obtener listado de usuarios (tareas vigentes).

Para agregar usuario:

  1. Abremos el metodo POST /user/add y pulsamos el boton "Try it out"
  2. Dentro del cuadro de texto o "edit value", se debe ingresar los dos o el Json (Ojo segun el documento aparece la variable "contrycode" debiese ser "countrycode")
  3. Luego se pulsa en "Execute" y esperamos la respuesta segun lo enviado.

# Base de datos

Para efectos de Base de datos, se agrega el script dentro de la carpeta resources (db_ejercicio.sql).
Al ser una bdd en H2, podemos acceder a su consola desde el siguiente link:

 - http://localhost:8080/h2-console

Modificamos los datos de url y de usuario/contraseña:

 - url = "jdbc:h2:mem:ejercicio"
 - usuario = sa
 - password = password