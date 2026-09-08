import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class MulticastSocketServer {

    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;

    public static void main(String[] args)
            throws UnknownHostException, InterruptedException {

        try (DatagramSocket serverSocket = new DatagramSocket()) {

            InetAddress addr = InetAddress.getByName(INET_ADDR);

            for (int i = 0; i < 10; i++) {

                String msg = "Sent msg no. " + i;

                DatagramPacket msgPacket = new DatagramPacket(
                        msg.getBytes(),
                        msg.getBytes().length,
                        addr,
                        PORT
                );

                serverSocket.send(msgPacket);

                System.out.println(
                        "Server sent packet with msg: " + msg
                );

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}