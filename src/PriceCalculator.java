import java.util.ArrayList;

public class PriceCalculator {
    public static double getPriceOfList(String[] args) {
        double sum = 0.0;
        double discount = 0.0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;

        ArrayList<Product> products = ProductsManager.getProducts();

        for (String arg : args) {
            for (Product product : products) {
                if (arg.equals(product.getName())) {
                    sum += product.getPrice();
                }
            }
        }

        for (String product : args) {
            switch (product) {
                case "A" -> countA += 1;
                case "B" -> countB += 1;
                case "C" -> countC += 1;
                case "D" -> countD += 1;
                default -> countE += 1;
            }
        }

        // 2db "A" termék esetén 1db "C" fél áron
        if (countA > 1 && countC != 0) {
            // Kiszámoljuk, hogy hány db "C" termék van féláron
            int numberOfCGetDiscount = countA / 2;
            // Kiszámoljuk, hogy mennyibe fog kerülni ha megkapja a leárazást 1 termék
            int priceOfDiscountedCProducts = products.get(2).getPrice() / 2;

            discount = -1 * (numberOfCGetDiscount * priceOfDiscountedCProducts);
        }
        // 2db "D" termék után jár egy grátisz "D" termék
        // azaz a "2+1 ingyen" akció alapján minden 3. termék ingyen jár
        if (countD >= 2) {
            int numberOfGratisDProduct = countD / 3;
            discount = -1 * (numberOfGratisDProduct * products.get(3).getPrice());
        }

        // "E" és "D" egy kosárba kerülése esetén a kosár össz értéke +30%-kal drágább
        if (countE != 0 && countD != 0) {
            discount = sum * 0.3;
        }

        sum += discount;

        return sum;
    }

}
