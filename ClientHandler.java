import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    private ChatServer chatServer;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.clientSocket = socket;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message from client: " + inputLine);
                chatServer.broadcastMessage(inputLine);
            }

            chatServer.removeClient(this);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
