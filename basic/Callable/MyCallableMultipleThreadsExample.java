import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyCallableMultipleThreadsExample {
    public static void main(String[] args) {
        int num = 10; // number of threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);
        // create list to keep the results from all the threads
        List<Future<Integer>> results = new ArrayList<>();
        Random r = new Random();
        // process all the 10 threads in the loop
        for (int i = 0; i < num; i++) {
            int b = r.nextInt(10); // generate random interval
            int e = r.nextInt(100) + 10;
            System.out.println("Limits: " + b + " to " + e);
            MyCallable mc = new MyCallable(b, e); // create Callable
            Future<Integer> result = executor.submit(mc); // launch the thread
            results.add(result); // add received result in the list
        }
        System.out.println("Results: ");
        try {
            // show the results from all the threads
            for (Future<Integer> result : results) {
                System.out.println("Result is: " + result.get());
            }
            executor.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyCallableMultipleThreadsExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(MyCallableMultipleThreadsExample.class.getName()).log(Level.SEVERE, null, ex);
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