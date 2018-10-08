package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();
    for (Suit suit :
        Suit.values()) {
      for (Rank rank :
          Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
    System.out.println(deck);
    Collections.shuffle(deck);
    System.out.println(deck);
  }

  public static List<Card> getDeck(){
    List<Card> deck = new ArrayList<>();
    for (Suit suit :
        Suit.values()) {
      for (Rank rank :
          Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
    return deck;
  }

  @Override
  public String toString() {
    return rank.getSymbol()+suit.getSymbol();
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public int compareTo(Card other) {
    int comparison = this.suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = this.rank.compareTo(other.rank);
    }
    return comparison;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return rank == card.rank &&
        suit == card.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, suit);
  }


}
