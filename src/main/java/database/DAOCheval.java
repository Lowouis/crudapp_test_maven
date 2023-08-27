package database;
import model.Cheval;
import model.RaceCheval;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DAOCheval {

    Connection connection = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static ArrayList<Cheval> getLesChevals(Connection connection){
        ArrayList<Cheval> lesChevals = new ArrayList<Cheval>();
        try{
            //preparation de la requete
            requete = connection.prepareStatement("SELECT cheval.*, racecheval.* FROM cheval INNER JOIN racecheval ON cheval.id = racecheval.id;;");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
                while ( rs.next() ) {
                    Cheval Cheval = new Cheval();
                    Cheval.setId(rs.getInt("id"));
                    Cheval.setNom(rs.getString("nom"));
                    Cheval.setSex(Objects.equals(rs.getString("sex"), "1") ? "Femelle" : "Mâle");
                    Cheval.setBirthday(rs.getString("birthday"));
                    Cheval.setRace(new RaceCheval(rs.getString("RACECHEVAL.nom"), rs.getString("libelle"), rs.getString("description")));
                    lesChevals.add(Cheval);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesChevals ;

    }
}
