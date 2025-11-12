import java.util.ArrayList;
import java.util.List;

public class SerializeMultiple {
    public static void main(String[] args) {
        List<Fish> fishes = new ArrayList<>();
        fishes.add(new Fish("eel", 1.5, 120));
        fishes.add(new Fish("salmon", 2.5, 180));
        serialize(fishes, "fishes.txt");
    }

    // serialize method as above
}