
# Agenda de Contactos y Eventos Web - Semana 10

Aplicación web desarrollada con Java, Spring Boot y Vaadin para la gestión integral de contactos y eventos, incorporando componentes dinámicos avanzados y persistencia de datos local.

## Diagrama de paquetes

-----text
Vista (ContactosView / EventosView)
      |
      v
Servicio (ContactoService / EventoService)
      |
      v
Persistencia (ManejadorJSON) -> archivos.json


## Arquitectura del proyecto

El sistema implementa el patrón de arquitectura en capas (Modelo-Servicio-Vista). Las interfaces de usuario (ContactosView y EventosView<<) no acceden directamente a los archivos de almacenamiento para garantizar la separación de responsabilidades. Toda la comunicación y manipulación de datos se gestiona exclusivamente a través de los servicios inyectados por Spring Boot (ContactoService y EventoService), los cuales coordinan la lectura y escritura física mediante un ManejadorJSON genérico.

## Compilación y ejecución
mvn compile
mvn spring-boot:run

escribir en el buscador `http://localhost:8080`

## Ejemplo del JSON generado

contactos.json

[
  {
    "nombre": "Carlos Mamani",
    "email": "carlos@correo.com",
    "telefono": "79876543"
  }
]

eventos.json


[
  {
    "titulo": "Reunion de Proyecto",
    "fecha": "2026-05-20",
    "descripcion": "Revision final de entregables de la semana 10"
  }
]
