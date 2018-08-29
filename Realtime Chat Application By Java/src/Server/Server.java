package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;
    private Thread threadServer;
    private MultiThreadServerEventWritter multiThreadEventWritterServer;
    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Address -> " + serverSocket.getInetAddress());
            System.out.println("Server is listening at " + port + " port...");
            while (true) {
                clientSocket = serverSocket.accept();
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                multiThreadEventWritterServer = new MultiThreadServerEventWritter(reader, writer, clientSocket);
                threadServer = new Thread(multiThreadEventWritterServer);
                threadServer.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
