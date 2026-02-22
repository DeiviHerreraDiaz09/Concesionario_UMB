package main;

import model.Concesionario;
import model.Sale;
import model.Vehicle;
import model.VehicleType;
import service.ConcesionarioService;
import service.MainService;
import service.SaleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Concesionario concesionario = new Concesionario(1, "Chevrolet", "CL 170 # 69 - 80 BOGOTA", "555-1234");

        System.out.println("==========================================");
        System.out.println("BIENVENIDO AL SISTEMA DEL CONCESIONARIO " + concesionario.getName());
        System.out.println("==========================================\n");
        
        ConcesionarioService concesionarioService = new ConcesionarioService(concesionario);
        
        int vehicleId = 1;
        boolean registrarMasVehiculos = true;

        // Registro de vehículos
        System.out.println("\n========== REGISTRO DE VEHÍCULOS ==========");
        
        while (registrarMasVehiculos) {
            System.out.print("\nIngrese código del vehículo (ej: A001): ");
            String code = scanner.nextLine();
            
            System.out.print("Ingrese modelo/año: ");
            String model = scanner.nextLine();
            
            System.out.print("Ingrese kilometraje: ");
            Float km = scanner.nextFloat();
            scanner.nextLine(); 
            
            System.out.println("Seleccione tipo de vehículo:");
            System.out.println("1 - AUTO");
            System.out.println("2 - CAMIONETA");
            System.out.println("3 - MOTOCICLETA");
            System.out.print("Opción: ");
            int tipoOpcion = scanner.nextInt();
            scanner.nextLine(); 
            
            VehicleType tipo;
            switch (tipoOpcion) {
                case 1:
                    tipo = VehicleType.AUTO;
                    break;
                case 2:
                    tipo = VehicleType.CAMIONETA;
                    break;
                case 3:
                    tipo = VehicleType.MOTOCICLETA;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }
            
            Vehicle vehicle = new Vehicle(vehicleId++, code, concesionario.getName(), model, km, tipo);
            
            try {
                concesionarioService.registrarVehiculo(vehicle);
                System.out.println("Vehiculo registrado exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.print("Desea registrar otro vehiculo? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            registrarMasVehiculos = respuesta.equals("S");
        }

        // Visualiazr vehiculos registrados
        MainService mainService = new MainService();
        mainService.viewInformation(concesionario);

        // Menu para registrar ventas
        System.out.print("\nDesea registrar ventas? (S/N): ");
        String desea_vender = scanner.nextLine().trim().toUpperCase();
        
        int saleId = 1;
        
        if (desea_vender.equals("S")) {
            boolean registrarMasVentas = true;
            
            while (registrarMasVentas) {
                System.out.print("Ingrese codigo del vehiculo a vender: ");
                String codigoVehiculo = scanner.nextLine();
                
                Vehicle vehiculoAVender = concesionarioService.buscarVehiculoPorCodigo(codigoVehiculo);
                
                if (vehiculoAVender == null) {
                    System.out.println("No existe vehiculo con codigo: " + codigoVehiculo + ". Reintente.");
                } else {
                    System.out.println("Vehiculo encontrado: " + vehiculoAVender.getBrand() + " " + vehiculoAVender.getModel());
                    
                    System.out.print("Ingrese monto de la venta: ");
                    float monto = scanner.nextFloat();
                    scanner.nextLine(); 
                    
                    System.out.print("Ingrese nombre del comprador: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese apellido del comprador: ");
                    String apellido = scanner.nextLine();
                    
                    System.out.print("Ingrese documento (DNI) del comprador: ");
                    String dni = scanner.nextLine();
                    
                    Sale venta = new Sale(saleId++, monto, codigoVehiculo, nombre, apellido, dni);
                    
                    try {
                        concesionarioService.registrarVenta(venta);
                        System.out.println("Venta registrada exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                
                System.out.print("Desea registrar otra venta? (S/N): ");
                String respuesta = scanner.nextLine().trim().toUpperCase();
                registrarMasVentas = respuesta.equals("S");
            }
        }

        // Consultar ventas realizadas
        System.out.print("\nDesea consultar las ventas realizadas? (S/N): ");
        String desea_consultar = scanner.nextLine().trim().toUpperCase();
        
        boolean consultarMasVentas = true;
        
        if (desea_consultar.equals("S")) {
            while (consultarMasVentas) {
            mainService.viewMenu();
            
            System.out.print("Seleccione una opción: ");
            int opcionVentas = scanner.nextInt();
            scanner.nextLine();
            
            SaleService saleService = new SaleService(concesionario);
            saleService.getSaleDetails(opcionVentas);
            
            System.out.print("\nDesea consultar nuevamente las ventas? (S/N): ");
            String respuestaConsulta = scanner.nextLine().trim().toUpperCase();
            consultarMasVentas = respuestaConsulta.equals("S");
            }
        }
        scanner.close();

    }
}