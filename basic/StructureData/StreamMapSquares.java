import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapSquares {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(11);
        items.add(5);
        items.add(120);
        items.add(85);
        items.add(251);
        items.add(199);
        List<Integer> squares = items.stream().map((i) -> i * i).collect(Collectors.toList());
        System.out.println("Squares:");
        squares.forEach(s -> System.out.println(s));
    }
}