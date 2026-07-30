
import java.util.*;

public class ProductRepository {
    private Map<Integer, Product> db = new HashMap<>();

    public void save(Product p) {
        db.put(p.getId(), p);
    }

    public Product findById(int id) {
        return db.get(id);
    }

    public void deleteById(int id) {
        db.remove(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(db.values());
    }
}
