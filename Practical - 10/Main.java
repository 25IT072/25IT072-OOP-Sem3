class Buffer{
    int item;
    boolean available = false;
    synchronized void produce(int value) {
        try {
            while (available) {
                wait();
            }
            item = value;
            available = true;
            System.out.println("Produced: " + value);
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    synchronized void consume() {
        try {
            while (!available) {
                wait();
            }
            System.out.println("Consumed: " + item);
            available = false;
            notify();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Producer extends Thread {
    Buffer b;
    Producer(Buffer b) {
        this.b = b;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            b.produce(i);
        }
    }
}

class Consumer extends Thread {
    Buffer b;
    Consumer(Buffer b) {
        this.b = b;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            b.consume();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Buffer b = new Buffer();

        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();

        p.join();
        c.join();

        System.out.println("Finished");
    }
}
