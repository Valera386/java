import java.io.*;

public class BufferedReadExample {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream(new File("notes.txt"));
             BufferedInputStream bis = new BufferedInputStream(fin)) {
            int c;
            while ((c = bis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}