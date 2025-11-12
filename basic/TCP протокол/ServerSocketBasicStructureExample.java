import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketBasicStructureExample {
    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(12345);
            while (true) {
                Socket client = null;
                while (client == null) {
                    client = listener.accept();
                    // communication with the client takes place here
                    System.out.println("Client connected: " + client.getInetAddress());
                }
                // Handle client...
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
