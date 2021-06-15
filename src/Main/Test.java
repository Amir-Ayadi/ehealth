/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import entite.Personne;
import java.sql.SQLException;
import utils.DataSource;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.logging.Level;
import java.util.logging.Logger;
import service.PersonneService;

/**
 *
 * @author Ayadi
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void insertPersonne(Personne p) {
        String requete = "insert into personne (id,nom,prenom) values ('" + p.getId() + "','" + p.getNom() + "','" + p.getPrenom() + "')";
        try {
            Connection connection = DataSource.getInstance().getCnx();
            Statement ste = connection.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertPersonnePST(Personne p) {
        String requete = "insert into personne (id,nom,prenom) values (?,?,?)";
        Connection connection = DataSource.getInstance().getCnx();
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNom());           
            pst.setString(3, p.getPrenom());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
         //TODO code application logic here
        DataSource ds1=DataSource.getInstance();
        System.out.println(ds1);
        DataSource ds2=DataSource.getInstance();
        System.out.println(ds2);
        DataSource ds3=DataSource.getInstance();
        System.out.println(ds3);
        
        DataSource x =DataSource.getInstance();

        Personne p = new Personne(1,"test1", "test1");
        Personne p1 = new Personne(1,"test3", "test3");

        //insertPersonne(p);
        
        PersonneService ps=new PersonneService();
        //ps.insert(p);
        //ps.insertPST(p1);

        ps.readAll().forEach(System.out::println);
        


//DataSource x =DataSource.getInstance();
    }

}
