import java.util.List;

public class MyWriter extends Thread {
    private List list;
    private int item;

    public MyWriter(String name, List list) {
        this.list = list;
        item = 0;
        super.setName(name);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            String new_item = "element" + item++;
            list.add((String) (new_item));
            System.out.println(super.getName() + "New element added!");
        }
    }
}