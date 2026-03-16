package servicio;

import modelo.Tarea;
import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;
    private int proximoId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.proximoId = 1;
    }

    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId++, titulo, descripcion);
        tareas.add(nueva);
        System.out.println("Tarea agregada con ID: " + nueva.getId());
    }

    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        System.out.println("=== TODAS LAS TAREAS ===");
        for (Tarea t : tareas) t.mostrarInfo();
    }

    public void listarPendientes() {
        for (Tarea t : tareas) {
            if (!t.estaCompletada()) t.mostrarInfo();
        }
    }

    public void listarCompletadas() {
        for (Tarea t : tareas) {
            if (t.estaCompletada()) t.mostrarInfo();
        }
    }

    public void completar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            if (t.estaCompletada()) {
                System.out.println("Error: La tarea ya está completada.");
            } else {
                t.completar();
                System.out.println("Tarea marcada como completada.");
            }
        } else {
            System.out.println("Error: No existe tarea con ID " + id);
        }
    }

    public void eliminar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            tareas.remove(t);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Error: ID no encontrado.");
        }
    }

    public Tarea buscar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public int totalTareas() { return tareas.size(); }
    
    public int totalPendientes() {
        int cont = 0;
        for (Tarea t : tareas) if (!t.estaCompletada()) cont++;
        return cont;
    }

    public int totalCompletadas() {
        return totalTareas() - totalPendientes();
    }
}