package org.example.model.cards.exception;

public class CardNullException extends Exception {
    public String getMessage(int cardNumber) {
        return "CardNullException: Card number" + cardNumber + "not found";
    }
}
