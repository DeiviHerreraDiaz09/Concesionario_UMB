package model;

public class Sale {
    
    private int id;
    private float amount;
    private String vehicleCode;
    private String name;
    private String surname;
    private String dni;

    public Sale(){}

    public Sale(int id, float amount, String vehicleCode, String name, String surname, String dni) {
        this.id = id;
        this.amount = amount;
        this.vehicleCode = vehicleCode;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
