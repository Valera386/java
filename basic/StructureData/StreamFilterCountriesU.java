import java.util.stream.Stream;

public class StreamFilterCountriesU {
    public static void main(String[] args) {
        Stream.of("Argentina", "Bulgaria", "Canada", "Denmark", "Ukraine", "USA")
                .filter((c) -> c.startsWith("U"))
                .forEach(c -> System.out.println(c));
    }
}