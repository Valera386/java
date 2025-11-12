import java.util.ArrayList;
import java.util.List;

public class StreamCountAndSumFishes {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("tuna", 4.2, 320));
        fishes.add(new Fish("trout", 2.8, 150));
        int number = (int) fishes.stream()
                .filter(f -> f.getPrice() > 100)
                .count();
        double cost = fishes.stream()
                .filter(f -> f.getPrice() > 100)
                .mapToDouble(f -> f.getPrice())
                .sum();
        System.out.println("number=" + number + " total cost=" + cost);
    }
}