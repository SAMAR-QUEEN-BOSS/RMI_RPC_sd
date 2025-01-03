package client;

import remote.BaseInterface;
import licence.Licencie;
import java.rmi.Naming;

public class Client {
	public static void main(String[] args) {
		try {
			BaseInterface base = (BaseInterface) Naming.lookup("BaseLicencies");

			int id1 = base.ajouteLicencie("Alice", "Football");
			int id2 = base.ajouteLicencie("Bob", "Basketball");

			Licencie licencie1 = base.getLicencie(id1);
			System.out.println("Before update: " + licencie1.getNom());

			licencie1.setNom("Alicia");
			base.effaceLicencie(id1);

			Licencie updated = base.getLicencie(id1);
			System.out.println("After update: " + (updated != null ? updated.getNom() : "Not Found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
