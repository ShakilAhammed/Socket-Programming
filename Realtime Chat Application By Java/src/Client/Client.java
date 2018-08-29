package Client;

import EventHandler.MultiThreadEventListener;
import EventHandler.MultiThreadEventWritter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;
    private MultiThreadEventListener eventListener;
    private MultiThreadEventWritter eventWritter;
    Thread threadListener;
    Thread threadWritter;

    public void connectToServer(String ip, int port){
        try {
            clientSocket = new Socket(ip, port);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            eventListener = new MultiThreadEventListener(reader);
            eventWritter = new MultiThreadEventWritter(writer);
            threadListener = new Thread(eventListener);
            threadWritter = new Thread(eventWritter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    @Override
//    public void run() {
//        startConversion();
//    }
//
    public void startConversion() {
        //threadWritter.start();
        threadListener.start();
    }

    public void stopConnection() {
        try {
            clientSocket.close();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
