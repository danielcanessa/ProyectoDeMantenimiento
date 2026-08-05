package com.cenfotec.minicrud;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo ni estar vacío.");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0 || Double.isInfinite(price) || Double.isNaN(price)) {
            throw new IllegalArgumentException("El precio no puede ser negativo ni un valor no finito.");
        }
        this.price = price;
    }
}
