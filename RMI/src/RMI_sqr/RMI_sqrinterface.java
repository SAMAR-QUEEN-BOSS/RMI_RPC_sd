package RMI_sqr;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_sqrinterface extends Remote {

    // Remote methods
    double getSquare(double input) throws RemoteException;
    double getSquareRoot(double input) throws RemoteException;
    
    int ajouteLicencie(String nom, String ligue) throws RemoteException;
    void effaceLicencie(int id) throws RemoteException;
    RMI_sqrlicence getLicencie(int id) throws RemoteException;
}
