import java.util.Iterator;
import java.util.List;

public class MyReader extends Thread {
    private List list;

    public MyReader(String name, List list) {
        this.list = list;
        super.setName(name);
    }

    public void run() {
        while (true) {
            String info = super.getName() + ":";
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String el = (String) iterator.next();
                info += " " + el;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(info);
        }
    }
}