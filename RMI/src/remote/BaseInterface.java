package remote;

import licence.Licencie;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BaseInterface extends Remote {
	int ajouteLicencie(String nom, String ligue) throws RemoteException;

	void effaceLicencie(int id) throws RemoteException;

	Licencie getLicencie(int id) throws RemoteException;
}
