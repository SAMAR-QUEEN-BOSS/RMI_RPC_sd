package RMI_sqr;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_sqrinterface extends Remote {
	int ajouteLicencie(String nom, String ligue) throws RemoteException;
    void effaceLicencie(int id) throws RemoteException;
    RMI_sqrlicence getLicencie(int id) throws RemoteException;
}
