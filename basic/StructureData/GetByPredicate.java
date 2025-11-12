import java.util.List;
import java.util.function.Predicate;

public class GetByPredicate {
    public static void getByPredicate(List<Fish> fishes, Predicate<Fish> p) {
        for (Fish f : fishes) {
            if (p.test(f)) {
                System.out.println(f);
            }
        }
    }
}