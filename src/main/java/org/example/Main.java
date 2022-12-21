package org.example;

import org.example.model.check.factory.Receipt;
import org.example.model.check.factory.ReceiptFactory;
import org.example.model.check.factory.ReceiptType;
import org.example.model.products.Product;

import java.util.*;

import static org.example.model.ReadArguments.*;
import static org.example.model.products.Products.getProducts;


public class Main {
    public static void main(String[] args) {
        //получаем номер скидочной карты и оставляем только список продуктов
        String[] listWithoutNumberCard = getCardNumberFromArguments(args);

        //преобразуем аргументы в список продуктов
        List<Product> list = fromArgumentsToListProducts(listWithoutNumberCard, getProducts());

        ReceiptFactory factory = new ReceiptFactory();

        Receipt consoleCheck = factory.getCheck(ReceiptType.CONSOLE, list, cardNumber);
        consoleCheck.printCheck();

        Receipt fileCheck = factory.getCheck(ReceiptType.FILE, list, cardNumber);
        fileCheck.printCheck();
    }
}