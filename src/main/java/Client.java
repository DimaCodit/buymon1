import java.io.IOException;
import java.net.*;

public class Client extends Thread {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public Client() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, address, 50001);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.sendEcho("морковка;2;45;0;90");
    }

    public static void main(String[] args) {

        new Client().start();

    }

}
