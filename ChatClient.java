import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ChatGUI gui;

    public ChatClient(ChatGUI gui) {
        this.gui = gui;
    }

    public void connect(String hostname, int port) throws IOException {
        socket = new Socket("localhost",9999);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        new Thread(this).start();
    }

    public void sendMessage(String message) {
        out.println(message);
        gui.displayMessage(message);
    }



    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                gui.displayMessage(message);
            }
        } catch (IOException e) {
            gui.displayMessage("Error: " + e.getMessage());
        }
    }
}

