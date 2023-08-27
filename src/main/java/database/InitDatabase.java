package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class InitDatabase implements ServletContextListener {

    //parametres de connexion
    Connection connection=null;

    //action déclenchée lors du chargement du context
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        System.out.println("----------- Contexte initialisé -----------");

        //lire le contexte
        ServletContext servletContext=event.getServletContext();

        try
        {
            //chargement du driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Pilote MARIADB JDBC chargé");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors du chargemement du pilote.....");
        }

        try
        {
            //obtention de la connexion
            connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/cheval","root","");
            //sauvegarder la connexion dans le context
            servletContext.setAttribute("connection",connection);
            System.out.println("jdbc:mysql://localhost:3306 - connexion ");
        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }
    }

    //action qui permet de détruire le filtre
    public void contextDestroyed(ServletContextEvent event)
    {
        System.out.println("----------- Contexte détruit -----------");
        try
        {
            //fermeture
            System.out.println("Connexion fermée");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //fermeture de la connexion
            //truc.fermerConnexion(connection);
        }
    }


}