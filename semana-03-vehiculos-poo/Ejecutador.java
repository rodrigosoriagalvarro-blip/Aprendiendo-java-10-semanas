import modelo.*;
import servicio.GestorVehiculos;
import java.util.*;

public class Ejecutador {
    public static void main(String[] args) {
        GestorVehiculos gestor = new GestorVehiculos();
        Scanner sc = new Scanner(System.in);

        gestor.agregarVehiculo(new Auto("Toyota", "Corolla", 2024));
        gestor.agregarVehiculo(new Moto("Honda", "CB500", 2023));
        gestor.agregarVehiculo(new Camion("Volvo", "FH16", 2022));
        gestor.agregarVehiculo(new AutoElectrico("Tesla", "Model 3", 2024, 15));
        gestor.agregarVehiculo(new MotoElectrica("NIU", "MQi+", 2023, 60));

        System.out.println("=== DEMOSTRACION DE POLIMORFISMO (acelerar) ===");
        for (Vehiculo v : gestor.getFlota()) {
            v.acelerar();
        }

        int opcion = 0;
        do {
            System.out.println("\n=== GESTION DE VEHICULOS ===");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Listar todos");
            System.out.println("3. Filtrar por tipo");
            System.out.println("4. Ver electricos y baterias");
            System.out.println("5. Cargar baterias bajas");
            System.out.println("6. Demostrar polimorfismo");
            System.out.println("7. Estadisticas");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                
                switch (opcion) {
                    case 1 -> agregarVehiculoMenu(gestor, sc);
                    case 2 -> gestor.listarTodos();
                    case 3 -> filtrarMenu(gestor, sc);
                    case 4 -> gestor.mostrarBaterias();
                    case 5 -> gestor.cargarBateriasBajas();
                    case 6 -> gestor.demostrarPolimorfismo();
                    case 7 -> gestor.mostrarEstadisticas();
                    case 8 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese solo números.");
            }
        } while (opcion != 8);

        sc.close(); 
    }

    private static void filtrarMenu(GestorVehiculos gestor, Scanner sc) {
        System.out.println("¿Qué tipo filtrar? (1: Auto, 2: Moto, 3: Camion, 4: Electricos)");
        try {
            int subOpc = Integer.parseInt(sc.nextLine());
            switch (subOpc) {
                case 1 -> gestor.filtrarPorTipo(Auto.class);
                case 2 -> gestor.filtrarPorTipo(Moto.class);
                case 3 -> gestor.filtrarPorTipo(Camion.class);
                case 4 -> gestor.filtrarPorTipo(Electrico.class);
                default -> System.out.println("Tipo no válido.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
        }
    }

    private static void agregarVehiculoMenu(GestorVehiculos gestor, Scanner sc) {
        System.out.println("--- Registro de Vehículo ---");
        System.out.println("1. Auto\n2. Moto\n3. Camion\n4. Auto Electrico\n5. Moto Electrica");
        System.out.print("Seleccione tipo: ");
        int tipo = Integer.parseInt(sc.nextLine());
        
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Año: ");
        int anio = Integer.parseInt(sc.nextLine());

        switch (tipo) {
            case 1 -> gestor.agregarVehiculo(new Auto(marca, modelo, anio));
            case 2 -> gestor.agregarVehiculo(new Moto(marca, modelo, anio));
            case 3 -> gestor.agregarVehiculo(new Camion(marca, modelo, anio));
            case 4 -> {
                System.out.print("Nivel de batería (0-100): ");
                int bat = Integer.parseInt(sc.nextLine());
                gestor.agregarVehiculo(new AutoElectrico(marca, modelo, anio, bat));
            }
            case 5 -> {
                System.out.print("Nivel de batería (0-100): ");
                int bat = Integer.parseInt(sc.nextLine());
                gestor.agregarVehiculo(new MotoElectrica(marca, modelo, anio, bat));
            }
        }
        System.out.println("Vehículo agregado con éxito.");
    }
}