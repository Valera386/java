import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List cowal = new CopyOnWriteArrayList<>();
        cowal.add("Belgium");
        cowal.add("USA");
        cowal.add("Poland");
        cowal.add("Brazil");
        cowal.add("Canada");
        Thread twriter = new MyWriter("MyWriter", cowal);
        twriter.start();
        Thread treader = new MyReader("MyReader", cowal);
        treader.start();
    }
}