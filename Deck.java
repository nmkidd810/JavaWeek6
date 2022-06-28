package WarHomeWork;

import java.util.ArrayList;

public class Deck {
  

  //instance variables
    private ArrayList <Card> normalDeck = new ArrayList <Card>(52);
    private ArrayList <Card> shuffledDeck = new ArrayList <Card>(52);
 
    //constructor
  public Deck(){
    
  
      //makes 52 cards, fills normalDeck ArrayList
      String suit = "";
      String rank = "";
      
      for(int i=0; i<4; i++){
          if(i == 0)
              suit = "Clubs";
          else if(i == 1)
              suit = "Hearts";
          else if(i == 2)
              suit = "Spades";
          else if(i == 3)
              suit = "Diamonds";
          
          for(int j=1; j<=13; j++){
              if(j == 1)
                  rank = "Ace";
              else if(j>1 && j<11)
                  rank = "" + j;
              else if(j==11)
                  rank = "Jack";
              else if(j==12)
                  rank = "Queen";
              else if(j==13)
                  rank = "King";
              Card c1 = new Card(suit, rank);
              normalDeck.add(c1);
          }
      }
  }
  public void shuffle(){
    //This makes an ArrayList of the order in which the shuffledDeck will contain Card objects
    //from the normal deck
    ArrayList<Integer> numsUsed = new ArrayList<Integer>(52);
    //For loop ensures that numsUsed contains 52 random numbers that do not repeat
    for(int i=0; i<52; i++){
        int cardNum = (int)(Math.random() * 51.0);
        while(numsUsed.indexOf(cardNum) != -1)
            cardNum =(int)(Math.random() * 52.0);
        numsUsed.add(i, cardNum);
        //at position i, it adds the card from normalDeck at the index of cardNum.
        shuffledDeck.add(i, normalDeck.get(cardNum));
    }
}
public Card getCardSD(int i){//returns card at index i of shuffledDeck
    return shuffledDeck.get(i);
}

}
    

