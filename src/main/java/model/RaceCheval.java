package model;

import java.util.ArrayList;

public class RaceCheval {

    private String nom;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String libelle;
    private String description;

    private ArrayList<Cheval> lesChevals = new ArrayList<Cheval>();


    public RaceCheval(String nom, String libelle, String description){
        this.nom=nom;
        this.libelle=libelle;
        this.description=description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void addCheval(Cheval cheval){
        lesChevals.add(cheval);
    }
}
