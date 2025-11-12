import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress addr1 = InetAddress.getByName("127.0.0.1");
            InetAddress addr2 = InetAddress.getByName("www.google.com");
            InetAddress addr3 = InetAddress.getLocalHost();
            System.out.println("addr1: " + addr1);
            System.out.println("addr2: " + addr2);
            System.out.println("addr3: " + addr3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}