import java.io.*;

public class CopyFileWithResources {
    public static void main(String[] args) {
        String fileName = "outputFile2.tmp";
        byte[] buffer = null;
        try (InputStream in = new FileInputStream(new File("1.jpg"));
             OutputStream out = new FileOutputStream(new File(fileName))) {
            buffer = new byte[in.available()];
            in.read(buffer);
            out.write(buffer);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}