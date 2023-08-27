package model;

public class Acheteur extends Client{

    public int datePremiereAchat;
    public Acheteur(){
        super();
    }

    public int getDatePremiereAchat() {
        return datePremiereAchat;
    }
    public void setDatePremiereAchat(int datePremiereAchat) {
        this.datePremiereAchat = datePremiereAchat;
    }
}
