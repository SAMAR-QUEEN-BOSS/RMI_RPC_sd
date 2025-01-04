package RMI_sqr;

import java.rmi.Naming;

public class RMI_sqrClient {
public static void main(String[] args) {
    try {
        // Lookup the remote object
        RMI_sqrinterface server = (RMI_sqrinterface) Naming.lookup("rmi://localhost:1125/rmi_sqrlicence");
        
        // Call methods remotely
        double square = server.getSquare(5);
        double squareRoot = server.getSquareRoot(25);
        
        System.out.println("Square: " + square);
        System.out.println("Square Root: " + squareRoot);
        
        // Test the license methods
        int id = server.ajouteLicencie("Samar Bendris", "League A");
        System.out.println("Licencie added with ID: " + id);
        
        RMI_sqrlicence licencie = server.getLicencie(id);
        System.out.println("Licencie Info: " + licencie.getNom() + ", " + licencie.getLigue());
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	}
