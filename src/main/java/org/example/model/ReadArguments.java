package org.example.model;

import org.example.model.products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadArguments {
    public static Integer cardNumber = 0;

    /**
     * Находит в аргументах номер скидочной карты, если есть
     **/
    public static String[] getCardNumberFromArguments(String[] args) {
        List<String> list = new ArrayList<String>();
        for (String str : args) {
            if (str.contains("card")) {
                cardNumber = Integer.parseInt(Arrays.stream(str.split("-")).filter(n -> !n.equals("card")).collect(Collectors.joining()));
            } else {
                list.add(str);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * Преобразует список аргументов в список товаров и их количество
     **/
    public static List<Product> fromArgumentsToListProducts(String[] args1, List<Product> products) {
        Map<Integer, Integer> map =
                Arrays.stream(args1)
                        .map(elem -> elem.split("-"))
                        .collect(Collectors.toMap(e -> Integer.parseInt(e[0]), e -> Integer.parseInt(e[1])));
        List<Product> newProductsList = new ArrayList<Product>();
        for (Product product : products) {
            if (map.containsKey(product.getId())) {
                int quantity = map.get(product.getId());
                int count = 0;
                for (int i = 0; i < quantity; i++) {
                    count++;
                }
                product.setQuantity(count);
                if (product.getQuantity() > 4) {
                    product.setTotalWithPromotional((product.getPrice() * count) * 0.9);
                }
                product.setTotalWithoutPromotional(product.getPrice() * count);
                newProductsList.add(product);
            }
        }
        return newProductsList;
    }
}
