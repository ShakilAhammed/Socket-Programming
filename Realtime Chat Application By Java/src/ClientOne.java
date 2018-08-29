import Client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientOne {
    public static void main(String args[])
    {
        Client clientOne = new Client();
        clientOne.connectToServer("0.0.0.0", 6000);
        clientOne.startConversion();
        //clientOne.stopConnection();
    }
}
