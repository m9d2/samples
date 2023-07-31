package sample.consul;

import java.net.*;

public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(8080);
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String message = new String(receivePacket.getData());
        System.out.println("Received message: " + message);
//        serverSocket.close();
    }
}
