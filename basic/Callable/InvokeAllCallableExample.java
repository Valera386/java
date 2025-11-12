import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvokeAllCallableExample {
    public static void main(String[] args) {
        int num = 10; // number of threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);
        // collection to keep created callables
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        Random r = new Random();
        // fill the collection in the loop
        for (int i = 0; i < num; i++) {
            MyStringCallable mc = new MyStringCallable(r.nextInt(1000));
            callables.add(mc);
        }
        // another collection to keep the results from all the threads
        List<Future<String>> results = null;
        try {
            results = executor.invokeAll(callables);
            for (Future<String> result : results) {
                System.out.println("Received from callable: " + result.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(InvokeAllCallableExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(InvokeAllCallableExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
    }

    static class MyStringCallable implements Callable<String> {
        private long wait;

        public MyStringCallable(int timeInMillis) {
            this.wait = timeInMillis;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(wait);
            return Thread.currentThread().getName();
        }
    }
}