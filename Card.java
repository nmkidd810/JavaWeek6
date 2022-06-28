package WarHomeWork;

public class Card {
  
  //instance variables
    private String suit;
    private String rank;
    private int value;
    
  //constructor
    public Card(String s, String r){
      //constructor takes in two strings, which set the suit and rank. The value of the card will
      //then be set depending on the rank of the card
      suit = s;
      rank = r;
      if(rank.equals("2"))
          value = 2;
      else if(rank.equals("3"))
          value = 3;
      else if(rank.equals("4"))
          value = 4;
      else if(rank.equals("5"))
          value = 5;
      else if(rank.equals("6"))
          value = 6;
      else if(rank.equals("7"))
          value = 7;
      else if(rank.equals("8"))
          value = 8;
      else if(rank.equals("9"))
          value = 9;
      else if(rank.equals("10"))
          value = 10;
      else if(rank.equals("Jack"))
          value = 11;
      else if(rank.equals("Queen"))
          value = 12;
      else if(rank.equals("King"))
          value = 13;
      else if(rank.equals("Ace"))
          value = 14;
  }
    
  //Accessor  methods
    
  public String getSuit(){//returns suit
      return suit;
  }
  
  public String getRank(){//returns rank
      return rank;
  }
  
  public int getValue(){//returns value
      return value;
  }
  
  //mutator methods
  public void setSuit(String s){//sets suit
      suit = s;
  }
  
  public void setRank(String r){//sets rank
      rank = r;
  }
  public void setValue(int v){//sets value
      value =v;
  }
  //other methods
  public int isGreater(Card c){
    /*method takes in another Card object. If the value of 'this' card is greater than c's value
    it will return 1. If c's value is greater, it will return 2, otherwise (meaning they are the
    same), it will return 3 */
      if(value>c.getValue())
          return 1;
      else if(value<c.getValue())
          return 2;
      else
          return 3;
  }
  
  public String toString(){//returns rank and suit of card
      return rank + " " + suit;
  }
  
  public Card copy(Card c){//copys card
      Card dup = new Card(c.getSuit(), c.getRank());
      return dup;
  }

}

