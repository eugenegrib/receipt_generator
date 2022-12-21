package org.example.model.check.factory;

import org.example.model.check.ConsoleReceipt;
import org.example.model.check.FileReceipt;
import org.example.model.products.Product;

import java.util.List;

public class ReceiptFactory {

    public ReceiptInterface getCheck(ReceiptType type, List<Product> productList, int cardNUmber) {
        ReceiptInterface toReturn = null;
        switch (type) {
            case CONSOLE:
                toReturn = new ConsoleReceipt(productList,cardNUmber);
                break;
            case FILE:
                toReturn = new FileReceipt(productList,cardNUmber);
                break;
            default:
                throw new IllegalArgumentException("Wrong check type:" + type);
        }
        return toReturn;
    }
}