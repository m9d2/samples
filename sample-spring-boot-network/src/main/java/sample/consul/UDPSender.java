package sample.consul;

import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello, World!";
        InetAddress address = InetAddress.getByName("192.168.0.5");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 8080);
        socket.send(packet);
        socket.close();
    }
}
