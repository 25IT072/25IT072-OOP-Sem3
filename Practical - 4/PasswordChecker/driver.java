import java.util.Scanner;
public class driver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter password: ");
        String pass = sc.nextLine();

        System.out.println("Password strength: " + PasswordChecker.strength(pass));

        sc.close();
    }
}
