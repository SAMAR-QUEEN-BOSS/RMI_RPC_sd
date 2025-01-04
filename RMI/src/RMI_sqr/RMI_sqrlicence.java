// Source code is decompiled from a .class file using FernFlower decompiler.
package RMI_sqr;

import java.io.Serializable;

public class RMI_sqrlicence implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nom;
    private String ligue;

    public RMI_sqrlicence(int var1, String var2, String var3) {
        this.id = var1;
        this.nom = var2;
        this.ligue = var3;
    }

    public int getID() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String var1) {
        this.nom = var1;
    }

    public String getLigue() {
        return this.ligue;
    }

    public void setLigue(String var1) {
        this.ligue = var1;
    }
}
