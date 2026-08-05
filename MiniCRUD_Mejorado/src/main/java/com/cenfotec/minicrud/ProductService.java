package com.cenfotec.minicrud;

import java.util.List;

public class ProductService {
    private ProductRepository repo = new ProductRepository();

    public void createProduct(int id, String name, double price) {
        if (repo.findById(id).isPresent()) {
            throw new DuplicateProductException("Ya existe un producto con el ID " + id);
        }
        Product p = new Product(id, name, price);
        repo.save(p);
    }
    
    public void updateProduct(int id, String name, double price) {
        Product p = repo.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con ID " + id + " para actualizar"));
        p.setName(name);
        p.setPrice(price);
        repo.save(p);
    }

    public Product getProduct(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con ID " + id));
    }

    public void deleteProduct(int id) {
        if (!repo.findById(id).isPresent()) {
            throw new ProductNotFoundException("No se encontró el producto con ID " + id + " para eliminar");
        }
        repo.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public void printAll() {
        for (Product p : repo.findAll()) {
            System.out.println(p.getId() + ": " + p.getName());
        }
    }
}
