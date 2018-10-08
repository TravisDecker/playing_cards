package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BlackJackDealer {

  private List<Card> shoe;


  public BlackJackDealer(int numDecks, Random rng) {
    shoe = new ArrayList<>();
    for (int i = 0; i < numDecks; i++) {
      for (Suit suit : Suit.values()) {
        for (Rank rank : Rank.values()) {
          shoe.add(new Card(rank, suit));
        }
      }
    }
    Collections.shuffle(shoe, rng);
    //TODO Place re-shuffle indicator card
  }

  public Card deal() {
    return shoe.remove(0);
  }
}
