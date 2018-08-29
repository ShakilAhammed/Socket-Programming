import Client.Client;

public class ClientTwo {
    public static void main(String args[])
    {
        Client clientTwo = new Client();
        clientTwo.connectToServer("0.0.0.0", 6000);
        System.out.println("Client Two connection has been established.");
//        clientTwo.();
        //clientTwo.stopConnection();
    }
}
