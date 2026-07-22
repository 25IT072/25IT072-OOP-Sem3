import java.util.Scanner;
public class VendingMachine{
    enum Coin { ONE, TWO, FIVE, TEN }
    public static void main(String[] args) {
        final int price = 15;            
        int total = 0; 

        Scanner s = new Scanner(System.in);

        while(total<price){
            System.out.print("Enter coin (ONE, TWO, FIVE, TEN): ");
            Coin coin = Coin.valueOf(s.next().toUpperCase());
            int choice = switch(coin){
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };
            total += choice;
            System.out.println("Total: " + total);
        }
         System.out.println("Paid change: " + (total - price));
        s.close();
    }
}