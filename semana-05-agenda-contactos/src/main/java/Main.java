import modelo.Contacto;
import servicio.AgendaContactos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (!op.equals("7")) {
            System.out.println("\n1. Agregar 2. Listar 6. Estadisticas 7. Salir");
            System.out.print("Opcion: ");
            op = sc.nextLine();
            try {
                if (op.equals("1")) {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Tel: "); String t = sc.nextLine();
                    agenda.agregar(new Contacto(agenda.proxId(), n, t, "", ""));
                } else if (op.equals("2")) {
                    agenda.listar().forEach(System.out::println);
                } else if (op.equals("6")) {
                    System.out.println("Total: " + agenda.total());
                }
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }
}