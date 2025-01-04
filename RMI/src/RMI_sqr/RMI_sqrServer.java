package RMI_sqr;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class RMI_sqrServer extends UnicastRemoteObject implements RMI_sqrinterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nextId = 1;
	private HashMap<Integer, RMI_sqrlicence> licencies = new HashMap<>();
	public RMI_sqrServer() throws RemoteException {
		super();
		
	}

	public double getSquare(double input) throws RemoteException {
		return input * input;
	}

	public double getSquareRoot(double input) throws RemoteException {
		return Math.sqrt(input);
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		try {
			Registry registry = LocateRegistry.createRegistry(1125);//connecting the server
			System.setSecurityManager(new SecurityManager());
			registry.bind("rmi_sqrlicence", new RMI_sqrServer());
			System.out.println("server okay");//if  the server work
		}catch(Exception e) {
			System.out.println("server not okay");//if  the server dosent work
		}
	}

	@Override
	public int ajouteLicencie(String nom, String ligue) throws RemoteException {
		RMI_sqrlicence licencie = new RMI_sqrlicence(nextId, nom, ligue);
        licencies.put(nextId, licencie);
        return nextId++;
	}

	@Override
	public void effaceLicencie(int id) throws RemoteException {
		licencies.remove(id);
	}

	@Override
	public RMI_sqrlicence getLicencie(int id) throws RemoteException {
		return licencies.get(id);
	}
}
