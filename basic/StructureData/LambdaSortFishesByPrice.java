import java.util.ArrayList;
import java.util.List;

public class LambdaSortFishesByPrice {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        fishes.add(new Fish("carp", 3.5, 80));
        fishes.add(new Fish("tuna", 4.2, 320));
        fishes.add(new Fish("trout", 2.8, 150));
        System.out.println("Before Sorting:");
        for (Fish f : fishes) {
            System.out.println(f);
        }
        fishes.sort((f1, f2) -> (int) f1.getPrice() * 100 - (int) f2.getPrice() * 100);
        System.out.println("After Sorting:");
        for (Fish f : fishes) {
            System.out.println(f);
        }
    }
}