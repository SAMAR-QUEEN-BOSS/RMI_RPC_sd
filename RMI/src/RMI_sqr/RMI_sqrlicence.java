package RMI_sqr;

import java.io.Serializable;

public class RMI_sqrlicence implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nom;
    private String ligue;

    public RMI_sqrlicence(int id, String nom, String ligue) {
        this.id = id;
        this.nom = nom;
        this.ligue = ligue;
    }

    public int getID() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getLigue() { return ligue; }
    public void setLigue(String ligue) { this.ligue = ligue; }
}
