package org.example.model.check.factory;

import org.example.model.cards.Card;
import org.example.model.products.Product;

import java.util.List;

import static org.example.model.cards.Card.getCard;

abstract public class Receipt {

    public List<Product> productList;
    public static int cardNumber;
    static Card card;
    public double total;

    public Receipt(List<Product> productList, int card) {
        this.productList = productList;
        cardNumber = card;
        getCard(cardNumber);
        total = getTotalPrice(productList,cardNumber);
    }

    /**
     * Печатает в чек строку с размером скидки по карте или информацию о том, что такой карты нет
     */
    public static String printStringWithNumberCardForCheck(int cardNumber) {
        if (cardNumber == 0) {
            return "Discount card not presented";
        } else {
            if (card != null) {
                return "Discount card №" + card.getId() + " " + card.getPromotional() + "% discount";
            } else {
                return "Card number " + cardNumber + " not found";
            }
        }
    }

    /**
     * Получаем суммарную стоимость всех продуктов с учетом скидки
     */
    public static double getTotalPrice(List<Product> productList, int cardNumber) {
        double dbl = 0D;
        for (Product product : productList) {
            if (product.getQuantity() > 4) {
                dbl += product.getTotalWithPromotional();
            } else {
                dbl += product.getTotalWithoutPromotional();
            }
        }
        if (card != null) {
            return dbl - (dbl * card.getPromotional() / 100);
        } else {
            return dbl;
        }
    }

    abstract public void printCheck();
}
