import java.util.Random;

public class MainWithIsAlive {
    public static void main(String[] args) {
        Random random = new Random();
        int v = random.nextInt(10);
        MyThread2 t2 = new MyThread2(v);
        // Без daemon, чтобы подождать
        v = random.nextInt(10);
        MyThread2 t3 = new MyThread2(v);
        t2.start();
        t3.start();
        while (t2.isAlive() || t3.isAlive()) {
            // Пустой цикл — тратит CPU
        }
    }
}