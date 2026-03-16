import java.util.Scanner;
import servicio.GestorTareas;

public class EJECUTADOR {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea\n2. Listar todas\n3. Listar pendientes\n4. Listar completadas");
            System.out.println("5. Completar tarea\n6. Eliminar tarea\n7. Estadísticas\n8. Salir");
            System.out.print("Opcion: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Titulo: "); String tit = sc.nextLine();
                        System.out.print("Descripcion: "); String des = sc.nextLine();
                        gestor.agregar(tit, des);
                        break;
                    case 2: gestor.listar(); break;
                    case 3: gestor.listarPendientes(); break;
                    case 4: gestor.listarCompletadas(); break;
                    case 5:
                        System.out.print("ID a completar: ");
                        gestor.completar(Integer.parseInt(sc.nextLine()));
                        break;
                    case 6:
                        System.out.print("ID a eliminar: ");
                        gestor.eliminar(Integer.parseInt(sc.nextLine()));
                        break;
                    case 7:
                        System.out.println("--- ESTADISTICAS ---");
                        System.out.println("Total: " + gestor.totalTareas());
                        System.out.println("Pendientes: " + gestor.totalPendientes());
                        System.out.println("Completadas: " + gestor.totalCompletadas());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 8);
    }
}