package model;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private String nom;
    private String lieu;
    private String date;
    private ArrayList<Participer> participants = new ArrayList<Participer>();


    public Course(){

    }
    public ArrayList<Participer> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participer> participants) {
        this.participants = participants;
    }


    public void ajouterUnParticipant(Participer unParticipant){
        this.participants.add(unParticipant);
    }
}
