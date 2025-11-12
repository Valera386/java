import java.io.*;

public class CopyFileExample1 {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = null;
        try {
            in = new FileInputStream(new File("test.txt"));
            buffer = new byte[in.available()];
            in.read(buffer);
            File file = new File("outputFile.tmp");
            out = new FileOutputStream(file);
            out.write(buffer);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}