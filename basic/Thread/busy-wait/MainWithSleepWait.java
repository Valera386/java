import java.util.Random;

public class MainWithSleepWait {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int v = random.nextInt(10);
        MyThread2 t2 = new MyThread2(v);
        v = random.nextInt(10);
        MyThread2 t3 = new MyThread2(v);
        t2.start();
        t3.start();
        Thread.sleep(5000); // Фиксированный таймаут — ненадежно
    }
}