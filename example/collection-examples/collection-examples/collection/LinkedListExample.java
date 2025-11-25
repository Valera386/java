import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Элемент1");
        linkedList.addFirst("Элемент0");
        System.out.println("LinkedList: " + linkedList);
    }
}
