package RMI_sqr;

import java.rmi.Naming;
import java.util.Scanner;

public class RMI_sqrClient {
	    public static void main(String[] args) {
	        try {ava.
				Scanner scanner = new Scanner(System.in);
	        	RMI_sqrinterface base = (RMI_sqrinterface) Naming.lookup("//localhost:1125/rmi_sqrlicence");
//this are the data informations
	            int id1 = base.ajouteLicencie("asma", "Football");
	            int id2 = base.ajouteLicencie("samar", "Basketball");
				int id3 = base.ajouteLicencie("arij", "Tenis");
	            int id4 = base.ajouteLicencie("hadjer", "Basketball");
				int id5 = base.ajouteLicencie("ebra", "handball");
	            int id6 = base.ajouteLicencie("amel", "Badminton");

	            System.out.print("Enter ID to get Licencie: ");//asking the user to inter the id og the prsn to see his licence
            	int id1 = scanner.nextInt();
            	scanner.nextLine();
				RMI_sqrlicence licencie1 = base.getLicencie(id1);
	            if (licencie1 != null) {
					System.out.println("Before update: " +  licencie1.getNom() + ", Sport = " + licencie1.getSport());//getting the name
	
					System.out.print("Enter new name: ");//asking the user to enter a new name
					String newName = scanner.nextLine();
					licencie1.setNom(newName);
	
					base.effaceLicencie(id1); // Test removing
	
					RMI_sqrlicence updated = base.getLicencie(id1);
					System.out.println("After update: " + (updated != null ? updated.getNom() : "Not Found"));//getting the name
				} else {
					System.out.println("Licencié not found.");
				}

	            scanner.close();
	           
			} catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
