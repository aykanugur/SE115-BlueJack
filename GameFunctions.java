
import java.util.Random;

 //int foo = Integer.parseInt(myString); to string to int
//charAt(0) to take first char at string;

public class  GameFunctions{
     Random random = new Random();
     
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
    public void playText(){
    
            
            System.out.println("                  -------------------------------");
           System.out.println("Computer's hand-->"+"M1 M2 M3 M4 M5 M6 M7 M8 M9");
            System.out.println("                  -------------------------------");
           System.out.println("Computer's Board->"+"");
            System.out.println("                  -------------------------------");
           System.out.println("Player's Board--->"+"");
            System.out.println("                  -------------------------------");
           System.out.println("Player's hand---->"+"");
            System.out.println("                  -------------------------------");
     
    }
    public Cards[] gamedeckCreator(Cards[][] gameDeck){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <10 ; j++) {
                    if(i==0) gameDeck[i][j] = new Cards(true, j+1, "B");
                    if(i==1) gameDeck[i][j] = new Cards(true, j+1, "Y");
                    if(i==2) gameDeck[i][j] = new Cards(true, j+1, "R");
                    if(i==3) gameDeck[i][j] = new Cards(true, j+1, "G");
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
            
            deck[i] = new Cards(signI==0, numberI, color);
            
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
            
            deck[i] = new Cards(signI==0, numberI, color);
    
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
     
 
}
   

