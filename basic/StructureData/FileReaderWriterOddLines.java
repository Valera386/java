import java.io.*;

public class FileReaderWriterOddLines {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("lines.txt");
            fw = new FileWriter("lines1.txt", true);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                if ((lineCounter++) % 2 == 0) {
                    System.out.println(line);
                    fw.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}