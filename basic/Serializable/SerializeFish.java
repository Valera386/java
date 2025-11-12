import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Fish implements java.io.Serializable {
    private String name;
    private double weight;
    private double price;

    public Fish(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " weight:" + weight + " price:" + price;
    }
}

public class SerializeFish {
    public static void main(String[] args) {
        FileOutputStream fout = null;
        ObjectOutputStream oout = null;
        try {
            fout = new FileOutputStream("fish.txt");
            Fish f = new Fish("salmon", 2.5, 180);
            oout = new ObjectOutputStream(fout);
            oout.writeObject(f);
        } catch (IOException ex) {
            Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oout != null) oout.close();
            } catch (IOException ex) {
                Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
            }
        }
    }
}
