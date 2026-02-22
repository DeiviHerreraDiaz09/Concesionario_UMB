package main;

import model.Concesionario;
import model.Vehicle;
import model.VehicleType;
import service.ConcesionarioService;
import service.MainService;
import service.SaleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // proyecto para un concesionario de vehículos, con las siguientes
        // características:
        // 1. Los vehículos se clasifican en: autos, camionetas y motocicletas.
        // 2. Todos los vehículos tienen un código, una marca, tipo (auto, camioneta,
        // etc.), un modelo (año) y un kilometraje.
        // 3. Además, el concesionario necesita llevar un registro de las ventas
        // realizadas, cada registro consiste de la siguiente información:
        // a) monto de la venta
        // b) vehículo vendido (código),
        // c) apellido,
        // d) nombre
        // e) documento del comprador.

        // Creación del concesionario

        Concesionario Chevrolet = new Concesionario(1, "Chevrolet", "CL 170 # 69 - 80 BOGOTA", "555-1234");

        // Generación de vehiculos

        Vehicle v1 = new Vehicle(1, "A001", Chevrolet.getName(), "Onix", 15000f, VehicleType.AUTO);
        Vehicle v2 = new Vehicle(2, "C001", Chevrolet.getName(), "S10", 30000f, VehicleType.CAMIONETA);
        Vehicle v3 = new Vehicle(3, "M001", Chevrolet.getName(), "Cruze", 20000f, VehicleType.MOTOCICLETA);
        Vehicle v4 = new Vehicle(4, "A002", Chevrolet.getName(), "Spark", 10000f, VehicleType.AUTO);
        Vehicle v5 = new Vehicle(5, "C002", Chevrolet.getName(), "Trailblazer", 40000f, VehicleType.MOTOCICLETA);

        // Registro de vehículos en el concesionario

        ConcesionarioService service = new ConcesionarioService(Chevrolet);
        service.registrarVehiculo(v1);
        service.registrarVehiculo(v2);
        service.registrarVehiculo(v3);
        service.registrarVehiculo(v4);
        service.registrarVehiculo(v5);

        // Registro de ventas
        service.registrarVenta(new model.Sale(1, 2500000f, v1.getCode(), "Perez", "Juan", "12345678"));
        service.registrarVenta(new model.Sale(2, 3000000f, v2.getCode(), "Garcia", "Maria", "87654321"));
        service.registrarVenta(new model.Sale(3, 2000000f, v3.getCode(), "Lopez", "Carlos", "11223344"));
        service.registrarVenta(new model.Sale(4, 4000000f, v5.getCode(), "Rodriguez", "Pedro", "99887766"));

        // Imprimir información referente a Concesionario y sus vehículos registrados

        MainService mainService = new MainService();
        mainService.viewInformation(Chevrolet);
        mainService.viewMenu();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        // Imprimir información referente a las ventas realizadas por tipo de vehículo

        SaleService saleService = new SaleService(Chevrolet);
        saleService.getSaleDetails(option);
        scanner.close();

    }
}