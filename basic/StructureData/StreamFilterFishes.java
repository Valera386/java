import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterFishes {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("tuna", 4.2, 320));
        fishes.add(new Fish("trout", 2.8, 150));
        List<Fish> selected = fishes.stream()
                .filter(f -> f.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("After:");
        selected.forEach(f -> System.out.println(f));
    }
}