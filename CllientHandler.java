

import java.io.*;
import java.net.*;
import java.util.*;

public class CllientHandler implements Runnable{

        // create an Arraylist for the clients
    public static ArrayList<CllientHandler> cllientHandlers = new ArrayList<>();
    private Socket socket ;
    private BufferedReader bufferedReader ;
    private BufferedWriter bufferedWriter ;
    private String clientUsername ;

    public CllientHandler(Socket socket) {
        try {
            this.socket = socket ;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            cllientHandlers.add(this);

            broadcastMassage("SERVER: "+clientUsername + " has entered the chat.");

        } catch (IOException e) {
            closeEverything(socket,bufferedReader, bufferedWriter);
        }
    }





    @Override
    public void run() {
        String messageFromClient  ;

        while(socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine(); //For receiving massage from friends
                broadcastMassage(messageFromClient);   // For sending message to friends
            }
            catch (IOException e) {
                closeEverything(socket,bufferedReader,bufferedWriter);
                break;

            }

        }

    }

    public void broadcastMassage(String messageToSend) {    // Method for sent Message
        for(CllientHandler cllientHandler : cllientHandlers) {
            try {
                if(!cllientHandler.clientUsername.equals(clientUsername)) {
                    cllientHandler.bufferedWriter.write(messageToSend);
                    cllientHandler.bufferedWriter.newLine();
                    cllientHandler.bufferedWriter.flush();
                }
            }
            catch (IOException e) {
                closeEverything(socket,bufferedReader,bufferedWriter);

            }
        }
    }


    public void closeEverything(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter) {
                // Method for close Everything.
        cllientHandlers.remove(this);
        broadcastMassage("SERVER: "+clientUsername + " has left the chat.");

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








}

