package com.epam.rd.autocode.assessment.appliances.model;

public class Appliance {

    private long id;
    private String name;
    private Category category;
    private String model;
    private Manufacturer manufacturer;
    private PowerType powerType;
    private String characteristic;
    private String description;
    private int power;

    public Appliance() {
    }

    public Appliance(long id,
                     String name,
                     Category category,
                     String model,
                     Manufacturer manufacturer,
                     PowerType powerType,
                     String characteristic,
                     String description,
                     int power) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerType = powerType;
        this.characteristic = characteristic;
        this.description = description;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public String getDescription() {
        return description;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
