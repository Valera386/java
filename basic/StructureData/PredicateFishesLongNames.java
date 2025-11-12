import java.util.ArrayList;
import java.util.List;

public class PredicateFishesLongNames {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("tuna", 4.2, 320));
        fishes.add(new Fish("trout", 2.8, 150));
        System.out.println("Fishes with names longer than 5 characters:");
        GetByPredicate.getByPredicate(fishes, (f) -> f.getName().length() > 5);
    }
}