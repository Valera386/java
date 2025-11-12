import java.io.*;

public class InputStreamReaderOutputStreamWriter {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("lines.txt"));
             InputStreamReader reader = new InputStreamReader(fis, "windows-1251");
             FileOutputStream fs = new FileOutputStream(new File("lines2.txt"));
             OutputStreamWriter writer = new OutputStreamWriter(fs, "UTF-8")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
                writer.write(c);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}