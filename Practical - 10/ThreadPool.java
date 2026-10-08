import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class ThreadPool{
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int i;
        for (i = 1; i <= 10; i++){
            int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println(
                        "Task " + taskId + " running on "
                        + Thread.currentThread().getName()
                    );
                    Thread.sleep(500);

                    System.out.println(
                        "Task " + taskId + " completed on "
                        + Thread.currentThread().getName()
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }
}