package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Cheval {

    private int id;
    private String nom;
    private String sex;
    private String birthday;
    private RaceCheval race;
    private ArrayList<Participer> mesCourses = new ArrayList<Participer>();



    public Cheval(){

    }

     public Cheval(String nom, String sex, String birthday, RaceCheval race) {
        this.race = race;
        this.nom = nom;
        this.sex = sex;
        this.birthday= birthday;
     }

     public int getId() {
        return id;
     }

     public String getNom() {
        return nom;
     }

     public String getSex() {
        return sex;
     }

     public String getBirthday() {
        return birthday;
     }

     public RaceCheval getRace() {
        return race;
     }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setRace(RaceCheval race) {
        this.race = race;
    }

    public ArrayList<Participer> getMesCourses() {
        return mesCourses;
    }

    public void setMesCourses(ArrayList<Participer> mesCourses) {
        this.mesCourses = mesCourses;
    }

    public void ajouterUneCourse(Participer uneCourse){
        this.mesCourses.add(uneCourse);
    }
}
