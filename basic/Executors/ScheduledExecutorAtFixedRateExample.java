import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduledExecutorAtFixedRateExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };
        ScheduledFuture sf = executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ScheduledExecutorAtFixedRateExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        sf.cancel(true);
    }
}
