

        import java.util.*;
        import java.io.*;
        import java.net.*;

public class Userver {
    private ServerSocket serverSocket;

    public Userver(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


            // The server start & is ready to connect friends .
    public void startServer() {
        try {

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected.");

                CllientHandler cllientHandler = new CllientHandler(socket);

                Thread thread = new Thread(cllientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


            //  For close the server
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws  IOException{

      ServerSocket serverSocket = new ServerSocket(1234);
      Userver server = new Userver(serverSocket);
      server.startServer();
    }




}
