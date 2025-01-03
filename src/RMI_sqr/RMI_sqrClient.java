package RMI_sqr;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMI_sqrClient {
	    public static void main(String[] args) {
	        try {
	        	RMI_sqrinterface base = (RMI_sqrinterface) Naming.lookup("//localhost:7777/rmi_sqrlicence");

	            int id1 = base.ajouteLicencie("asma", "Football");
	            int id2 = base.ajouteLicencie("samar", "Basketball");

	            RMI_sqrlicence licencie1 = base.getLicencie(id2);
	            System.out.println("Before update: " + licencie1.getNom());
	            
	            licencie1.setNom("Alicia");
	            base.effaceLicencie(id1); // Test removing
	            
	            RMI_sqrlicence updated = base.getLicencie(id1);
	            System.out.println("After update: " + (updated != null ? updated.getNom() : "Not Found"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
