
public class ProductService {
    private ProductRepository repo = new ProductRepository();

    public void createProduct(int id, String name, double price) {
        Product p = new Product(id, name, price);
        repo.save(p);
    }

    public Product getProduct(int id) {
        return repo.findById(id);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public void printAll() {
        for (Product p : repo.findAll()) {
            System.out.println(p.getId() + ": " + p.getName());
        }
    }
}
