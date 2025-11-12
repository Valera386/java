import java.io.File;

public class DirectoryCreateExample {
    public static void main(String[] args) {
        String dirName = System.getProperty("user.dir");
        String dirname = dirName + "/tmp/user/java/bin";
        File d = new File(dirname);
        // Create directories now.
        d.mkdirs();
    }
}