import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubmitFutureRunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new Runnable() {
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println("This code is being executed " +
                        "asynchronously in thread " + threadName);
            }
        });
        try {
            // returns null if the task completed successfully
            if (future.get() == null) {
                System.out.println("Success!");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SubmitFutureRunnableExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SubmitFutureRunnableExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
    }
}