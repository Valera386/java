import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageToFrame {
    public static void main(String[] args) {
        File file = new File("2.jpg"); // Убедись, что файл существует!

        try {
            BufferedImage img = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();

            // ЭТО И ЕСТЬ ЗАПУСК ImageFrame!
            new ImageFrame(imageBytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}