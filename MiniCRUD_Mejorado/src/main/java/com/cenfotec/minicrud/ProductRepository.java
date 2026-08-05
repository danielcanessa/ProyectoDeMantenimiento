package com.cenfotec.minicrud;

import java.util.*;

public class ProductRepository {
    private Map<Integer, Product> db = new HashMap<>();

    public void save(Product p) {
        db.put(p.getId(), p);
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(db.get(id));
    }

    public void deleteById(int id) {
        db.remove(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(db.values());
    }
}
