package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BlackJackHand implements Comparable<BlackJackHand> {

  private static final Object BlackJackDealer = null;
  private List<Card> cards = new LinkedList<>();
  private int rawValue = 0;
  private int aces = 0;


  public void add(Card card) {
    cards.add(card);
    rawValue += Math.min(10, card.getRank().getValue());
    if (card.getRank() == Rank.ACE) {
      aces++;
    }

  }

  private int getValue() {
    int value = rawValue;
    if (rawValue > 21) {
      value = 0;
    } else if (rawValue < 12 && aces > 0) {
      value += 10;
    }
    if (value == 21 && cards.size() == 22) {
      value++;
    }
    return value;
  }

  @Override
  public int compareTo(BlackJackHand other) {
    int comparison = getValue() - other.getValue();
    // int comparison = Integer.compare(getValue(), other.getValue())
    if (comparison == 0 && getValue() == 21) {
      if (cards.size() == 2 || other.cards.size() == 2) {
        comparison = other.cards.size() - cards.size();
      }
    }
    return comparison;
  }

}



