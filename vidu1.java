import java.net.*;
import java.io.*;
import java.util.*;

public class DaytimeMulticastServer {

    public static final int defaultPort = 1234;

    public static void main(String args[]) throws Exception {

        if (args.length > 1)
            throw new IllegalArgumentException(
                "Syntax: DaytimeMulticastServer [<multicastgroup>]"
            );

        InetAddress multicastGroup = InetAddress.getByName(
            args.length == 0 ? "234.5.6.7" : args[0]
        );

        MulticastSocket socket = new MulticastSocket();

        // socket.joinGroup(multicastGroup);

        while (true) {

            Thread.sleep(5000);

            System.out.println("Multicast Data ...");

            String str = (new Date()).toString();

            byte[] data = str.getBytes();

            DatagramPacket packet = new DatagramPacket(
                data,
                data.length,
                multicastGroup,
                defaultPort
            );

            socket.send(packet);
        }
    }
}