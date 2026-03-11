import java.util.Scanner;

public class ejercicioCalificaciones{

    public static void main(String[] args) {
        final int NUM_ESTUDIANTES = 5;
        final int NUM_NOTAS = 3;
        final int NOTA_APROBACION = 51;

        String[] nombres = new String[NUM_ESTUDIANTES];
        int[][] notas = new int[NUM_ESTUDIANTES][NUM_NOTAS];
        double[] promedios = new double[NUM_ESTUDIANTES];

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SISTEMA DE CALIFICACIONES ---");

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println("\nIngrese datos del estudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            for (int j = 0; j < NUM_NOTAS; j++) {
                notas[i][j] = leerNota(scanner, "Nota " + (j + 1) + ": ");
            }
        }

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            promedios[i] = calcularPromedio(notas[i]);
        }

        double promedioGeneral = calcularPromedioGeneral(promedios);
        int notaMax = encontrarMaximo(notas);
        int notaMin = encontrarMinimo(notas);
        int aprobados = contarAprobados(promedios, NOTA_APROBACION);

        mostrarResultados(nombres, notas, promedios, NOTA_APROBACION);
        mostrarEstadisticas(promedioGeneral, notaMax, notaMin, aprobados, NUM_ESTUDIANTES);

        scanner.close();
    }

    public static double calcularPromedio(int[] notasEstudiante) {
        int suma = 0;
        for (int nota : notasEstudiante) {
            suma += nota;
        }
        return (double) suma / notasEstudiante.length;
    }

    public static String determinarEstado(double promedio, int notaMinima) {
        return (promedio >= notaMinima) ? "APROBADO" : "REPROBADO";
    }

    public static int encontrarMaximo(int[][] todasLasNotas) {
        int max = todasLasNotas[0][0];
        for (int[] fila : todasLasNotas) {
            for (int nota : fila) {
                if (nota > max) {
                    max = nota;
                }
            }
        }
        return max;
    }

    public static int encontrarMinimo(int[][] todasLasNotas) {
        int min = todasLasNotas[0][0];
        for (int[] fila : todasLasNotas) {
            for (int nota : fila) {
                if (nota < min) {
                    min = nota;
                }
            }
        }
        return min;
    }

    public static int contarAprobados(double[] promedios, int notaMinima) {
        int cuenta = 0;
        for (double p : promedios) {
            if (p >= notaMinima) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public static int leerNota(Scanner sc, String mensaje) {
        int nota = -1;
        while (true) {
            System.out.print(mensaje);
            try {
                nota = Integer.parseInt(sc.nextLine());
                if (nota >= 0 && nota <= 100) {
                    return nota;
                }
                System.out.println("Error: La nota debe estar entre 0 y 100.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    public static double calcularPromedioGeneral(double[] promedios) {
        double suma = 0;
        for (double p : promedios) {
            suma += p;
        }
        return suma / promedios.length;
    }

    public static void mostrarResultados(String[] nom, int[][] n, double[] p, int min) {
        System.out.println("\n----------- RESULTADOS -----------");
        System.out.printf("%-15s %-3s %-3s %-3s %-5s %-10s\n", "Nombre", "N1", "N2", "N3", "Prom", "Estado");
        for (int i = 0; i < nom.length; i++) {
            System.out.printf("%-15s %-3d %-3d %-3d %-5.1f %-10s\n", 
                nom[i], n[i][0], n[i][1], n[i][2], p[i], determinarEstado(p[i], min));
        }
    }

    public static void mostrarEstadisticas(double promGen, int max, int min, int apr, int total) {
        int repr = total - apr;
        System.out.println("\n----------- ESTADISTICAS -----------");
        System.out.printf("Promedio general del curso: %.2f\n", promGen);
        System.out.println("Nota mas alta: " + max);
        System.out.println("Nota mas baja: " + min);
        System.out.printf("Aprobados: %d de %d (%.1f%%)\n", apr, total, (double) apr / total * 100);
        System.out.printf("Reprobados: %d de %d (%.1f%%)\n", repr, total, (double) repr / total * 100);
    }
}