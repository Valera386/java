import java.io.*;

public class SerializeFish {
    public static void main(String[] args) {
        Fish f = new Fish("salmon", 2.5, 180);
        serialize(f, "fish.txt");
    }

    public static void serialize(Object obj, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                System.err.println("Input/Output error:");
                ex.printStackTrace();
            }
        }
    }
}