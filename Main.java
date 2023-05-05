import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Main() {
      //  /*
        JFrame frame = new JFrame("Chat App");

        chatArea = new JTextArea(25, 50);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField(50);
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //  */
        try {
            Scanner scanner = new Scanner(System.in) ;
            System.out.println("Enter your Username : ");
            String usrename = scanner.nextLine();

            Socket socket = new Socket("localhost",1234);
            Cllient client = new Cllient(socket, usrename);

            //  Testw tr = new Testw();

            client.readMessage();
            client.sendMessage();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            out.println(messageField.getText());
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
