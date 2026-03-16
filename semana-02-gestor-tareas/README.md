# semana 2: gestor de tareas POO

programa que gestiona notas de 5 estudiantes.

## funcionalidades

- Crea tareas con ID automático, título, descripción y estado 
- Agrega una tarea nueva y listar todas las tareas
- Filtra por estado: pendientes, completadas o todas
- Muestra estadísticas: total, pendientes, completadas
- Muestra Menú interactivo que se repita hasta que el usuario salga

## como ejecutar 

1. Entrar a la carpeta:'cd semana-02-gestor-tareas'
2. compilar:'javac ejecutador .java'
3. ejecutar:'javac ejecutador'

## diagrama simple de clases 
[ ejecutador ]
   │
   │ (Usa el servicio)
   ▼
[ GestorTareas ] ◄────────┐
   • ArrayList Tarea      │
   • Métodos:             │ (Maneja la lista)
     - agregar()          │
     - listar()           │
     - eliminar()         │
   │                      │
   │ (Contiene muchas)    │
   ▼                      │
[ Tarea ] ────────────────┘
   • id, titulo, estado
   • Métodos:
     - completar()
     - mostrarInfo()