import java.util.Random;

public class SemaphoreMain {
    public static void main(String[] args) {
        Random r = new Random();
        // Каждый поток получает свой counter
        for (int i = 0; i < 20; i++) {
            MySemaphore ms = new MySemaphore(r.nextInt(2000) + 1000);
            new Thread(ms).start();
        }
    }
}