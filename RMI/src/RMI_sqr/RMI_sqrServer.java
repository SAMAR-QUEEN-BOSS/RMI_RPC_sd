package RMI_sqr;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class RMI_sqrServer extends UnicastRemoteObject implements RMI_sqrinterface {

    private static final long serialVersionUID = 1L;
    private int nextId = 1;
    private HashMap<Integer, RMI_sqrlicence> licencies = new HashMap<>();

    public RMI_sqrServer() throws RemoteException {
        super();
    }

    // Remote method to return square of a number
    public double getSquare(double input) throws RemoteException {
        return input * input;
    }

    // Remote method to return square root of a number
    public double getSquareRoot(double input) throws RemoteException {
        return Math.sqrt(input);
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

    public static void main(String[] args) {
        try {
            // This line is necessary only if rmiregistry is not running
            Registry registry = LocateRegistry.createRegistry(1125);
            // System.out.println("RMI registry started on port 1125");
            
            // Create the server instance
            RMI_sqrServer server = new RMI_sqrServer();
            
            // Bind the server object to the RMI registry
            //Registry registry = LocateRegistry.getRegistry(1125); // Get reference to existing registry
            registry.bind("rmi_sqrlicence", server);
            System.out.println("RMI Server is running...");
            
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Server failed to start: " + e);
            e.printStackTrace();
        }
    }
}
