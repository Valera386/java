import java.io.IOException;
import java.net.Socket;

public class SocketClientBasicExample {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("10.3.6.14", 12345);
            System.out.println("Connected to server");
            // Send and receive data...
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}