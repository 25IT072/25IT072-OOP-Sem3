import java.util.Scanner;
public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int CAPACITY;
    private static int totalBooked = 0;

    public CinemaShow(String title, int CAPACITY){
        this.title = title;
        this.CAPACITY = CAPACITY;
        this.seatsAvailable = CAPACITY;
    }
    public CinemaShow(String title){
        this(title, 100);
    }
    public boolean book(int n){
        if(n <= seatsAvailable){
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        else return false;
    }
    public void cancel(int n){
        seatsAvailable += n;
        totalBooked -= n;
        if(seatsAvailable >= CAPACITY){
            seatsAvailable = CAPACITY;
            totalBooked = 0;
        }
    }
    public String getTitle(){
        return title;
    }
    public int getSeatsAvailable(){
        return seatsAvailable;
    }
    public static int getTotalBooked(){
        return totalBooked;
    }
    public static void main(String[] args) {
        CinemaShow s1 = new CinemaShow("abc", 50);

        System.out.println("Available Seats: " + s1.getSeatsAvailable());

        System.out.println("Book 20 Seats: " + s1.book(20));
        System.out.println("Available Seats: " + s1.getSeatsAvailable());

        System.out.println("Book 35 Seats: " + s1.book(35));
        System.out.println("Available Seats: " + s1.getSeatsAvailable());

        s1.cancel(10);
        System.out.println("Available Seats: " + s1.getSeatsAvailable());

        System.out.println("Total Booked Seats: " + CinemaShow.getTotalBooked());
    }
}
