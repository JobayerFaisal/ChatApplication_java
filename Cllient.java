


import java.io.*;
import java.net.*;
import java.util.*;

public class Cllient {

    Scanner scanner = new Scanner(System.in);


    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    public Cllient(Socket socket, String username) {//  For private variables
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }catch (IOException e) {
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }


    public void sendMessage() {   // Sent massage from ones
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();


            while (socket.isConnected()) {

                String mesageToSend = scanner.nextLine();
                bufferedWriter.write(username + ": " + mesageToSend) ;
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket,bufferedReader,bufferedWriter);
        }
    }



    public void readMessage() {  // Get & print message
        new Thread(new Runnable() {

            @Override
            public void run() {
                String msgFromGroupChat;

                while (socket.isConnected()) {
                    try {
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);
                    } catch (IOException e) {
                        closeEverything(socket,bufferedReader,bufferedWriter);
                    }


                }
            }
        }).start();

    }



    public void closeEverything(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter) {
        try {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
            if(bufferedWriter != null) {
                bufferedWriter.close();
            }
            if(socket != null) {
                socket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Enter your Username : ");
        String usrename = scanner.nextLine();


        //socket;

        try {
            Socket socket = new Socket("localhost",1234);
            Cllient client = new Cllient(socket, usrename);
            client.readMessage();
            client.sendMessage();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }













}
