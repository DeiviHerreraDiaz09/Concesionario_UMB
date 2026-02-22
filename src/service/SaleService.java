package service;

import model.Concesionario;
import model.Sale;
import model.Vehicle;
import model.VehicleType;

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

        System.out.println("Ventas de " + selectedType.name() + ":");

        for (Sale sale : sales) {
            System.out.println("  - Monto: $" + sale.getAmount()
                    + " | Comprador: " + sale.getName()
                    + " " + sale.getSurname()
                    + " (Doc: " + sale.getDni() + ")");
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
