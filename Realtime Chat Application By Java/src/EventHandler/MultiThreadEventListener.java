package EventHandler;

import java.io.BufferedReader;
import java.io.IOException;

public class MultiThreadEventListener implements Runnable{

    private BufferedReader reader;

    public MultiThreadEventListener(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
       startListening();
    }

    public void startListening() {
        while (true) {
            try {
                var response = reader.readLine();
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
