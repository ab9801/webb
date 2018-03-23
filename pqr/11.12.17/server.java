import java.io.*;
import java.util.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class server {

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        Scanner in = new Scanner(System.in);
        InetAddress addr = InetAddress.getByName("224.0.0.3");
        try {
            DatagramSocket serverSocket = new DatagramSocket();
            for(int i = 0; i < 5; i++) {
                String msg = in.nextLine();
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                        msg.getBytes().length, addr, 5000);
                serverSocket.send(msgPacket);            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
