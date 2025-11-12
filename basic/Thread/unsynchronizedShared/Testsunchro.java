import java.util.logging.Level;
import java.util.logging.Logger;

public class Testsunchro {
    public static void main(String[] args) {
        MyResource counter = new MyResource();
        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Testsunchro.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("counter=" + counter.getCounter());
    }
}

class MyThread extends Thread {
    protected MyResource counter = null;

    public MyThread(MyResource counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            counter.add(i);
        }
    }
}