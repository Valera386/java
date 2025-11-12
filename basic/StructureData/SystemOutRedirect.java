import java.io.*;

public class SystemOutRedirect {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(new FileOutputStream("out.txt")));
            System.out.println("The output is redirected into file now!");
        } catch (Exception e) {
            System.err.println("File opening error:");
            e.printStackTrace();
        }
    }
}