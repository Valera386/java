import java.util.ArrayList;
import java.util.List;

public class PredicateFishesHeavyAndExpensive {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("tuna", 4.2, 320));
        fishes.add(new Fish("trout", 2.8, 150));
        System.out.println("Fishes more expensive than 100 and heavier than 2:");
        GetByPredicate.getByPredicate(fishes, (f) -> f.getPrice() > 100 && f.getWeight() > 2);
    }
}