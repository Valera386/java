import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFishesByWeight {
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
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish f1, Fish f2) {
                return (int) f1.getWeight() * 100 - (int) f2.getWeight() * 100;
            }
        });
        System.out.println("After Sorting:");
        for (Fish f : fishes) {
            System.out.println(f);
        }
    }
}