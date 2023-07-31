package sample.consul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class SampleSpringBootNetworkApplication {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SampleSpringBootNetworkApplication.class, args);

        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            Thread thread = new Thread(() -> {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                while (true) {
                    try {
                        socket.receive(packet);
                        String received = new String(packet.getData(), 0, packet.getLength());
                        log.info("Received: {}", received);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void sendUdpMessage() {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getLocalHost();
            String message = "Hello from UDP!";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, address, PORT);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
