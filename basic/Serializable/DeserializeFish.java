import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeserializeFish {
    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(new File("fish.txt"));
            ObjectInputStream oin = new ObjectInputStream(fin);
            Fish f = (Fish) oin.readObject();
            System.out.println(f);
        } catch (IOException ex) {
            Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException ex) {
                Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
            }
        }
    }
}