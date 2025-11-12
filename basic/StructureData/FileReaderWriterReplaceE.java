import java.io.*;

public class FileReaderWriterReplaceE {
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
                    char buffer[] = new char[line.length()];
                    line.getChars(0, line.length(), buffer, 0);
                    for (int i = 0; i < buffer.length; i++) {
                        if (buffer[i] == 'e') fw.write('E');
                        else fw.write(buffer[i]);
                    }
                    fw.write(System.getProperty("line.separator"));
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