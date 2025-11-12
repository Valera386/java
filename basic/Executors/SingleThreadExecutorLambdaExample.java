import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleThreadExecutorLambdaExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SingleThreadExecutorLambdaExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from " + threadName);
        });
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello again from " + threadName);
        });
        executor.shutdown();
    }
}