public class Main {
    public static void main(String[] args) {
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

        System.out.println("A termékek összege: " + PriceCalculator.getPriceOfList(args));
    }
}
