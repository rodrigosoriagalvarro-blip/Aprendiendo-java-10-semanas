# semana 3: gestor de vehiculos POO

## Descripción del sistema
Este programa es un sistema de gestión de flota desarrollado en Java que permite registrar y administrar diferentes tipos de vehículos, incluyendo modelos de combustión y eléctricos. Utiliza los pilares de la Programación Orientada a Objetos para organizar la flota en una consola interactiva, permitiendo filtrar unidades, gestionar niveles de carga de batería y demostrar comportamientos polimórficos.

## Diagrama de clases
_______________________________________________________________________________
|                                <<Interface>>                                |
|                                  Electrico                                  |
|_____________________________________________________________________________|
| + cargarBateria(): void                                                     |
| + getNivelBateria(): int                                                    |
| + necesitaCarga(): boolean                                                  |
|_____________________________________________________________________________|
             ^                                ^
             :                                :
             :................................:
             :                                :
 ____________:___________          ___________:___________
|     AutoElectrico      |        |     MotoElectrica     |
|________________________|        |_______________________|
| - bateria: int         |        | - bateria: int        |
|________________________|        |_______________________|
| + acelerar(): void     |        | + acelerar(): void    |
|________________________|        |_______________________|
             |                                |
             | (extiende)                     | (extiende)
      _______v_______                  _______v_______           _____________
     |     Auto      |                |     Moto      |         |   Camion    |
     |_______________|                |_______________|         |_____________|
     | - puertas: int|                | - tieneSidecar|         | - carga: double|
     |_______________|                |_______________|         |_____________|
     | + acelerar()  |                | + acelerar()  |         | + acelerar()|
     |_______________|                |_______________|         |_____________|
             |                        |                         |
             +-----------+------------+------------+------------+
                         |
                 ________v_________________________________
                |           Vehiculo (Abstract)            |
                |__________________________________________|
                | # marca: String                          |
                | # modelo: String                         |
                | # anio: int                              |
                |__________________________________________|
                | + abstract acelerar(): void              |
                | + toString(): String                     |
                |__________________________________________|
                             ^
                             | (usa ArrayList<Vehiculo>)
                _____________|_____________
               |      GestorVehiculos      |
               |___________________________|
               | - flota: ArrayList        |
               |___________________________|
               | + agregarVehiculo()       |
               | + listarTodos()           |
               | + filtrarPorTipo()        |
               | + mostrarEstadisticas()   |
               |___________________________|
## Decisión de diseño
Por qué Vehiculo es abstracta: Se definió así porque no tiene sentido instanciar un "Vehículo" genérico; cada vehículo en el mundo real debe ser un tipo específico (Auto, Moto, etc.). Al ser abstracta, nos permite definir el método acelerar() sin implementarlo, obligando a las clases hijas a definir su propio comportamiento.

Por qué Electrico es interfaz: Se eligió una interfaz porque la capacidad de ser "eléctrico" es un comportamiento o característica adicional que no todos los vehículos comparten. Java no permite la herencia múltiple, por lo que una interfaz es la solución ideal para que tanto AutoElectrico como MotoElectrica compartan métodos de carga sin dejar de pertenecer a sus respectivas familias de vehículos.

## Cómo compilar y ejecutar el proyecto
Para ejecutar este proyecto en Visual Studio Code o terminal:

Compilación: Desde la raíz de la carpeta, compila todos los paquetes:

Ejecución: Ejecuta la clase principal: Ejecutador.java

## Ejemplo de salida del programa
=== GESTION DE VEHICULOS ===
1. Agregar vehiculo
2. Listar todos
3. Filtrar por tipo
4. Ver electricos y baterias
5. Cargar baterias bajas
6. Demostrar polimorfismo
7. Estadisticas
8. Salir
Opcion :
