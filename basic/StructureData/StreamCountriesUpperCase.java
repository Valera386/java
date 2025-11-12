import java.util.stream.Stream;

public class StreamCountriesUpperCase {
    public static void main(String[] args) {
        Stream.of("Argentina", "Bulgaria", "Canada", "Denmark", "Ukraine", "USA")
                .map(String::toUpperCase)
                .forEach((c) -> System.out.println(c));
    }
}