import java.io.*;

public class BufferedWriteExample {
    public static void main(String[] args) {
        String text = "This lines of text should be written in file\r\n" +
                "using buffered stream.\r\n" +
                "Just one more line.\r\n";
        try (FileOutputStream out = new FileOutputStream("notes.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}