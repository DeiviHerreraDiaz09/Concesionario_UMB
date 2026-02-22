package service;

import model.Concesionario;
import model.Sale;
import model.Vehicle;

public class ConcesionarioService {

    private final Concesionario concesionario;

    public ConcesionarioService(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void registrarVehiculo(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo.");
        }

        if (buscarVehiculoPorCodigo(vehicle.getCode()) != null) {
            throw new IllegalArgumentException("Ya existe un vehículo con código " + vehicle.getCode());
        }

        concesionario.addVehicle(vehicle);
    }

    public Vehicle buscarVehiculoPorCodigo(String code) {
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

    public void registrarVenta(Sale sale) {
        if (sale == null) {
            throw new IllegalArgumentException("La venta no puede ser nula.");
        }

        Vehicle vehicle = buscarVehiculoPorCodigo(sale.getVehicleCode());
        if (vehicle == null) {
            throw new IllegalArgumentException("No existe el vehículo con código " + sale.getVehicleCode());
        }

        concesionario.addSale(sale);
    }
}
