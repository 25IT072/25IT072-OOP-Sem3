import java.util.Scanner;

record Vehicle(String number, String type) {}
public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bike = 0, car = 0, truck = 0;

        while(true){
            System.out.println("Enter no. of vehicle (or done): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter vehicle type:  ");
            String type = sc.next().toLowerCase();
            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> {
                    bike++;
                    yield 20;
                }
                case "car" -> {
                    car++;
                    yield 50;
                }
                case "truck" -> {
                    truck++;
                    yield 150;
                }
                default -> 0;
            };
            totalToll += toll;
        }
        String mostFrequent;

        if (bike >= car && bike >= truck)
            mostFrequent = "bike";
        else if (car >= bike && car >= truck)
            mostFrequent = "car";
        else
            mostFrequent = "truck";

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}
