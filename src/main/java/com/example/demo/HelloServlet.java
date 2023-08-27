package com.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DAOCheval;

import database.DAOClient;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cheval;
import model.Client;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    Connection connection;

    public void init() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Pilote MARIADB JDBC chargé");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cheval", "root", "");
            System.out.println("Connexion opérationnelle projet Equida" + "jdbc:mysql://localhost:3306/cheval");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Cheval> lesChevaux = DAOCheval.getLesChevals(connection);
        ArrayList<Client> lesClients = DAOClient.getLesClients(connection);
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("" +
                "<table>\n" +
                "  <caption>\n" +
                "    <h1>Liste des chevaux</h1>\n" +
                "  </caption>\n");
        out.println("" +
                "  <tr>\n" +
                "    <th scope=\"col\">Nom du cheval</th>\n" +
                "    <th scope=\"col\">Race du cheval</th>\n" +
                "    <th scope=\"col\">Sexe</th>\n" +
                "    <th scope=\"col\">Date de naissance</th>\n" +
                "    <th scope=\"col\">Description de la race</th>\n" +
                "  </tr>\n");
        lesChevaux.forEach((cheval)->{
            out.println("" +
                    "  <tr>\n" +
                    "    <th scope=\"col\">"+cheval.getNom()+"</th>\n" +
                    "    <th scope=\"col\">"+cheval.getRace().getNom()+"</th>\n" +
                    "    <th scope=\"col\">"+cheval.getSex()+"</th>\n" +
                    "    <th scope=\"col\">"+cheval.getBirthday()+"</th>\n" +
                    "    <th scope=\"col\">"+cheval.getRace().getDescription()+"</th>\n" +
                    "  </tr>\n");
        });
        out.println("</table>");
        out.println("" +
                "<table>\n" +
                "  <caption>\n" +
                "    <h1>Liste des clients</h1>\n" +
                "  </caption>\n");
        out.println("" +
                "  <tr>\n" +
                "    <th scope=\"col\">Identifiant</th>\n" +
                "    <th scope=\"col\">Nom</th>\n" +
                "    <th scope=\"col\">Prenom</th>\n" +
                "    <th scope=\"col\">Ville</th>\n" +
                "    <th scope=\"col\">Rue</th>\n" +
                "    <th scope=\"col\">Code postal</th>\n" +
                "    <th scope=\"col\">Adresse mail</th>\n" +
                "  </tr>\n");
        lesClients.forEach((client)->{
            out.println("" +
                    "  <tr>\n" +
                    "    <th scope=\"col\">"+client.getId()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getNom()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getPrenom()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getVille()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getRue()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getCopos()+"</th>\n" +
                    "    <th scope=\"col\">"+client.getAdresseMessagerie()+"</th>\n" +
                    "  </tr>\n");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}