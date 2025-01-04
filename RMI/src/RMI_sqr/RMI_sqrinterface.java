// Source code is decompiled from a .class file using FernFlower decompiler.
package RMI_sqr;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_sqrinterface extends Remote {
    int ajouteLicencie(String var1, String var2) throws RemoteException;

    void effaceLicencie(int var1) throws RemoteException;

    RMI_sqrlicence getLicencie(int var1) throws RemoteException;
}
