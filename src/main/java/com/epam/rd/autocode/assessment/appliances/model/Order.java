package com.epam.rd.autocode.assessment.appliances.model;

import java.math.BigDecimal;
import java.util.Map;

public class Order {

    private long id;
    private Client client;
    private Employee employee;
    private Map<Appliance, BigDecimal> appliances;

    public Order() {
    }

    public Order(long id,
                 Client client,
                 Employee employee,
                 Map<Appliance, BigDecimal> appliances) {

        this.id = id;
        this.client = client;
        this.employee = employee;
        this.appliances = appliances;
    }

    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Map<Appliance, BigDecimal> getAppliances() {
        return appliances;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAppliances(Map<Appliance, BigDecimal> appliances) {
        this.appliances = appliances;
    }
}
