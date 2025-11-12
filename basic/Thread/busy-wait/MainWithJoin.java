import java.util.Random;

public class MainWithJoin {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int v = random.nextInt(10);
        MyThread2 t2 = new MyThread2(v);
        v = random.nextInt(10);
        MyThread2 t3 = new MyThread2(v);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
    }
}