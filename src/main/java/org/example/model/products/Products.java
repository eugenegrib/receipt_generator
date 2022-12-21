package org.example.model.products;

import java.util.ArrayList;
import java.util.List;

public class Products {
     public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Tomato Juice", 65.7, true));
        products.add(new Product(2, "Bagel", 4.56,false));
        products.add(new Product(3, "Bread", 7.5,false));
        products.add(new Product(4, "Butter", 34.8,true));
        products.add(new Product(5, "Lemonade", 24.7,true));
        products.add(new Product(6, "Soda", 56.8,false));
        products.add(new Product(7, "Beer", 4.8,false));
        products.add(new Product(8, "Ice Cream", 2.8,true));
        products.add(new Product(9, "Pop Corn", 5.78,false));
        products.add(new Product(10, "Cheese", 6.6,false));
        products.add(new Product(11, "Milk", 1.8,true));
        products.add(new Product(12, "Meat", 13.8,true));
        products.add(new Product(13, "Jam", 7.9,false));
        products.add(new Product(14, "Cucumber", 7.4,false));
        products.add(new Product(15, "Pumpkin", 8.0,false));
        products.add(new Product(16, "Coffee", 7.3,false));
        products.add(new Product(17, "Tea", 3.8,false));
        products.add(new Product(18, "Fish", 7.8,false));
        products.add(new Product(19, "Pineapple", 5.8,true));
        products.add(new Product(20, "Apple", 5.8,false));

        return products;
    }
}
