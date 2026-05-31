package com.epam.rd.autocode.assessment.appliances.stream;

import com.epam.rd.autocode.assessment.appliances.model.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Shop implements Add, Find, Sort {

    public static final String CLASS_NAME = "Shop";

    private Set<Client> clients = new HashSet<>();
    private Set<Employee> employees = new HashSet<>();
    private Set<Appliance> appliances = new HashSet<>();
    private Set<Order> orders = new HashSet<>();
    private Set<Manufacturer> manufacturers = new HashSet<>();

    public Shop() {
    }

    public Set<Client> getClients() {
        return clients;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Appliance> getAppliances() {
        return appliances;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    @Override
    public Manufacturer findManufacturerById(long id) {
        return manufacturers.stream()
                .filter(m -> m != null && m.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Manufacturer with id=" + id + " was not found"));
    }

    @Override
    public Manufacturer findManufacturerByName(String name) {
        return manufacturers.stream()
                .filter(m -> m != null && Objects.equals(m.getName(), name))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Manufacturer with name=" + name + " was not found"));
    }

    @Override
    public List<Order> findOrderByEmployee(Employee employee) {
        return orders.stream()
                .filter(Objects::nonNull)
                .filter(order -> Objects.equals(order.getEmployee(), employee))
                .collect(Collectors.toList());
    }

    private BigDecimal orderAmount(Order order) {
        return order.getAppliances()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Order findCheapestOrder() {
        return orders.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(this::orderAmount))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order findMostExpensiveOrder() {
        return orders.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(this::orderAmount))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Manufacturer> sortManufacturersByName() {
        return manufacturers.stream()
                .sorted(Comparator.comparing(
                        Manufacturer::getName,
                        Comparator.nullsLast(String::compareTo)
                ))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public List<Order> sortOrderByClientId() {
        return orders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(o -> o.getClient().getId()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public List<Appliance> sortAppliancesByCategory() {
        return appliances.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Appliance::getCategory))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public List<Order> sortOrderByAmount() {
        return orders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(this::orderAmount))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
