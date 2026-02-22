package service;

import model.Concesionario;
import model.Sale;
import model.Vehicle;
import model.VehicleType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class SaleService {

    private final Concesionario concesionario;

    public SaleService(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public List<Sale> getSalesByType(VehicleType vehicleType) {
        List<Sale> salesByType = new ArrayList<>();

        if (vehicleType == null) {
            return salesByType;
        }

        for (Sale sale : concesionario.getSales()) {
            Vehicle vehicle = buscarVehiculoPorCodigo(sale.getVehicleCode());
            if (vehicle != null && vehicle.getType() == vehicleType) {
                salesByType.add(sale);
            }
        }

        return salesByType;
    }

    public void getSaleDetails(int option) {
        List<VehicleType> vehicleTypes = List.of(VehicleType.values());

        if (option < 1 || option > vehicleTypes.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        VehicleType selectedType = vehicleTypes.get(option - 1);
        List<Sale> sales = getSalesByType(selectedType);

        if (sales.isEmpty()) {
            System.out.println("No hay ventas de tipo " + selectedType.name());
            return;
        }

        DecimalFormat formatoMoneda = new DecimalFormat("#,###.00");
        System.out.println("Ventas de " + selectedType.name() + ":");

        for (Sale sale : sales) {
            Vehicle vehiculo = buscarVehiculoPorCodigo(sale.getVehicleCode());
            
            System.out.println("\n  ========================================");
            System.out.println("  Vehiculo Vendido:");
            System.out.println("    - Codigo: " + sale.getVehicleCode());
            if (vehiculo != null) {
                System.out.println("    - Marca: " + vehiculo.getBrand());
                System.out.println("    - Modelo: " + vehiculo.getModel());
                System.out.println("    - Tipo: " + vehiculo.getType());
            }
            System.out.println("  Informacion de Venta:");
            System.out.println("    - Monto: $" + formatoMoneda.format(sale.getAmount()));
            System.out.println("    - Comprador: " + sale.getName() + " " + sale.getSurname());
            System.out.println("    - Documento: " + sale.getDni());
            System.out.println("  ========================================");
        }

    }

    private Vehicle buscarVehiculoPorCodigo(String code) {
        if (code == null || code.isBlank()) {
            return null;
        }

        for (Vehicle vehicle : concesionario.getVehicles()) {
            if (code.equalsIgnoreCase(vehicle.getCode())) {
                return vehicle;
            }
        }

        return null;
    }
}
