class Counter{
    int count = 0;
    void increment(){
        count++;
    }
}

class myThread extends Thread{
    Counter counter;
    myThread(Counter counter){
        this.counter = counter;
    }
    @Override 
    public void run(){
        for(int i=0; i<500; i++){
            counter.increment();
        }
    }
}

public class counterRace{
    public static void main(String args[]){
        Counter counter = new Counter();
        myThread th1 = new myThread(counter);
        myThread th2 = new myThread(counter);
        
        th1.start();
        th2.start();

        System.out.println("Expected: 1000");
        System.out.println("Actual: " + counter.count);
    }
}
