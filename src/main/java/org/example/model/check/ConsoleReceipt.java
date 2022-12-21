package org.example.model.check;

import org.example.model.check.factory.ReceiptInterface;
import org.example.model.products.Product;

import java.util.List;

public class ConsoleReceipt extends Receipt implements ReceiptInterface {
    private List<Product> productList;
    private int cardNumber;

    public ConsoleReceipt(List<Product> productList, int card) {
        this.productList = productList;
        this.cardNumber = card;
    }

    /**
     * Выводит чек в консоль
     */
    @Override
    public void printCheck() {
        System.out.println();
        System.out.println(" -----------------------------------------------------");
        System.out.printf("%7s %18s %13s %13s", "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        System.out.println();
        System.out.println(" -----------------------------------------------------");

        for (Product product : productList) {
            if ((int) product.getQuantity() > 4 && product.getPromotional()) {
                System.out.format("%7s %18s %13s %13s", (int) product.getQuantity(), product.getDescription(), product.getPrice(), String.format("%.2f", product.getTotalWithoutPromotional()));
                System.out.println();
                System.out.format("%54s", "(SALE -10%) " + String.format("%.2f", product.getTotalWithPromotional()));
            } else {
                System.out.format("%7s %18s %13s %13s", (int) product.getQuantity(), product.getDescription(), product.getPrice(), String.format("%.2f", product.getTotalWithoutPromotional()));
            }
            System.out.println();
        }

        System.out.println(" -----------------------------------------------------");
        System.out.println("  "+printStringWithNumberCardForCheck(cardNumber));
        System.out.printf("%7s %46s", "TOTAL", String.format("%.2f", getTotalPrice(productList, cardNumber)));
        System.out.println();
        System.out.println();
    }
}


