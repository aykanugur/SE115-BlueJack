import java.util.Random;


 //int foo = Integer.parseInt(myString); to string to int
//charAt(0) to take first char at string;

public class PlayStrings {
     Random random = new Random();
    public PlayStrings() {
  
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
    public String[][] gamedeckCreator(String[][] gameDeck){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <10 ; j++) {
                    if(i==0) gameDeck[0][j] = "+B"+(j+1);
                    if(i==1) gameDeck[1][j] = "+Y"+(j+1);
                    if(i==2) gameDeck[2][j] = "+R"+(j+1);
                    if(i==3) gameDeck[3][j] = "+G"+(j+1);
                }
            }
            return gameDeck;
    }
    public String[] secondStepDeckGenerator(String[] deck){
        for (int i = 5; i < 8; i++) {
            String color = "";
            int colorI = random.nextInt(4);//0 B 1 Y 2 R 3 G
            int numberI = random.nextInt(6)+1;
            int signI = random.nextInt(2);
            
            if(colorI ==0) color = "B";
            if(colorI ==1) color = "Y";
            if(colorI ==2) color = "R";
            if(colorI ==3) color = "G";
            
            if(signI==0) deck[i] = "+"+""+color+numberI;
            if(signI==1) deck[i] = "-"+""+color+numberI;
        }
        return deck;
    }
    public String[] thirdStepDeckGenerator(String[] deck){
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
            
            if(signI==0) deck[i] = "+"+""+color+numberI;
            if(signI==1) deck[i] = "-"+""+color+numberI;
    
            }else{
            
                if(alreadyJokerSelected==false)
                {
                if(jokerCard==0) deck[i] = "-/+";
                if(jokerCard==1) deck[i] = "X2";
                }else
                {
                if(jokerCard==0)deck[i] = "X2";
                if(jokerCard==1) deck[i] = "-/+";
                }
                
            }
            
        }
        return deck;
    
    
    }
}
