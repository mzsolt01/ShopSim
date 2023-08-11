import java.util.ArrayList;

public class ProductsManager {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
