package org.example.model.cards;

import org.example.model.cards.exception.CardNullException;

import static org.example.model.cards.Cards.getCards;

public class Card {
    private int id;
    private int promotional;

    public int getPromotional() {
        return promotional;
    }

    public int getId() {
        return id;
    }

    public Card(int id, int promotional) {
        super();
        this.id = id;
        this.promotional = promotional;
    }

    /**
     * Находит в базе скидочную карту с таким номером, или возвращает null
     */
    public static Card getCard(Integer cardNumber) {
        Card card = null;
        try {
            for (Card card1 : getCards()) {
                if (card1.getId() == cardNumber) {
                    card = card1;
                    break;
                }
            }
            if (card != null) {
                return card;
            } else {
                throw new CardNullException();
            }
        } catch (CardNullException e) {
           // System.out.println(e.getMessage(cardNumber));
            return null;
        }
    }

}
