# Agenda de Contactos Web - Semana 09

Este proyecto es una aplicación web desarrollada con Java, Spring Boot y Vaadin 24 para la gestión de contactos.cite_startPermite capturar datos mediante un formulario interactivo, validarlos en tiempo real con la herramienta Binder y asegurar su persistencia en un archivo local en formato JSON.

## Diagrama de Arquitectura (Patrón Modelo-Servicio-Vista)

[cite_start]Siguiendo las especificaciones del documento guía, el sistema se organiza de la siguiente manera para separar las responsabilidades:

----text----
ContactosView
      |
      v
ContactoService <- @Service
      |
      v
ManejadorJSON   <- lee / escribe contactos.json
      |
      v
contactos.json

# Explicación de la Arquitectura
La vista (ContactosView) no tiene acceso directo al archivo contactos.json ni utiliza la clase ManejadorJSON. La comunicación se realiza exclusivamente a través de la capa de servicio (ContactoService), la cual es inyectada automáticamente por Spring Boot mediante el constructor. Esto garantiza que la interfaz de usuario solo se encargue de la visualización y captura de datos, mientras que la persistencia queda encapsulada en el servicio.

# Como ejecutar el programa 

C:\Users\Usuario\Desktop\SIS2330 lab\Aprendiendo-Java-10-Semanas\semana-09-agenda-web>mvn spring-boot:run

# Ejemplo del JSON generado después de agregar un contacto
[{"nombre":"rodrigo soria galvarro gutierrez ","email":"rodrigoultyt@gmail.com","telefono":"74109946"}]