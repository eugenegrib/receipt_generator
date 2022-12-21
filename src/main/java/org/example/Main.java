package org.example;

import org.example.model.ReadArguments;
import org.example.model.check.ConsoleCheck;
import org.example.model.check.FileCheck;
import org.example.model.products.Product;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.model.ReadArguments.*;
import static org.example.model.products.Products.getProducts;


public class Main {
    public static void main(String[] args) {
        //получаем номер скидочной карты и оставляем только список продуктов
        String[] listWithoutNumberCard = getCardNumberFromArguments(args);

        //преобразуем аргументы в список продуктов
        List<Product> list = fromArgumentsToListProducts(listWithoutNumberCard, getProducts());

        //печатаем чек в консоль
        ConsoleCheck consoleCheck = new ConsoleCheck(list, cardNumber);
        consoleCheck.printCheck();

        //печатаем чек в файл
        FileCheck fileCheck = new FileCheck(list, cardNumber);
        fileCheck.printCheck();
    }
}