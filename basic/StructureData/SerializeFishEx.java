import java.io.*;

public class SerializeFishEx {
    public static void main(String[] args) {
        FishEx f = new FishEx("salmon", 2.5, 180);
        serializeEx(f, "fishex.txt");
    }

    public static void serializeEx(FishEx obj, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            obj.writeExternal(oos);
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