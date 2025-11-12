import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvokeAnyCallableExample {
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
        String result = "";
        try {
            // launch a random thread out of 10
            result = executor.invokeAny(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(InvokeAnyCallableExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(InvokeAnyCallableExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
        // show the name of the launched thread
        System.out.println("Received from callable: " + result);
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