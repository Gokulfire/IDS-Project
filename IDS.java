import java.io.IOException;
import java.net.Socket;
import java.net.InetSocketAddress;

public class IDS {

    public static void main(String[] args) {
        String targetIP = "127.0.0.1"; // Localhost (Change if needed)
        int[] ports = {21, 22, 23, 80, 443}; // Common ports to monitor

        System.out.println("Starting Java Port Monitor IDS...");

        while (true) {
            for (int port : ports) {
                try (Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(targetIP, port), 100);
                    System.out.println("[ALERT] Port " + port + " is OPEN on " + targetIP);
                } catch (IOException e) {
                    System.out.println("Port " + port + " is closed.");
                }
            }

            try {
                Thread.sleep(5000); // Wait 5 seconds before next scan
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
