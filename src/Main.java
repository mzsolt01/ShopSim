import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int sum = 0;

        Product A = new Product("A", 55);
        Product B = new Product("B", 20);
        Product C = new Product("C", 60);
        Product D = new Product("D", 10);
        Product E = new Product("E", 45);

        ProductsManager.addProduct(A);
        ProductsManager.addProduct(B);
        ProductsManager.addProduct(C);
        ProductsManager.addProduct(D);
        ProductsManager.addProduct(E);

        ArrayList<Product> products = ProductsManager.getProducts();

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < products.size(); j++) {
                if (args[i].equals(products.get(j).getName())) {
                    sum += products.get(j).getPrice();
                }
            }
        }
        System.out.println("A termékek összege: " + sum + " Ft");
    }
}
