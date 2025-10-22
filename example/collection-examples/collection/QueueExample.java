import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Элемент1");
        queue.offer("Элемент2");
        System.out.println("Первый элемент: " + queue.poll());
    }
}
