package org.example.model.check.factory;

import org.example.model.check.ConsoleReceipt;
import org.example.model.check.FileReceipt;
import org.example.model.products.Product;

import java.util.List;

public class ReceiptFactory {

    public Receipt getCheck(ReceiptType type, List<Product> productList, int cardNUmber) {
        Receipt toReturn = switch (type) {
            case CONSOLE -> new ConsoleReceipt(productList, cardNUmber);
            case FILE -> new FileReceipt(productList, cardNUmber);
        };
        return toReturn;
    }
}