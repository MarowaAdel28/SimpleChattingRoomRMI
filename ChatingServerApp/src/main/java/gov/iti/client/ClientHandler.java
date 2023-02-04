package gov.iti.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {

    Socket socket;
    InputStream inStream;
    OutputStream outStream;
    static List <ClientHandler> clients = new ArrayList<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
        clients.add(this);
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            inStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
            while (true) {
                while(in.ready()) { 
                    String line = in.readLine(); 
                    System.out.println(line);
                    sentBroadCastMsg(line);
                    //new Thread(()->clients.sentBroadCastMsg(line)).start();
                }
            }   

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
            System.out.println("finally");
        }

    }

    public Socket getClientSocket() {
        return socket;
    }

public void sentMsg(String msg, ClientHandler client) {
    try {

        outStream = client.getClientSocket().getOutputStream();

        PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);

        out.println(msg);
        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    } 
} 

public void sentBroadCastMsg(String msg) {

    new Thread(()-> {
        for(ClientHandler client: clients) {
            if(client==this) continue;
            sentMsg(msg, client);
        }
    }).start();
}
}



// thread for each client
// list of runnable
// send message 
