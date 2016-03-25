package xyz.antsgroup.example.grammar.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ants_ypc
 * @version 1.0 3/25/16
 */
public class SimpleServer {

    /**
     * InetAddress 类.
     * @param server
     */
    public static void testInetAddress(InetAddress server) {
        System.out.println("address:" +  server.toString());
    }

    public static void main(String[] args) {
        int i = 1;
        try (ServerSocket server = new ServerSocket(1210)) {
            testInetAddress(server.getInetAddress());
            boolean running = true;
            while (running) {
                Thread t = new Thread(new ServerHandler(server.accept(), i));
                t.start();
                ++i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerHandler implements Runnable {
    private Socket client;
    private int id;

    public ServerHandler(Socket client, int id) {
        this.client = client;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            try {
                SimpleServer.testInetAddress(client.getInetAddress());
                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();

                try (Scanner sc = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(outStream, true /* auto Flush */);
                    out.println("hello, you are NO." + id + " visitor.Enter exit to exit.");

                    while(sc.hasNextLine()) {
                        String line = sc.nextLine();
                        out.println("Get: " + line);
                        if (line.trim().equals("exit")) break;
                    }
                }
            } finally {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}