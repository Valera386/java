import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        IntStream.of(1, 4, 11, 7, 32, 4, 79).forEach((c) -> System.out.println(c));
    }
}