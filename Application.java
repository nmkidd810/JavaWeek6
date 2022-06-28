package WarHomeWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
 
    boolean playAgainOption = true;
    String gameWinner = "";
      while(playAgainOption){       
        boolean winner = false;
        
  //*creates a deck object and shuffles it    
     
        Deck d1 = new Deck();
        d1.shuffle();
        
  //creates three Array Lists
        ArrayList <Card> P1Deck = new ArrayList <Card>(56);
        ArrayList <Card> P2Deck = new ArrayList <Card>(56);
        ArrayList <Card> warDeck = new ArrayList <Card>(9);
        
 //for loop adds 26 cards to P1Deck and P2Deck
        for(int i=0; i<26; i++){
            P1Deck.add(d1.getCardSD(i));
            P2Deck.add(d1.getCardSD(i+26));
        }
        String player1;
        String player2;
        Scanner input = new Scanner(System.in);
        //Welcomes users, prompts for names
        System.out.println("Welcome to WAR! Let's Play!\n");
        System.out.print("Enter the first player's name: ");
        player1 = input.nextLine().toUpperCase();
        System.out.print("Enter the second player's name: ");
        player2 = input.nextLine().toUpperCase();
        //displays header
        System.out.println(player1 + "\t\t\t#Cards\t\t" + player2 + "\t\t\t#Cards\t\tWinner");
        while(!winner){
            //displays first card of P1Deck and P2Deck, and how many cards are left in each
            System.out.print(P1Deck.get(0)+"         \t"+P1Deck.size()+"\t\t"+P2Deck.get(0)+"         \t"+P2Deck.size() + "\t\t");
            String roundWinner = "";
            int x = P1Deck.get(0).isGreater(P2Deck.get(0));
            
/*If one of the cards has a greater value than the other, program will add the first card 
 * of BOTH decks to the end, and then remove the first card of BOTH decks 
 * */
            
    if(x==1){//P1Deck first card is greater than P2Deck first card
         P1Deck.add(P2Deck.get(0));//
         P1Deck.add(P1Deck.get(0));
         P1Deck.remove(0);
         P2Deck.remove(0);
         roundWinner = player1;
    }
    
    if(x == 2){//P2Deck first card is greater than P1Deck first card
        P2Deck.add(P1Deck.get(0));
        P2Deck.add(P2Deck.get(0));
        P2Deck.remove(P2Deck.get(0));
        P1Deck.remove(0);
        roundWinner = player2;
    }
    if(x == 3)//alerts users that there is no winner this round, just a war
        roundWinner = "WAR!";
        System.out.println(roundWinner);
        if(x==3){//WAR!
             int v=0;
             System.out.println("*****************************************WAR******************************************");
             System.out.print(P1Deck.get(0)+"         \t"+P1Deck.size()+"\t\t"+P2Deck.get(0)+"         \t"+P2Deck.size() + "\t\t");
 
 /*If either player has 4 cards or less, then they do not have enough cards to go to war, and 
  * the winner will automatically be the other person. This is tested until line 89 
 */
               
    if(P1Deck.size()<=4){
         roundWinner = player2;
         System.out.println(roundWinner);
         System.out.println("\t\t\t" + player1 + " does not have enough cards to go to war.");
         System.out.println("***************************************END WAR****************************************");
         gameWinner = player2;
         break;
    }
                
      else if(P2Deck.size()<=4){
           roundWinner = player1;
           System.out.println(roundWinner);
           System.out.println("\t\t\t" + player2 + " does not have enough cards to go to war.");
           System.out.println("***************************************END WAR****************************************");
           gameWinner = player1;
           break;
      }
    
 //Adds 4 cards to the warDeck from each player until line 98
    
        for(int i = 0; i<4 && P1Deck.size()<48; i++){
        warDeck.add(P1Deck.get(0));
        P1Deck.remove(0);
        }
            for(int i = 0; i<4 && P2Deck.size()<48; i++){
            warDeck.add(P2Deck.get(0));
            P2Deck.remove(0);
            }
            
//evalutes to see who the war winner is, whoever wins will gain all cards from
//war deck
    v = warDeck.get(3).isGreater(warDeck.get(7));
      if(v==1){
          while(warDeck.size() != 0){
              P1Deck.add(warDeck.get(0));
              warDeck.remove(0);
              roundWinner = player1;
          }
      }
          else if(v==2){
              while(warDeck.size() != 0){
                  P2Deck.add(warDeck.get(0));
                  warDeck.remove(0);
                  roundWinner = player2;
               }
          }
          else{//if there is another war, then program will then test to see if there
               //is a winner by shifting all of the cards to the right
                  warDeck.add(warDeck.get(3));
                  warDeck.remove(3);
                  warDeck.add(2, warDeck.get(7));
                  warDeck.remove(7);
                  v = warDeck.get(3).isGreater(warDeck.get(7));
                  if(v==1){//if player 1 wins, then all cards from warDeck are added to P1Deck
                     while(warDeck.size() != 0){
                        P1Deck.add(warDeck.get(0));
                        warDeck.remove(0);
                        roundWinner = player1;
                     }
                  }
                     else if(v==2){//if player 2 wins, then all cards from warDeck are added to P2Deck
                         while(warDeck.size() != 0){
                            P2Deck.add(warDeck.get(0));
                            warDeck.remove(0);
                            roundWinner = player2;
                        }
                    }
                }
                System.out.println(roundWinner); //prints winner of war
                System.out.println("***************************************END WAR****************************************");

            }
//if at any time one of the players has 52 cards, there will be a winner and
//inner loop will stop
      if(P1Deck.size() == 52){
        gameWinner = player1;
        winner = true;
      }
      
      if(P2Deck.size() == 52){
        gameWinner = player2;
        winner = true;
      }
 }//end of inner loop
        
        
        //congratulates winner, asks if they want to play again
        System.out.println(gameWinner + " WINS! Congratulations!");
        System.out.print("Play Again (Y/N): ");
        String option;
        option = input.nextLine().toUpperCase();
        option = "" + option.charAt(0);
        //while loop exists to error check
        while(!(option.equals("Y") || option.equals("N"))){
            System.out.print("Invalid option. Please enter Y or N: ");
            option = input.nextLine().toUpperCase();
            option = "" + option.charAt(0);
        }
        if(option.equals("Y"))
            playAgainOption = true;
        else
            playAgainOption = false;
    }//end of outer loop
    System.out.print("Thank you for playing!");
}//end main method
  
}//end class