package database;

import model.Cheval;
import model.Client;
import model.RaceCheval;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

public class DAOClient {

    Connection connection = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static ArrayList<Client> getLesClients(Connection connection){
        ArrayList<Client> lesClients = new ArrayList<Client>();
        try{
            //preparation de la requete
            requete = connection.prepareStatement("SELECT * FROM client;");
            System.out.println("Requete" + requete);

            //executer la requete
            rs=requete.executeQuery();

            while ( rs.next() ) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setPrenom(rs.getString("prenom"));
                client.setNom(rs.getString("nom"));
                client.setVille(rs.getString("ville"));
                client.setRue(rs.getString("rue"));
                client.setCopos(rs.getString("copos"));
                client.setAdresseMessagerie(rs.getString("adresseMessagerie"));
                lesClients.add(client);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesClients ;

    }
}
