package org.example.model.cards;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    public static List<Card> getCards() {
        // Create an Empty List of Student, And add few objects to the List
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1111, 10));
        cards.add(new Card(1112, 15));
        cards.add(new Card(1113, 5));
        cards.add(new Card(1114, 12));
        cards.add(new Card(1115, 8));
        cards.add(new Card(1116, 11));
        cards.add(new Card(1117, 9));
        cards.add(new Card(1118, 4));
        cards.add(new Card(1119, 15));
        cards.add(new Card(1120, 10));

        return cards;
    }
}
