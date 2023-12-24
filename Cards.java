
public class Cards {
    
    private int cardNumber;
     private String cardColor;
      private boolean x2;
       private boolean joker = false;
    

    public Cards(int cardNumber, String cardColor) {
        
        this.cardNumber = cardNumber;
         this.cardColor = cardColor;
    }
    public Cards(boolean x2) {
        
        this.x2 = x2;
         joker = true;
    }

    public boolean isX2() {
        return x2;
    }

    public void setX2(boolean x2) {
        this.x2 = x2;
    }

    public boolean isJoker() {
        return joker;
    }

    public void setJoker(boolean joker) {
        this.joker = joker;
    }
    

    

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardColor() {
        return cardColor;
    }

    

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }
    public String getCard(){
    
        if (joker)
        {
            if(x2)
            {
              return "2x";
            }
            else
            {
              return  "+/-";
            }
            
        }
        else
        {
          return cardColor+cardNumber;
        }
        
    }   
}
