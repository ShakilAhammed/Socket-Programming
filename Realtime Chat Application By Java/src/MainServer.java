import Server.Server;

public class MainServer {
    public static void main(String args[])
    {
        Server server = new Server();
        server.startServer(6000);
        //server.stop();
    }
}
