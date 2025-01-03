package remote;

import licence.Licencie;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

public class BaseExportee extends UnicastRemoteObject implements BaseInterface {
	private HashMap<Integer, Licencie> licencies;
	private int nextId = 1;

	public BaseExportee() throws RemoteException {
		licencies = new HashMap<>();
	}

	public int ajouteLicencie(String nom, String ligue) throws RemoteException {
		Licencie licencie = new Licencie(nextId, nom, ligue);
		licencies.put(nextId, licencie);
		return nextId++;
	}

	public void effaceLicencie(int id) throws RemoteException {
		licencies.remove(id);
	}

	public Licencie getLicencie(int id) throws RemoteException {
		return licencies.get(id);
	}
}
