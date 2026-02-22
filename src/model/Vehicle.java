package model;

public class Vehicle {
    
    private int id;
    private String code;
    private String brand;
    private String model;
    private Float km;
    private VehicleType type;
    
    public Vehicle(){}

    public Vehicle(int id, String code, String brand, String model, Float km, VehicleType type) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.km = km;
        this.type = type;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getKm() {
        return km;
    }

    public void setKm(Float km) {
        this.km = km;
    }

    public VehicleType getType() {
        return type;
    }   

    public void setType(VehicleType type) {
        this.type = type;
    }

}
