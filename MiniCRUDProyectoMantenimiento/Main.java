
public class Main {
    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 1000.0);
        ProductRepository repo = new ProductRepository();
        repo.save(p);
        System.out.println("Product saved: " + repo.findById(1).getName());
    }
}
