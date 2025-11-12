import java.io.*;

public class ReadWriteByteByByte {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File("test.txt"));
            File file = new File("outputFile3.txt");
            out = new FileOutputStream(file);
            int c;
            while ((c = in.read()) != -1) {
                if (c < 65) out.write(c);
            }
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