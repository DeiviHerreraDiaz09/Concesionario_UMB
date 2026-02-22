package service;

import model.Concesionario;
import model.Vehicle;

public class MainService {
    
    public MainService() {
    }

    public String viewInformation(Concesionario concesionario) {
        System.out.println("***********************************************");
        System.out.println("***********" + " Concesionario: " + concesionario.getName() + " **********");
        System.out.println("***********************************************");
        System.out.println("Dirección: " + concesionario.getAddress());
        System.out.println("Teléfono: " + concesionario.getPhone());
        System.out.println("Vehículos registrados:");
        System.out.println("***********************************************");
        System.out.println("* Codigo * Marca * Tipo * Modelo * Kilometraje");
        for ( Vehicle vehicle : concesionario.getVehicles()) {
            System.out.println("* " + vehicle.getCode() + " * " + vehicle.getBrand() + " * " + vehicle.getType() + " * " + vehicle.getModel() + " * " + vehicle.getKm());
        }
        System.out.println("***********************************************");
        return "";
    }

    public String viewMenu() {
        System.out.println("Digite un número para ver el registro de las ventas realizadas: \n" +
                       "1. Para autos\n" +
                       "2. Para camionetas\n" +
                       "3. Para motocicletas\n");
        return "";
    }


}
