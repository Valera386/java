import java.util.Random;

public class MainTwoThreads {
    public static void main(String[] args) {
        Random random = new Random();
        int v = random.nextInt(10);
        MyThread2 t2 = new MyThread2(v);
        t2.setDaemon(true);
        v = random.nextInt(10);
        MyThread2 t3 = new MyThread2(v);
        t3.setDaemon(true);
        t2.start();
        t3.start();
    }
}