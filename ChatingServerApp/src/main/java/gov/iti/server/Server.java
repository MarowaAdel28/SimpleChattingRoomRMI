package gov.iti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import gov.iti.client.*;
import gov.iti.service.ChatServerImpl;

public class Server {
/* 
    private ServerSocket serverSocket ;
    Socket socket;
    boolean closed=false;
    */
    BufferedReader buffer;

    public void startServer(){

        try{
            buffer= new BufferedReader(new InputStreamReader(System.in));
            ChatServerImpl obj= new ChatServerImpl();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("ChatService", obj);
            //System.out.println("start server");
        } catch(RemoteException ex) { 
            ex.printStackTrace();
        }
        while (true) { 
            try {
                String text = buffer.readLine().trim();
                if (text.equals("-1")) break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /* 
        try{
            serverSocket = new ServerSocket(1299);
            while(!serverSocket.isClosed()){
                System.out.println("waitting new client");
                socket = serverSocket.accept();
                System.out.println("A new Client Connected");
                ClientHandler clientHandler  = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
            System.out.println("refause connection");
        }catch( IOException e){
            e.printStackTrace();
        }
        */
    }

    public void closeServer(){
        System.exit(0);
    }

    /* 
    public void closeServer(){
        try{
            if(serverSocket != null && !serverSocket.isClosed()){
                //socket.close();
            
                serverSocket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

*/
}

