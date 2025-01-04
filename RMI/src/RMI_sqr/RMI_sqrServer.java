// Source code is decompiled from a .class file using FernFlower decompiler.
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
    private HashMap<Integer, RMI_sqrlicence> licencies = new HashMap();

    public RMI_sqrServer() throws RemoteException {
    }

    public double getSquare(double var1) throws RemoteException {
        return var1 * var1;
    }

    public double getSquareRoot(double var1) throws RemoteException {
        return Math.sqrt(var1);
    }

    public static void main(String[] var0) throws RemoteException, AlreadyBoundException {
        try {
            Registry var1 = LocateRegistry.createRegistry(1125);
            System.setSecurityManager(new SecurityManager());
            var1.bind("rmi_sqrlicence", new RMI_sqrServer());
            System.out.println("server okay");
        } catch (Exception var2) {
            System.out.println("server not okay");
        }

    }

    public int ajouteLicencie(String var1, String var2) throws RemoteException {
        RMI_sqrlicence var3 = new RMI_sqrlicence(this.nextId, var1, var2);
        this.licencies.put(this.nextId, var3);
        return this.nextId++;
    }

    public void effaceLicencie(int var1) throws RemoteException {
        this.licencies.remove(var1);
    }

    public RMI_sqrlicence getLicencie(int var1) throws RemoteException {
        return (RMI_sqrlicence) this.licencies.get(var1);
    }
}
