import java.io.File;
import java.io.IOException;

public class FileCreateExample {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        System.out.println("File path : " + fullName);
        File file = new File(fullName);
        if (!file.exists()) {
            try {
                if (file.createNewFile())
                    System.out.println("File created!");
                else
                    System.out.println("Something Wrong!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("File already exists!");
        }
    }
}