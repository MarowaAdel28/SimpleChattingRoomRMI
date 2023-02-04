package gov.iti.client;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Clients {

    List <ClientHandler> clients;
    OutputStream outStream;

    public Clients() {
        clients = new ArrayList<>();
    }

    public void addNewClient(ClientHandler client) {
        clients.add(client);
    }

    public void sentMsg(String msg, ClientHandler client) {
        try (OutputStream outStream = client.getClientSocket().getOutputStream()) {

            PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);

            out.println(msg);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    } 

    public void sentBroadCastMsg(String msg) {
        for(ClientHandler client: clients) {
            sentMsg(msg, client);
        }
    }

    
}
