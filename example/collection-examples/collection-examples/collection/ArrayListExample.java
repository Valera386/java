import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Элемент1");
        arrayList.add("Элемент2");
        arrayList.remove(0);
        System.out.println("ArrayList: " + arrayList);
    }
}
