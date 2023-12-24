import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class  GameFunctions{
      private Random random = new Random();
      private Cards[] playerBoardCards = new Cards[9];
      private Cards[] computerBoardCards = new Cards[9];
      private int playerTotalPlayed = 0;
      private int[] playerHandPlayed = new int[4];
      private int playerDeckPlayed = 0;
      private int computerTotalPlayed = 0;
      private int[] computerHandPlayed = new int[4]; 
      private int totalPlayed;
      private int computerTotal;
      private Cards[] shuffledCards = new Cards[40];
      private Cards[] computerHand = new Cards[4];
      private Cards[] playerHand = new Cards[4];
      private Scanner sc = new Scanner(System.in);
     private int playerTotal;

    public Cards[] getShuffledCards() {
        return shuffledCards;
    }

    public void setShuffledCards(Cards[] shuffledCards) {
        this.shuffledCards = shuffledCards;
    }

    public int[] getPlayerHandPlayed() {
        return playerHandPlayed;
    }

    public void setPlayerHandPlayed(int[] playerHandPlayed) {
        this.playerHandPlayed = playerHandPlayed;
    }

    public int[] getComputerHandPlayed() {
        return computerHandPlayed;
    }

    public void setComputerHandPlayed(int[] computerHandPlayed) {
        this.computerHandPlayed = computerHandPlayed;
    }
       boolean stand = true;
      boolean computerstand = true;
      
      public GameFunctions(int totalPlayed,int[] computerHandPlayed,int[]playerHandPlayed,Cards[] shuff,Cards[] playerHand,Cards[] computerHand) {
        this.totalPlayed = totalPlayed;
        this.computerHandPlayed = computerHandPlayed;
        this.playerHandPlayed = playerHandPlayed;
        this.shuffledCards = shuff;
        this.playerHand = playerHand;
        this.computerHand= computerHand;
    }
      public GameFunctions(int totalPlayed ) {
        this.totalPlayed = totalPlayed;
    }
      

    public Cards[] getPlayerBoardCards() {
        return playerBoardCards;
    }

    public Cards[] getComputerBoardCards() {
        return computerBoardCards;
    }

    public int getComputerTotal() {
        return computerTotal;
    }

    public int getPlayerTotalPlayed() {
        return playerTotalPlayed;
    }

    public int getComputerTotalPlayed() {
        return computerTotalPlayed;
    }

    public int getPlayerTotal() {
        return playerTotal;
    }

    public int getTotalPlayed() {
        return totalPlayed;
    }

    public void setTotalPlayed(int totalPlayed) {
        this.totalPlayed = totalPlayed;
    }

    public void setComputerstand(boolean computerstand) {
        this.computerstand = computerstand;
    }

    public boolean isComputerstand() {
        return computerstand;
    }

    public Cards[] startCreateCards()
    {
      Cards[][] gameDeck = new Cards[4][10];
      return gamedeckCreator(gameDeck);
    } 
    public void startText(){
           System.out.println("");
           System.out.println("*************************");
           System.out.println("*       BLUEJACK       *");
           System.out.println("*************************");
           System.out.println("ENTER 1 TO PLAY THE GAME");
           System.out.println("ENTER 2 TO END THIS GAME");
           System.out.println("*************************");
           System.out.print("Enter your choice: ");
    }
    public Cards[] gamedeckCreator(Cards[][] gameDeck){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <10 ; j++) {
                    if(i==0) gameDeck[i][j] = new Cards( j+1, "B");
                    if(i==1) gameDeck[i][j] = new Cards( j+1, "Y");
                    if(i==2) gameDeck[i][j] = new Cards( j+1, "R");
                    if(i==3) gameDeck[i][j] = new Cards( j+1, "G");
                }
            }
            return shuffleTheCards(gameDeck);
    }
    public Cards[] shuffleTheCards(Cards[][]gameDeck)
    {
        
         Cards[] shuffledCards = new Cards[40];
         int color = 0;
         int number = 0;
           for (int i = 0; i < 40; i++) {
            
            color = random.nextInt(4);
            number = random.nextInt(10);
              boolean toNextNumber = true;
            while (toNextNumber) {
                for (int j = 0; j < i+1; j++) {
                    if(shuffledCards[j]==gameDeck[color][number])
                    {
                         color = random.nextInt(4);
                         number = random.nextInt(10);
                         toNextNumber = true;
                     break;
                    }
                    else
                    {
                        toNextNumber = false;
                    }
                    
                }
                
            }
            
            shuffledCards[i] = gameDeck[color][number];
        }
        return shuffledCards;
    }
    public Cards[] secondStepDeckGenerator(Cards[] deck){
        for (int i = 5; i < 8; i++) {
               String color = "";
               int colorI = random.nextInt(4);//0 B 1 Y 2 R 3 G
               int numberI = random.nextInt(6)+1;
               int signI = random.nextInt(2);
            
             if(colorI ==0) color = "B";
             if(colorI ==1) color = "Y";
             if(colorI ==2) color = "R";
             if(colorI ==3) color = "G";
             if(signI==0)deck[i] = new Cards( +numberI, color);
             if(signI==1)deck[i] = new Cards( -numberI, color);
            
            
        }
        return thirdStepDeckGenerator(deck);
    }
    public Cards[] thirdStepDeckGenerator(Cards[] deck){
        boolean alreadyJokerSelected = false;
        int jokerCard = random.nextInt(2);
        for (int i = 8; i < 10; i++) {
            int chance = random.nextInt(100);
            if(chance<80){
                
            String color = "";
            int colorI = random.nextInt(4);//0 B 1 Y 2 R 3 G
            int numberI = random.nextInt(6)+1;
            int signI = random.nextInt(2);
            
            if(colorI ==0) color = "B";
            if(colorI ==1) color = "Y";
            if(colorI ==2) color = "R";
            if(colorI ==3) color = "G";
 
             if(signI==0)deck[i] = new Cards( numberI, color);
             if(signI==1)deck[i] = new Cards( -numberI, color);
    
            }else{
            
                if(alreadyJokerSelected==false)
                {
                    if(jokerCard==0) deck[i] = new Cards(false);
                    if(jokerCard==1) deck[i] = new Cards(true);
                    alreadyJokerSelected = true;
                }else
                {
                    if(jokerCard==0) deck[i] = new Cards(true);
                    if(jokerCard==1) deck[i] = new Cards(false);
                }
                
            }
            
        }
        return handDeckGenerator(deck);
    
    
    }
    public Cards[] handDeckGenerator(Cards[]Deck){
        
        Cards[] handDeck = new Cards[4];
        
        int number = 0;
        for (int i = 0; i < 4; i++) {
            
            
            number = random.nextInt(10);
            boolean toNextNumber = true;
            while (toNextNumber) {
                for (int j = 0; j < i+1; j++) {
                    if(handDeck[j]==Deck[number])
                    {
                        number = random.nextInt(10);
                         toNextNumber = true;
                          break;
                    }else
                    {
                        toNextNumber = false;
                    } 
                }
            }
            handDeck[i] = Deck[number];
            Deck[number] = null;
        }
        return handDeck;
    }
    public Cards[] firstStepDeckGenerator(Cards[]shuffledDeck,boolean playerDeck)
    {
      Cards[] deck = new Cards[10];
       if(playerDeck)
       {
           for (int i = 0; i < 5; i++) {
             deck[i] = shuffledDeck[39-i];
             shuffledDeck[39-i] = null;
        }
       }else
       {
           for (int i = 0; i < 5; i++) {
             deck[i] = shuffledDeck[i];
             shuffledDeck[i] = null;
        }
       }
       return secondStepDeckGenerator(deck);
    }
    public void playText(Cards[] shuffledCards,Cards[] playerHand,Cards[] computerHand,boolean show){
      this.shuffledCards = shuffledCards;
      this.computerHand = computerHand;
      this.playerHand = playerHand;
      playerTotal = 0;  
      computerTotal = 0;
         String[] playerHandStrings = new String[4];
         String[] computerHandStrings = new String[4];
         String[] computerBoard = new String[9];
         String[] playerBoard = new String[9];
        
        for (int i = 0; i < 4; i++) {
            if(1==playerHandPlayed[i])
            {
                 playerHandStrings[i] = "   ";
            }
            else
            {
                 playerHandStrings[i] = playerHand[i].getCard();
            }
        }
        for (int i = 0; i < 4; i++) {
            if(1==computerHandPlayed[i])
            {
                computerHandStrings[i] = "   ";
                
            }
            else
            {
                 computerHandStrings[i] = "***";
            }
        }
        for (int i = 0; i < 9; i++) {
            if(i<computerTotalPlayed)
            {
                computerBoard[i] = computerBoardCards[i].getCard();
                computerTotal += computerBoardCards[i].getCardNumber();
            }
            else
            {
                computerBoard[i] = "   ";
            }
        }
        for (int i = 0; i < 9; i++) {
            if(i<playerTotalPlayed)
            {
                playerBoard[i] = playerBoardCards[i].getCard();
                playerTotal += playerBoardCards[i].getCardNumber();
            }
            else
            {
                 playerBoard[i] = "   ";
            }
        }
            if(show)
            {
              System.out.println("");
              System.out.println("                  -------------------------------");
              System.out.println("Computer's hand-->"+"    "+computerHandStrings[0]+"    "+computerHandStrings[1]+"    "+computerHandStrings[2]+"    "+computerHandStrings[3]);
              System.out.println("                  -------------------------------");
              System.out.println("Computer's Board->"+"    "+computerBoard[0]+"    "+computerBoard[1]+"    "+computerBoard[2]+"    "+computerBoard[3]+"    "+computerBoard[4]+"    "+computerBoard[5]+"    "+computerBoard[6]+"    "+computerBoard[7]+"    "+computerBoard[8]);
              System.out.println("                  -------------------------------");
              System.out.println("Player's Board--->"+"    "+playerBoard[0]+"    "+playerBoard[1]+"    "+playerBoard[2]+"    "+playerBoard[3]+"    "+playerBoard[4]+"    "+playerBoard[5]+"    "+playerBoard[6]+"    "+playerBoard[7]+"    "+playerBoard[8]);
              System.out.println("                  -------------------------------");
              System.out.println("Player's hand---->"+"    "+playerHandStrings[0]+"    "+playerHandStrings[1]+"    "+playerHandStrings[2]+"    "+playerHandStrings[3]);
              System.out.println("                  -------------------------------");
              System.out.println("");
              System.out.println("your deck: "+playerTotal);
              System.out.println("Computer deck: "+ computerTotal);
            }
    }
    public void startTurn()
    {
         int choice;
          while (true) {
            try {
                 System.out.println("");
                 System.out.println("1) Type 1 for pick card from game deck");
                 System.out.print("Enter your choice: ");
                 choice = sc.nextInt();
                     if (choice != 1) {
                        System.out.println("You entered a value other than 1. Try again.");
                         continue; 
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("You have entered unvalid value. Please enter an integer value.");
                sc.nextLine(); 
            }
        }
          
    
    if(choice==1)
    {
         System.out.println("");
         System.out.println("You picked card from game deck");
         System.out.println("");
         playerBoardCards[playerTotalPlayed] = shuffledCards[totalPlayed];
         shuffledCards[totalPlayed] = null;
         totalPlayed++;
         playerDeckPlayed++;
         playerTotalPlayed++; 
         playText(shuffledCards, playerHand, computerHand,true);
         thirdStep();
    }
     }
    public void thirdStep()
    {
        int choice;
        while (true) {
            try {
                 System.out.println("");
                 System.out.println("1) Type 1 for end turn");
                 System.out.println("2) Type 2 for pick cards from your hand");
                 System.out.println("3) Type 3 for stand");
                 System.out.print("Enter your choice: ");
                 choice = sc.nextInt();
                 if (choice != 1 && choice != 2&&choice != 3) {
                    System.out.println("You entered a value other than 1,2 or 3. Try again.");
                    continue; 
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("You have entered unvalid value. Please enter an integer value.");
                sc.nextLine(); 
            }
        }
    if(choice==1)
    {   
       System.out.println("");
       System.out.println("You chosed to end the turn");
       System.out.println("");
       playText(shuffledCards, playerHand, computerHand,true);
    }
    if(choice==2)
    {
      pickAgain();
    }
    if(choice==3)
    {
       if(playerTotalPlayed==0)
        {
            System.out.println("");
            System.out.println("You can not stand in first turn");
            System.out.println("");
             thirdStep();
        }else
        {
            System.out.println("");
            System.out.println("You chosed to stand");
            System.out.println("");
            stand = false;
        }
    }
    }
    public void pickAgain()
    {
        int choice;
      while (true) {
            try {
                System.out.println("");
                System.out.println("1)Please enter which row of cards you would like to choose card from hand");
                System.out.println("2)press 0 to go back to previous selection menu");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                     if (choice<0||choice>4) {
                       System.out.println("You entered unvalid number or you selected card which already selected pls try again");
                       continue;
                }
                     if(choice==0)
                     {
                     thirdStep();
                     return;
                     }
                     if(playerHandPlayed[choice-1]==1)
                     {
                      System.out.println("");
                      System.out.println("You entered unvalid number or you selected card which already selected pls try again");
                      System.out.println("");
                        continue;
                     } 
                break; 
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("You have entered unvalid value. Please enter an integer value.");
                sc.nextLine(); 
            }
        }
     
      
      
     if(playerHand[choice-1].isJoker()==true)
     {
             if(playerHand[choice-1].isX2()==true)
         {
               System.out.println("");
               System.out.println("YOU USED X2");
               System.out.println("");
               playerBoardCards[playerTotalPlayed-1].setCardNumber(playerBoardCards[playerTotalPlayed-1].getCardNumber()*2);
               playerHand[choice-1]=null;
               playerHandPlayed[choice-1] = 1;
               playText(shuffledCards, playerHand, computerHand,true);
         }else
         {
              System.out.println("");
              System.out.println("YOU USED +/-");
              System.out.println("");
              playerBoardCards[playerTotalPlayed-1].setCardNumber(playerBoardCards[playerTotalPlayed-1].getCardNumber()*-1);
              playerHandPlayed[choice-1] = 1;
              playerHand[choice-1]=null;
               playText(shuffledCards, playerHand, computerHand,true); 
          }
     }
     else
     {
          System.out.println("");
          System.out.println("You picked card from your hand");
          System.out.println("");
          playerBoardCards[playerTotalPlayed] = playerHand[choice-1];
          playerHandPlayed[choice-1] = 1;
          playerDeckPlayed++;
          playerHand[choice-1]=null;
          playerTotalPlayed++;
          playText(shuffledCards, playerHand, computerHand,true);
                  
     }
        while (true) {
            try {
                 System.out.println("");
                 System.out.println("1) Type 1 for end turn");
                 System.out.println("2) Type 2 for stand");
                 System.out.print("Enter your choice: ");
                 choice = sc.nextInt();
                 if (choice != 1 && choice != 2) {
                    System.out.println("You entered a value other than 1,2  Try again.");
                    continue; 
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("You have entered unvalid value. Please enter an integer value.");
                sc.nextLine(); 
            }
        }
    if(choice==1)
    {   
       System.out.println("");
       System.out.println("You chosed to end the turn");
       System.out.println("");
       playText(shuffledCards, playerHand, computerHand,true);
    }
    if(choice==2)
    {
            System.out.println("");
            System.out.println("You chosed to stand");
            System.out.println("");
            stand = false;
    }
    }
    public void setstand(boolean stand)
    {
      this.stand = stand;
    }
    public boolean getstand()
    {
      return this.stand;
    }
    public void startToThink()
    {
       playText(shuffledCards, playerHand, computerHand,false);
       computerBoardCards[computerTotalPlayed] = shuffledCards[totalPlayed];
       shuffledCards[totalPlayed] = null;
       totalPlayed++;
       computerTotalPlayed++; 
       playText(shuffledCards, playerHand, computerHand,false);
           
            if(computerTotal<=20&&computerTotal>=17)
    {
      computerstand = false;
    }
           if(computerTotal>20)
    {
       int min= 999;
        int whichHandCard = 999;
         for (int i = 0; i < 4; i++) {
             if(computerHand[i]!=null)
             {
                 if((computerTotal+computerHand[i].getCardNumber())<=20&&computerHandPlayed[i]==0&&computerHand[i].isJoker()==false&&computerHand[i]!=null)
            {
            if(computerHand[i].getCardNumber()<min&&computerHand[i]!=null)
                min = computerHand[i].getCardNumber();
                 whichHandCard = i;
            }
             }
            
        }
        if(whichHandCard!=999&&computerHand[whichHandCard]!=null)
        {
          if(computerHand[whichHandCard]!=null)
          {
              computerBoardCards[computerTotalPlayed] = computerHand[whichHandCard];
              computerHand[whichHandCard] = null;
              computerHandPlayed[whichHandCard] = 1;
              computerTotalPlayed++;
          }
        }
        else
        {
          computerstand = false;
        }
    }else
           {
              for (int i = 0; i < 4; i++) {
            
            if(computerHand[i]!=null)
            {
                if((20-computerTotal)==computerHand[i].getCardNumber()&&computerHand[i].isJoker()==false&&computerHand[i].getCardNumber()>0&&computerHand[i]!=null)
            {
              computerBoardCards[computerTotalPlayed] = computerHand[i];
              computerHandPlayed[i] = 1;
              computerTotalPlayed++;
              computerstand = false;
              computerHand[i] = null;
               break;
            }
            }
              } 
           }
    playText(shuffledCards, playerHand, computerHand,false);
    if(computerTotal<=20&&computerTotal>=17)
    {
      computerstand = false;
    }
    
           if (computerTotal>20) {
               computerstand = false;
            
        }
            if(stand==false&&computerTotal>playerTotal) computerstand= false; 
 }
}





           
            