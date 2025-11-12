import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorSoftShutdownExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Example task to run
        executor.execute(() -> {
            try {
                Thread.sleep(10000); // Long-running task
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
        });
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            // wait 3 seconds for completion
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            // if service is not completed yet
            if (!executor.isTerminated()) {
                executor.shutdownNow();
                System.err.println("Make it to stop");
            }
            System.out.println("shutdown finished");
        }
    }
}