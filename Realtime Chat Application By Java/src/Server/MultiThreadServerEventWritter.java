package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiThreadServerEventWritter implements Runnable {

    private BufferedReader reader;
    private PrintWriter writer;
    private Socket clientSocket;

    public MultiThreadServerEventWritter(BufferedReader reader, PrintWriter writer, Socket clientSocket) {
        this.reader = reader;
        this.writer = writer;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        writer.println("Cool! Man");
        while(true) {
            String message = null;
            try {
                message = reader.readLine();
                System.out.println(clientSocket.getInetAddress()+ " -> " + message);
                if ("Hello Server".equals(message)) {
                    writer.println("Hello Client");
                }
                else {
                    writer.println("Sorry, I am a lazy bot!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
