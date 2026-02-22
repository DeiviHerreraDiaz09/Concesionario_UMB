package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concesionario {

    private int id;
    private String name;
    private String address;
    private String phone;
    private final List<Vehicle> vehicles;
    private final List<Sale> sales;
    
    public Concesionario(){
        this.vehicles = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    public Concesionario(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }

    public List<Sale> getSales() {
        return Collections.unmodifiableList(sales);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicles.add(vehicle);
        }
    }

    public void addSale(Sale sale) {
        if (sale != null) {
            sales.add(sale);
        }
    }

}