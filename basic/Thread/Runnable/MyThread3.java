public class MyThread3 implements Runnable {
    private int value;

    public MyThread3(int v) {
        this.value = v;
    }

    @Override
    public void run() {
        System.out.println("*** The thread " + Thread.currentThread().getName() + " started with " + this.value);
        while (this.value >= 0) {
            System.out.println("From " + Thread.currentThread().getName() + " value = " + this.value);
            this.value -= 1;
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                // Игнорируем
            }
        }
        System.out.println("*** The thread " + Thread.currentThread().getName() + " has finished");
    }
}