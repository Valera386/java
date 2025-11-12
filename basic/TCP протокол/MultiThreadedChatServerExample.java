import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThreadedChatServerExample {
    ServerSocket listener = null;
    Socket client = null;
    int maxCount = 10; // max number of clients
    int count = 0; // current client number
    int port = 8888;

    public static void main(String[] args) {
        MultiThreadedChatServerExample chat = new MultiThreadedChatServerExample();
        chat.createConnection();
    }

    void createConnection() {
        try {
            listener = new ServerSocket(port, maxCount);
            while (count <= maxCount) {
                count++;
                client = listener.accept();
                MultiThreadedServerMyListenerExample ml = new MultiThreadedServerMyListenerExample(client);
                Thread t = new Thread(ml);
                t.setDaemon(true);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MultiThreadedChatServerExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}