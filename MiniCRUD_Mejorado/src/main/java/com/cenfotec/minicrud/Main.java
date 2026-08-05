package com.cenfotec.minicrud;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        
        try {
            System.out.println("Intentando crear producto Laptop...");
            service.createProduct(1, "Laptop", 1000.0);
            System.out.println("Producto guardado exitosamente.");
            
            System.out.println("Consultando producto con ID 1: " + service.getProduct(1).getName());
            
            System.out.println("Intentando crear producto con ID duplicado...");
            service.createProduct(1, "Desktop", 800.0);
        } catch (DuplicateProductException | ProductNotFoundException | IllegalArgumentException e) {
            System.err.println("Error de dominio: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando consultar un ID inexistente...");
            service.getProduct(99);
        } catch (ProductNotFoundException e) {
            System.err.println("Error de dominio: " + e.getMessage());
        }
        
        try {
            System.out.println("Intentando crear un producto con datos inválidos...");
            service.createProduct(-1, "", -50.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        }
    }
}
