import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreAnonymous {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            Semaphore sem = new Semaphore(5);
            Random r = new Random();
            int counter = r.nextInt(2000) + 500;

            @Override
            public void run() {
                try {
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName() + " is working... " + counter);
                    Thread.currentThread().sleep(counter);
                    System.out.println(Thread.currentThread().getName() + " is finished!");
                    sem.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger("SemaphoreAnonymous").log(Level.SEVERE, null, ex);
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(task).start();
        }
    }
}