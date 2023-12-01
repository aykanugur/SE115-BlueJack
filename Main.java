import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayStrings ps = new PlayStrings();
        
        while (true) {            
            ps.startText();
            int choice = sc.nextInt();
            if(choice==1) play();
            if(choice==2)
            {
                System.out.println("");
                System.out.println("Thx for playing bluejack made by Aykan Ugur");
                System.out.println("");
                break;
            }else
            {
                System.out.println("");
                System.out.println("pls enter valid number for this section");
                System.out.println("");
            }
        } 
            
        
    }
    public static void play(){
    
        PlayStrings ps = new PlayStrings();
        ps.playText();
        
    }
}
