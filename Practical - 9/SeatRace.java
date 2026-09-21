class SeatBooking {
    int Left = 5;
    synchronized void book(String name){
        if(Left > 0){
            System.out.println(name + " booked a seat");
            Left--;
        }else{
            System.out.println(name + " could not book a seat");
        }
    }
}

class BookingThread extends Thread {
    SeatBooking booking;
    BookingThread(SeatBooking booking, String name){
        super(name);
        this.booking = booking;
    }
    public void run(){
        booking.book(getName());
    }
}

public class SeatRace{
    public static void main(String[] args){
        SeatBooking booking = new SeatBooking();

        for (int i = 1; i <= 10; i++) {
            new BookingThread(booking, "Thread-" + i).start();
        }
    }
}
