import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Значение1");
        linkedHashMap.put(2, "Значение2");
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}
