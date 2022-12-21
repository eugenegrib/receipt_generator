package org.example.model.cards;

import static org.example.model.cards.Cards.getCards;

public class Card {
    private int id;

    public int getPromotional() {
        return promotional;
    }

    private int promotional;

    public int getId() {
        return id;
    }

    public Card(int id,int promotional) {
        super();
        this.id = id;
        this.promotional = promotional;
    }

    /**
     * Находит в базе скидочную карту с таким номером, или возвращает null
     */
    public static Card getCard(Integer cardNumber) {
        Card card = null;
        for (Card card1 : getCards()) {
            if (card1.getId() == cardNumber) {
                card = card1;
                break;
            }
        }
        return card;
    }

}
