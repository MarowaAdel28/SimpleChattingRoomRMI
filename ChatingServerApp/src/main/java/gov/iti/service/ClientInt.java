package gov.iti.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInt extends Remote {

    void receive(String msg) throws RemoteException;
}
