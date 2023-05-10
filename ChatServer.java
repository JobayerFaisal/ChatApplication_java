import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private ServerSocket serverSocket;
    private List<ClientHandler> clients = new ArrayList<>();

    public ChatServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
              serverSocket = new ServerSocket();
               System.out.println("Server started ......" );

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected");

                ClientHandler client = new ClientHandler(socket,this);
                clients.add(client);
                client.start();




            }
        } catch (IOException e) {
            e.printStackTrace();        }
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

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }



    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ChatServer server = new ChatServer(serverSocket);
        server.startServer();
    }



}
