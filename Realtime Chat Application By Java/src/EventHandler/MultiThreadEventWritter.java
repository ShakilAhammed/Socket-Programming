package EventHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MultiThreadEventWritter implements Runnable {

    private BufferedReader keyReader;
    private PrintWriter writer;


    public MultiThreadEventWritter(PrintWriter writer) {
        this.writer = writer;
        keyReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        startWriting();
    }

    public void sendMessage(String message) {
        writer.println(message);
    }



    public void startWriting() {
        while(true) {
            try {
                String message = keyReader.readLine();
                this.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
