import java.util.Random;

public class MainForRunnable {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int v = random.nextInt(10);
        MyThread3 r4 = new MyThread3(v);
        Thread t4 = new Thread(r4);
        t4.setDaemon(true);
        v = random.nextInt(10);
        MyThread3 r5 = new MyThread3(v);
        Thread t5 = new Thread(r5);
        t5.setDaemon(true);
        t4.start();
        t5.start();
        t4.join();
        t5.join();
    }
}