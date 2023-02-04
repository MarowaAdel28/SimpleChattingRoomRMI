package gov.iti.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ChatServerImpl extends UnicastRemoteObject implements ChatServerInt {

    Vector<ClientInt> clientsVector = new Vector<ClientInt>();

    public ChatServerImpl() throws RemoteException { 

    }

    public void register(ClientInt clientRef) {

        clientsVector.add(clientRef);
        System.out.println("Client added");
    }

    public void unRegister(ClientInt clientRef) {

        clientsVector.remove(clientRef);
        System.out.println("Client removed");
    }
    
    public void tellOthers(String msg, ClientInt sender) {

        System.out.println("Messge received: "+msg);

        for(ClientInt clientRef : clientsVector) {
            if(!clientRef.equals(sender)) {
                try {
                    clientRef.receive(msg);
    
                } catch(RemoteException ex) {
    
                    System.out.println("Can't send msg to client!");
                    ex.printStackTrace();
                }
            }
            
        }
    }
}
