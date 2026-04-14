import modelo.Contacto;
import servicio.AgendaContactos;
import java.util.Scanner;
import java.util.Optional;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (!op.equals("7")) {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Listar todos");
            System.out.println("4. Listar ordenados");
            System.out.println("5. Filtrar por categoria");
            System.out.println("6. Ver nombres");
            System.out.println("7. Guardar y salir");
            System.out.print("Opcion: ");
            
            op = sc.nextLine();

            try {
                switch (op) {
                    case "1" -> {
                        System.out.print("Nombre: "); String n = sc.nextLine();
                        System.out.print("Tel: "); String t = sc.nextLine();
                        System.out.print("Email: "); String e = sc.nextLine();
                        System.out.print("Categoria: "); String d = sc.nextLine();
                        agenda.agregar(new Contacto(agenda.proxId(), n, t, e, d));
                        System.out.println("Contacto agregado con exito.");
                    }
                    case "2" -> {
                        System.out.print("Nombre a buscar: ");
                        String nom = sc.nextLine();
                        agenda.buscarPorNombre(nom).ifPresentOrElse(
                            c -> System.out.println("Contacto encontrado: " + c.getNombre() + " - " + c.getTelefono() + " (" + c.getDireccion() + ")"),
                            () -> System.out.println("No se encontro ningun contacto con ese nombre.")
                        );
                    }
                    case "3" -> {
                        System.out.println("\n=== LISTA DE CONTACTOS ===");
                        agenda.listarTodos().forEach(System.out::println);
                    }
                    case "4" -> {
                        System.out.println("\n=== LISTA ORDENADA POR NOMBRE ===");
                        agenda.listarOrdenados().forEach(System.out::println);
                    }
                    case "5" -> {
                        System.out.print("Categoria: ");
                        String cat = sc.nextLine();
                        List<Contacto> filtrados = agenda.filtrarPorCategoria(cat);
                        if (filtrados.isEmpty()) {
                            System.out.println("No hay contactos en esa categoria.");
                        } else {
                            System.out.println("Contactos en " + cat + " (" + filtrados.size() + "):");
                            filtrados.forEach(c -> System.out.println("   " + c.getNombre() + " - " + c.getTelefono()));
                        }
                    }
                    case "6" -> {
                        System.out.println("\nNombres en la agenda:");
                        agenda.obtenerNombres().forEach(nombre -> System.out.println("- " + nombre));
                    }
                    case "7" -> System.out.println("Guardando y saliendo...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}