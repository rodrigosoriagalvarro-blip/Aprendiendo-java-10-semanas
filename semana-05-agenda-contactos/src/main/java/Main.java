import modelo.Contacto;
import servicio.AgendaContactos;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        
        System.out.println("Inicio del programa");
        System.out.println("Agenda cargada con " + agenda.total() + " contactos.");
        
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (!op.equals("7")) {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Editar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            
            op = sc.nextLine();

            try {
                switch (op) {
                    case "1" -> {
                        System.out.print("Nombre: "); String n = sc.nextLine();
                        System.out.print("Tel: "); String t = sc.nextLine();
                        System.out.print("Email: "); String e = sc.nextLine();
                        System.out.print("Direccion: "); String d = sc.nextLine();
                        String nuevoId = agenda.proxId();
                        agenda.agregar(new Contacto(nuevoId, n, t, e, d));
                        System.out.println("\nContacto agregado con ID: " + nuevoId);
                        System.out.println("Datos guardados en contactos.json");
                    }
                    case "2" -> {
                        System.out.println("\n=== TODOS LOS CONTACTOS (" + agenda.total() + ") ===");
                        System.out.println("ID    | Nombre               | Telefono   | Email");
                        System.out.println("----------------------------------------------------------");
                        agenda.listarTodos().forEach(System.out::println);
                    }
                    case "3" -> {
                        System.out.println("Buscar por: (1) ID exacto  (2) Nombre parcial");
                        System.out.print("Opcion: ");
                        String subOp = sc.nextLine();
                        if (subOp.equals("1")) {
                            System.out.print("ID: ");
                            System.out.println(agenda.buscarPorId(sc.nextLine()));
                        } else {
                            System.out.print("Fragmento de nombre: ");
                            agenda.buscarPorNombre(sc.nextLine()).forEach(System.out::println);
                        }
                    }
                    case "4" -> {
                        System.out.print("ID del contacto a editar: ");
                        String idEdit = sc.nextLine();
                        System.out.print("Nuevo Telefono: ");
                        String nTel = sc.nextLine();
                        System.out.print("Nuevo Email: ");
                        String nEmail = sc.nextLine();
                        agenda.editar(idEdit, nTel, nEmail);
                        System.out.println("Contacto actualizado con exito.");
                    }
                    case "5" -> {
                        System.out.print("ID del contacto a eliminar: ");
                        String idEli = sc.nextLine();
                        System.out.print("¿Esta seguro? (S/N): ");
                        if (sc.nextLine().equalsIgnoreCase("S")) {
                            agenda.eliminar(idEli);
                            System.out.println("Contacto eliminado.");
                        }
                    }
                    case "6" -> {
                        System.out.println("\n=== ESTADISTICAS ===");
                        System.out.println("Total de contactos : " + agenda.total());
                        System.out.println("Con email registrado: " + agenda.totalConEmail());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}