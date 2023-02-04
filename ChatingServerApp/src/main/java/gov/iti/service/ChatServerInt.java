package gov.iti.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInt extends Remote {

void tellOthers(String msg,  ClientInt sender) throws RemoteException;

void register(ClientInt clientRef) throws RemoteException;

void unRegister(ClientInt clientRef) throws RemoteException;

}