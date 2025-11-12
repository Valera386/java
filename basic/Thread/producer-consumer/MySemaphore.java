import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySemaphore implements Runnable {
    Semaphore sem = new Semaphore(5); // 5 — максимум одновременных потоков
    int counter;

    public MySemaphore(int c) {
        this.counter = c;
    }

    @Override
    public void run() {
        try {
            sem.acquire(); // Захватываем "место"
            System.out.println(Thread.currentThread().getName() + " is working... " + this.counter);
            Thread.currentThread().sleep(counter);
            System.out.println(Thread.currentThread().getName() + " is finished!");
            sem.release(); // Освобождаем "место"
        } catch (InterruptedException ex) {
            Logger.getLogger(MySemaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}