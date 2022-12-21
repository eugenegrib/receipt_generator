package org.example.model.check;

import org.example.model.check.factory.Receipt;
import org.example.model.products.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileReceipt extends Receipt  {

    public FileReceipt(List<Product> productList, int card) {
        super(productList, card);
        this.productList = productList;
        this.cardNumber = card;
    }

    /**
     * Выводит чек в файл
     */
    @Override
    public void printCheck() {
        try (FileWriter fileWriter = new FileWriter("src/main/java/org/example/Check" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(" dd.MM.yyyy hh-mm-ss")) + ".txt")) {
            fileWriter.write("\n");
            fileWriter.write(" -----------------------------------------------------");
            fileWriter.write("\n");
            fileWriter.write(String.format("%7s %18s %13s %13s", "QTY", "DESCRIPTION", "PRICE", "TOTAL"));
            fileWriter.write("\n");
            fileWriter.write(" -----------------------------------------------------");
            fileWriter.write("\n");
            for (Product product : productList) {
                if ((int) product.getQuantity() > 4 && product.getPromotional()) {
                    fileWriter.write(String.format("%7s %18s %13s %13s", (int) product.getQuantity(), product.getDescription(), product.getPrice(), String.format("%.2f", product.getTotalWithoutPromotional())));
                    fileWriter.write("\n");
                    fileWriter.write(String.format("%54s", "(SALE -10%) " + String.format("%.2f", product.getTotalWithPromotional())));
                    fileWriter.write("\n");
                } else {
                    fileWriter.write(String.format("%7s %18s %13s %13s", (int) product.getQuantity(), product.getDescription(), product.getPrice(), String.format("%.2f", product.getTotalWithoutPromotional())));
                    fileWriter.write("\n");
                }
            }
            fileWriter.write(" -----------------------------------------------------");
            fileWriter.write("\n");
            fileWriter.write("  "+ printStringWithNumberCardForCheck(cardNumber));
            fileWriter.write("\n");
            fileWriter.write(String.format("%7s %46s", "TOTAL", String.format("%.2f", total)));
            fileWriter.write("\n");
            fileWriter.write("\n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
