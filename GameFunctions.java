
import java.util.Random;
import java.util.Scanner;

 //int foo = Integer.parseInt(myString); to string to int
//charAt(0) to take first char at string;

public class  GameFunctions{
     Random random = new Random();
     Cards[] playerBoardCards = new Cards[9];
     Cards[] computerBoardCards = new Cards[9];
     int playerTotalPlayed = 0;
     int[] playerHandPlayed = new int[4];

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
     int playerDeckPlayed = 0;
     int computerTotalPlayed = 0;
     int[] computerHandPlayed = new int[4];
     int computerDeckPlayed = 0;
     int totalPlayed = 5;
     int computerTotal;
     Cards[] shuffledCards = new Cards[40];
     Cards[] computerHand = new Cards[4];
     Cards[] playerHand = new Cards[4];
     Scanner sc = new Scanner(System.in);
     int playerTotal;
     boolean stand = true;
     boolean computerstand = true;

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
                    }else
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
            //playerdeck
        }
       }else
       {
       for (int i = 0; i < 5; i++) {
            deck[i] = shuffledDeck[i];
            //computerdeck
        }
       }
       return secondStepDeckGenerator(deck);
    }
    public void playText(Cards[] shuffledCards,Cards[] playerHand,Cards[] computerHand){
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
            playerHandStrings[i] = "***";
            }else
            {
            playerHandStrings[i] = playerHand[i].getCard();
            }
        }
        for (int i = 0; i < 4; i++) {
            if(1==computerHandPlayed[i])
            {
            computerHandStrings[i] = computerHand[i].getCard();
            }else
            {
            computerHandStrings[i] = "***";
            }
            
        }
        for (int i = 0; i < 9; i++) {
            if(i<computerTotalPlayed)
            {
            computerBoard[i] = computerBoardCards[i].getCard();
            computerTotal += computerBoardCards[i].getCardNumber();
            }else
            {
            computerBoard[i] = "   ";
            }
            
        }
        for (int i = 0; i < 9; i++) {
            if(i<playerTotalPlayed)
            {
            playerBoard[i] = playerBoardCards[i].getCard();
            playerTotal += playerBoardCards[i].getCardNumber();
            }else
            {
            playerBoard[i] = "   ";
            }
        }
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
            System.out.println("Computer deck"+ computerTotal);
            
            
    }
    public void startTurn()
    {
    
    System.out.println("");
    System.out.println("1) Type 1 for stand");
    System.out.println("2) Type 2 for pick cards");
    System.out.print("Enter your choice: ");
    int a = sc.nextInt();
    if(a==1)
    {
    
    System.out.println("");
    System.out.println("You chosed to stand");
    System.out.println("");
    stand = false;
    }
    if(a==2)
    {
    secondStep();
    }
    
    }
    public void secondStep()
    {
    System.out.println("");
    System.out.println("1) Type 1 for pick card from game deck");
    System.out.println("2) Type 2 for pick card from your hand");
    System.out.print("Enter your choice: ");
    int a = sc.nextInt();
    if(a==1)
    {
    
    System.out.println("");
    System.out.println("You picked card from game deck");
    System.out.println("");
    playerBoardCards[playerTotalPlayed] = shuffledCards[totalPlayed];
    totalPlayed++;
    playerDeckPlayed++;
    playerTotalPlayed++; 
    playText(shuffledCards, playerHand, computerHand);
    thirdStep();
    }
    if(a==2)
    {
    int choice;
    while (true) {            
    System.out.println("");
    System.out.println("Please enter which row of cards you would like to choose");
    System.out.print("Enter your choice: ");
    choice = sc.nextInt();
    if(choice<1||4<choice||playerHandPlayed[choice-1]==1)
    {
    System.out.println("");
    System.out.println("You entered unvalid number or you selected card which already selected pls try again");
    System.out.println("");
    }
    {
    break;
    }
        }
    System.out.println("");
    System.out.println("You picked card from your hand");
    System.out.println("");
    playerBoardCards[playerTotalPlayed] = playerHand[choice-1];
    playerHandPlayed[choice-1] = 1;
    totalPlayed++;
    playerDeckPlayed++;
    playerTotalPlayed++;
    playText(shuffledCards, playerHand, computerHand);
    thirdStep();
    }
    }
    public void thirdStep()
    {
    System.out.println("");
    System.out.println("1) Type 1 for end turn");
    System.out.println("2) Type 2 for pick cards from your hand");
    System.out.print("Enter your choice: ");
    int a = sc.nextInt();
    if(a==1)
    {
    
    System.out.println("");
    System.out.println("You chosed to end the turn");
    System.out.println("");
    if(computerstand==false)
    {
    stand = false;
    }else
    {
    
    }
    playText(shuffledCards, playerHand, computerHand);
    }
    if(a==2)
    {
    pickAgain();
    }
    }
    public void pickAgain()
    {
        int choice;
        while (true) {            
    System.out.println("");
    System.out.println("Please enter which row of cards you would like to choose");
    System.out.print("Enter your choice: ");
    choice = sc.nextInt();
    if(choice<1||4<choice||playerHandPlayed[choice-1]==1)
    {
    System.out.println("");
    System.out.println("You entered unvalid number or you selected card which already selected pls try again");
    System.out.println("");
    }
    {
    break;
    }
        }
    
    System.out.println("");
    System.out.println("You picked card from your hand");
    System.out.println("");
    playerBoardCards[playerTotalPlayed] = playerHand[choice-1];
    playerHandPlayed[choice-1] = 1;
    totalPlayed++;
    playerDeckPlayed++;
    playerTotalPlayed++;
    playText(shuffledCards, playerHand, computerHand);
    thirdStep();
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
    if(computerTotal<18)
    {
    computerBoardCards[computerTotalPlayed] = shuffledCards[totalPlayed];
    totalPlayed++;
    computerDeckPlayed++;
    computerTotalPlayed++;    
    }
    if(computerTotal<=20&&computerTotal>=16)
    {
     computerstand = false;
    }
   
    if(computerTotal>20)
    {
    int min= 999;
        int whichHandCard = 999;
        for (int i = 0; i < 4; i++) {
            if((computerTotal-computerHand[i].getCardNumber())<=20&&computerHandPlayed[i]==0)
            {
            if(computerTotal-computerHand[i].getCardNumber()<min)
                min = computerTotal-computerHand[i].getCardNumber();
            whichHandCard = i;
            }
        }
        if(whichHandCard!=999)
        {
        computerBoardCards[computerTotalPlayed] = computerHand[whichHandCard];
        computerHandPlayed[whichHandCard] = 1;
        totalPlayed++;
        computerDeckPlayed++;
        computerTotalPlayed++;
        }else
        {
        computerstand = false;
        }
  
    }
    if(stand==false) computerstand= false;
    
    
    //elindeki kağıtları test et
    //for ile tek tek bak elindeki kağıt seni 20 den aşağı çekiyor mu
    //çekiyorsa kullan ve turu geç
    //elindeki kağıtlar 20 yi geçiyorsa stand ver.
        
    
    
    }
    
    }


