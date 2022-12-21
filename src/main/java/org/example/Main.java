package org.example;

import org.example.model.check.factory.ReceiptFactory;
import org.example.model.check.factory.ReceiptInterface;
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

        ReceiptInterface consoleCheck = factory.getCheck(ReceiptType.CONSOLE, list, cardNumber);
        consoleCheck.printCheck();

        ReceiptInterface fileCheck = factory.getCheck(ReceiptType.FILE, list, cardNumber);
        fileCheck.printCheck();

    }
}