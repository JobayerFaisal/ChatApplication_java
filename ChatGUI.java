import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.util.*;



public class ChatGUI implements ActionListener {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private ChatClient client;

    public ChatGUI() {
        frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField(30);
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(messagePanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        //    String hostname = JOptionPane.showInputDialog("Enter server hostname:");
        //    int port = Integer.parseInt(JOptionPane.showInputDialog("Enter server port number:"));

        client = new ChatClient(this);
        try {
         //   Socket socket = new Socket();
            client.connect("localhost",9999);
        } catch (Exception e) {
            displayMessage("Error: " + e.getMessage());
        }
    }

    public void displayMessage(String message) {
        chatArea.append(message + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageField.getText();
        client.sendMessage(message);
        messageField.setText("");
    }

    public static void main(String[] args) {
        new ChatGUI();
    }
}
