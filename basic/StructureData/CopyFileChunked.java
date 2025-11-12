import java.io.*;

public class CopyFileChunked {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        byte[] buffer = new byte[8 * 1024];
        try {
            in = new FileInputStream(new File("2.jpg"));
            File file = new File("outputFile2.tmp");
            out = new FileOutputStream(file);
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
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