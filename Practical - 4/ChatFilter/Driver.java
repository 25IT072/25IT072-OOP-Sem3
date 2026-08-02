import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice hello there",
            "10:02 bob hey hi",
            "10:04",
            "10:08 charlie good morning"
        };
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter keyword: ");
        String key = sc.nextLine();

        String result = ChatFilter.filter(logs, key);
        System.out.println(result);
        sc.close();
    }
}
