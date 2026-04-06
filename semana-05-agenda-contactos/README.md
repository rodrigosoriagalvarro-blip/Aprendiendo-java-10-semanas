# Descripción del sistema
Agenda de contactos desarrollada en Java 17 con Maven y GSON. Permite gestionar datos con persistencia automática en archivos JSON y un sistema de seguridad mediante copias de seguridad ( backup).
Estructura del proyecto
modelo/: Clase Contactocon validaciones de datos.
servicio/: Clase AgendaContactoscon lógica de negocio.
util/: ManejadorJSONpara lectura y escritura de archivos.
exception/: Paquete con excepciones personalizadas.
Main.java: Interfaz de usuario por consola.
# Formato JSON utilizado
Los datos se almacenan en data/contactos.jsoncon la siguiente estructura:
JSON
{
  "id": "C001",
  "nombre": "Juan Perez",
  "telefono": "72345678",
  "email": "juan@gmail.com",
  "direccion": "Av. 6 de Agosto"
}
# Tabla de excepciones personalizadas
|--------Excepción------------|----Tipo----|------------------Cuando se lanza-------------------|
|----DatoInvalidoException----|Desenfrenado|Formato de teléfono o correo electrónico incorrecto.|
|contactoNoEncontradoException|-Comprobado-|--"Buscar, editar o eliminar un ID inexistente."----|
|--ContactoExistenteException-|-Comprobado-|------Intente registrar un nombre ya existente.-----|

# Cómo se instala y ejecuta con Maven
Compilador :mvn clean compile
Ejecutar :mvn exec:java -Dexec.mainClass="Main" -q