import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyCallableSingleThreadExample {
    public static void main(String[] args) {
        int num = 1; // number of threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);
        MyCallable mc = new MyCallable(1, 10);
        Future<Integer> result = executor.submit(mc);
        try {
            System.out.println("Result is: " + result.get());
            System.out.println("And task completion status is " + result.isDone());
            executor.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyCallableSingleThreadExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(MyCallableSingleThreadExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class MyCallable implements Callable<Integer> {
        int beg;
        int end;

        public MyCallable(int beg, int end) {
            this.beg = beg;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            Integer sum = 0;
            for (int i = this.beg; i <= this.end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}