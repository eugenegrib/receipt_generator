package org.example.model.check;

import org.example.model.cards.Card;
import org.example.model.products.Product;

import java.util.List;

import static org.example.model.cards.Card.getCard;

public class Receipt {

    /**
     * Печатает в чек строку с размером скидки по карте или информацию о том, что такой карты нет
     */
    String printStringWithNumberCardForCheck(int cardNumber) {
        if (cardNumber == 0) {
            return "Discount card not presented";
        } else {
            Card card = getCard(cardNumber);
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
    public double getTotalPrice(List<Product> productList, int cardNumber) {
        double dbl = 0D;
        for (Product product : productList) {
            if (product.getQuantity() > 4) {
                dbl += product.getTotalWithPromotional();
            } else {
                dbl += product.getTotalWithoutPromotional();
            }
        }
        Card card = getCard(cardNumber);
        if (card != null) {
            return dbl-(dbl*card.getPromotional()/100);
        } else {
            return dbl;
        }
    }
}
