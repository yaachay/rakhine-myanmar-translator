package application.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TranslatorService extends Remote{

	String translateRK2MY(String text) throws RemoteException; 
	String translateMY2RK(String text) throws RemoteException;

}
