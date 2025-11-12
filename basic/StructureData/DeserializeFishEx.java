import java.io.*;

public class DeserializeFishEx {
    public static void main(String[] args) {
        FishEx fe = (FishEx) deserializeEx("fishex.txt");
        System.out.println(fe);
    }

    public static Object deserializeEx(String fileName) {
        FileInputStream fis = null;
        FishEx obj = new FishEx();
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj.readExternal(ois);
            ois.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found:");
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.err.println("Input/Output error:");
                ex.printStackTrace();
            }
        }
        return obj;
    }
}