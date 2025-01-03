package RMI_sqr;

import java.rmi.Naming;

public class RMI_sqrClient {
	    public static void main(String[] args) {
	        try {
	        	RMI_sqrinterface base = (RMI_sqrinterface) Naming.lookup("//localhost:1125/rmi_sqrlicence");

	            int id1 = base.ajouteLicencie("asma", "Football");
	            int id2 = base.ajouteLicencie("samar", "Basketball");

	            RMI_sqrlicence licencie1 = base.getLicencie(id2);
	            System.out.println("Before update: " + licencie1.getNom());
	            
	            licencie1.setNom("Alicia");
	            base.effaceLicencie(id1); // Test removing
	            
	            RMI_sqrlicence updated = base.getLicencie(id2);
	            System.out.println("After update: " + (updated != null ? updated.getNom() : "Not Found"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
