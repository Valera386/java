import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "Значение2");
        treeMap.put(1, "Значение1");
        System.out.println("TreeMap (отсортирован): " + treeMap);
    }
}
