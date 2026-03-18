# Sistema de Gestión de Estudiantes 

## 1. Descripción del sistema
Este programa es una herramienta de consola diseñada para administrar registros académicos de estudiantes de forma eficiente. Utiliza diferentes estructuras del Java Collections Framework para automatizar el ranking por promedios, permitir búsquedas instantáneas por carnet y mantener un registro histórico de todas las operaciones realizadas en el sistema.

## 2. Tabla comparativa de las colecciones usadas
| Coleccion | Rol en el sistema |
Por que |
| - - - - - - - - - - - - - - - - - - - - - - - -| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -| - - - - - - - - - - - - - -| HashMap < String , Est . > | Busqueda por carnet en O (1) |
Acceso directo |
| TreeSet < Estudiante > | Ranking automatico por prom . |
Orden siempre |
| ArrayList < String > | Historial de operaciones |
Orden de llegad |



## 3. Cómo compilar y ejecutar el proyecto

compilar en cmd C:\Users\Usuario\Desktop\SIS2330lab\Aprendiendo-Java-10-Semanas\semana-04-estudiantes-collections>java Ejecutador.java 

## 4. Ejemplo de salida del programa

=== SISTEMA DE ESTUDIANTES ===
1. Agregar estudiante
...
Opcion : 5
=== Ranking de estudiantes ===
1. [2021006] Pedro Vargas Sistemas 55.0
2. [2021004] Luis Mamani Civil 61.0
3. [2021010] Diego Arce Civil 67.5
4. [2021008] Hugo Espejo Industrial 70.0
5. [2021001] Ana Torres Sistemas 75.5
6. [2021005] Rosa Flores Industrial 79.5
7. [2021007] Silvia Choque Civil 83.5
8. [2021002] Carlos Quispe Industrial 88.0
9. [2021003] Maria Condori Sistemas 92.3
10. [2021009] Patricia Lima Sistemas 95.0