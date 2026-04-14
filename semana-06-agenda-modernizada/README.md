## Descripción del Proyecto
Esta aplicación es un sistema de gestión de contactos desarrollado en Java 17 utilizando Maven. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre una lista de contactos, persistiendo los datos en formato JSON mediante la librería Gson.

## Métodos Refactorizados con Streams
A continuación, se detallan los métodos que fueron migrados de bucles tradicionales a la API de Streams:
buscarPorNombre:
Antes: Usaba un bucle for con un if y retornaba null si no encontraba nada.
Después: Utiliza .filter().findFirst() para devolver un Optional <contacto>.
listarContactos:
Antes: Bucle for-each para imprimir.
Después: Uso de .forEach(System.out::println).
[Añade aquí otro método si refactorizaste más, como eliminar o filtrar]

## Resultado de mvn test
Plaintext
[INFO] Tests run: [Pon aquí el número], Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
## Cómo compilar y ejecutar
Para poner en marcha el proyecto desde la terminal, sigue estos comandos:
Compilación:
DOS
mvn clean package
Ejecución:
DOS
mvn exec:java -Dexec.mainClass="Main"
## Decisiones Tomadas: Uso de Optional
Se decidió que el método buscarPorNombre devuelva un Optional<Contacto> en lugar de null para evitar errores de tipo NullPointerException. El uso de Optional obliga al programador que consume el método a manejar explícitamente el caso en el que el contacto no existe, haciendo el código más robusto y legible según las prácticas de Java Moderno.