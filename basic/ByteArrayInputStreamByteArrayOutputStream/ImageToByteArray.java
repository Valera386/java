import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageToByteArray {
    public static void main(String[] args) {
        File fnew = new File("2.jpg");
        try {
            BufferedImage bImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", baos);
            byte[] imageInByte = baos.toByteArray();
            // Further use, e.g., ImageFrame imf = new ImageFrame(imageInByte);
        } catch (IOException ex) {
            Logger.getLogger("Filetest").log(Level.SEVERE, null, ex);
        }
    }
}
