package server;

import java.rmi.Naming;

public class Serveur {
	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.hostname", "192.168.175.122");// Explicitly set hostname
			remote.BaseExportee base = new remote.BaseExportee();
			Naming.rebind("//192.168.175.122:1099/BaseLicencies", base);
			System.out.println("Server is ready.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
