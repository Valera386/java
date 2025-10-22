import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Значение1");
        hashMap.put(2, "Значение2");
        System.out.println("HashMap: " + hashMap.get(1));
    }
}
