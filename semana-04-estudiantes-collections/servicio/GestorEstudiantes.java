package servicio;

import modelo.Estudiante;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class GestorEstudiantes {

    private HashMap<String, Estudiante> porCarnet;
    private TreeSet<Estudiante> ranking;
    private ArrayList<String> historial;

    public GestorEstudiantes() {
        porCarnet = new HashMap<>();
        ranking = new TreeSet<>();
        historial = new ArrayList<>();
    }

    public void filtrarPorCarrera(String carrera) {
        System.out.println("\n=== Carrera: " + carrera + " ===");
        boolean hayAlguno = false;
        for (Estudiante e : porCarnet.values()) {
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                System.out.println(e);
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("Ninguno encontrado.");
        }
    }

    public void mostrarEstadisticas() {
        if (ranking.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        double suma = 0;
        for (Estudiante e : ranking) {
            suma += e.getPromedio();
        }
        
        System.out.println("\n=== Estadisticas ===");
        System.out.println(" Total     : " + ranking.size());
        System.out.printf(" Promedio  : %.2f\n", suma / ranking.size());
        System.out.println(" Mejor     : " + ranking.last());
        System.out.println(" Peor      : " + ranking.first());
    }

    public void mostrarHistorial() {
        System.out.println("\n=== Historial de operaciones ===");
        if (historial.isEmpty()) {
            System.out.println("Sin operaciones registradas.");
            return;
        }
        for (String entrada : historial) {
            System.out.println(" " + entrada);
        }
    }

    public int getTotalEstudiantes() {
        return porCarnet.size();
    }
}