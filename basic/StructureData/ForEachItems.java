import java.util.ArrayList;
import java.util.List;

public class ForEachItems {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(11);
        items.add(5);
        items.add(120);
        items.add(85);
        items.add(251);
        items.add(199);
        items.forEach(item -> System.out.println(item));
    }
}