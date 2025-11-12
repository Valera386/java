import java.util.logging.Level;
import java.util.logging.Logger;

public class Testsynchro {
    public static void main(String[] args) {
        MyResourceSynchronized counter = new MyResourceSynchronized();
        Thread t1 = new MyThreadSynchronized(counter);
        Thread t2 = new MyThreadSynchronized(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Testsynchro.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("counter=" + counter.getCounter());
    }
}

class MyThreadSynchronized extends Thread {
    protected MyResourceSynchronized counter = null;

    public MyThreadSynchronized(MyResourceSynchronized counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            counter.add(i);
        }
    }
}