package licence;

import java.io.Serializable;

public class Licencie implements Serializable {
	private int id;
	private String nom;
	private String ligue;

	public Licencie(int id, String nom, String ligue) {
		this.id = id;
		this.nom = nom;
		this.ligue = ligue;
	}

	public int getID() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLigue() {
		return ligue;
	}

	public void setLigue(String ligue) {
		this.ligue = ligue;
	}
}
