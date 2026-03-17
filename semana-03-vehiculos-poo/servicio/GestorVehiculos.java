package servicio;
import modelo.*;
import java.util.*;

public class GestorVehiculos {
    private ArrayList<Vehiculo> flota = new ArrayList<>();

    public void agregarVehiculo(Vehiculo v) { flota.add(v); }

    public void listarTodos() {
        for (Vehiculo v : flota) System.out.println(v);
    }

    public void filtrarPorTipo(Class<?> claseDestino) {
        for (Vehiculo v : flota) {
            if (claseDestino.isInstance(v)) System.out.println(v);
        }
    }

    public void mostrarBaterias() {
        for (Vehiculo v : flota) {
            if (v instanceof Electrico) {
                System.out.println(v.getClass().getSimpleName() + ": " + ((Electrico) v).getNivelBateria() + "%");
            }
        }
    }

    public void cargarBateriasBajas() {
        for (Vehiculo v : flota) {
            if (v instanceof Electrico e && e.necesitaCarga()) {
                e.cargarBateria();
                System.out.println("Cargando: " + v.getClass().getSimpleName());
            }
        }
    }

    public void demostrarPolimorfismo() {
        for (Vehiculo v : flota) v.acelerar();
    }

    public void mostrarEstadisticas() {
        int total = flota.size();
        long electricos = flota.stream().filter(v -> v instanceof Electrico).count();
        long necesitanCarga = flota.stream().filter(v -> v instanceof Electrico && ((Electrico)v).necesitaCarga()).count();
        
        System.out.println("Total: " + total + " | Eléctricos: " + electricos + " | Necesitan carga: " + necesitanCarga);
    }

    public ArrayList<Vehiculo> getFlota() { return flota; }
}