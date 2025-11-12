import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ByteArrayOutputStreamImage {
    public static void main(String[] args) throws IOException {
        File fnew = new File("2.jpg");
        BufferedImage bImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", baos);
        byte[] imageInByte = baos.toByteArray();
        ImageFrame imf = new ImageFrame(imageInByte);
    }
}