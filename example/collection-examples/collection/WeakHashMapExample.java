import java.util.*;

public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        weakHashMap.put(key, "Значение1");
        key = null;
        System.gc();
        System.out.println("WeakHashMap: " + weakHashMap);
    }
}
