import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySemaphoreClassExample {
    public static void main(String[] args) {
        Random r = new Random();
        MySemaphore ms = new MySemaphore(r.nextInt(2000) + 1000);
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(ms);
            t.start();
        }
    }

    static class MySemaphore implements Runnable {
        Semaphore sem = new Semaphore(5); // 5 is number of free rooms
        int counter;

        public MySemaphore(int c) {
            this.counter = c; // just a random value to simulate a job
        }

        @Override
        public void run() {
            try {
                sem.acquire(); // decrease number of free rooms by 1
                System.out.println(Thread.currentThread().getName() + " is working... " + this.counter);
                Thread.currentThread().sleep(counter);
                System.out.println(Thread.currentThread().getName() + " is finished!");
                sem.release(); // increase number of free rooms by 1
            } catch (InterruptedException ex) {
                Logger.getLogger(MySemaphore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}