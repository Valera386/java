import java.io.*;

public class FishEx implements Externalizable {
    private String name;
    private double weight;
    transient private double price;

    public FishEx() {
        this.name = "noname";
        this.weight = 0;
        this.price = 0;
    }

    public FishEx(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeDouble(this.price);
        out.writeDouble(this.weight);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.price = in.readDouble();
        this.weight = in.readDouble();
    }

    @Override
    public String toString() {
        return name + " weight:" + weight + " price:" + price;
    }
}