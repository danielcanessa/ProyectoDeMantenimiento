package com.cenfotec.minicrud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService service;

    @BeforeEach
    void setUp() {
        service = new ProductService();
    }

    @Test
    void testCreateAndGetProduct_Success() {
        service.createProduct(1, "Laptop", 1000.0);
        Product p = service.getProduct(1);
        
        assertNotNull(p);
        assertEquals("Laptop", p.getName());
        assertEquals(1000.0, p.getPrice());
    }

    @Test
    void testCreateProduct_DuplicateId_ThrowsException() {
        service.createProduct(1, "Laptop", 1000.0);
        
        assertThrows(DuplicateProductException.class, () -> {
            service.createProduct(1, "Desktop", 800.0);
        });
    }

    @Test
    void testGetProduct_NonExistent_ThrowsException() {
        assertThrows(ProductNotFoundException.class, () -> {
            service.getProduct(99);
        });
    }

    @Test
    void testDeleteProduct_Success() {
        service.createProduct(1, "Laptop", 1000.0);
        service.deleteProduct(1);
        
        assertThrows(ProductNotFoundException.class, () -> {
            service.getProduct(1);
        });
    }

    @Test
    void testDeleteProduct_NonExistent_ThrowsException() {
        assertThrows(ProductNotFoundException.class, () -> {
            service.deleteProduct(99);
        });
    }
    
    @Test
    void testUpdateProduct_Success() {
        service.createProduct(1, "Laptop", 1000.0);
        service.updateProduct(1, "Gaming Laptop", 1500.0);
        
        Product p = service.getProduct(1);
        assertEquals("Gaming Laptop", p.getName());
        assertEquals(1500.0, p.getPrice());
    }

    @Test
    void testInvalidProductData_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.createProduct(-1, "Test", 100);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.createProduct(2, "", 100);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.createProduct(3, "Test", -50);
        });
    }
}
