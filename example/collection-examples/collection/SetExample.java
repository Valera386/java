import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Элемент1");
        set.add("Элемент1"); // Дубликат не добавится
        System.out.println("Set: " + set);
    }
}
