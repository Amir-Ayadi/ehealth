/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Ayadi
 */
public class PersonneService implements Iservice<Personne>{

    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PersonneService() {
        connexion = DataSource.getInstance().getCnx();

    }

    @Override
    public void insert(Personne p) {
        String requete = "insert into personne (id,nom,prenom) values ('" + p.getId() + "','" + p.getNom() + "','" + p.getPrenom() + "')";

        try {
            ste = connexion.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertPST(Personne p) {
        String requete = "insert into personne (id,nom,prenom) values(?,?,?)";

        try {
            pst = connexion.prepareStatement(requete);
             pst.setInt(1, p.getId());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public List<Personne> readAll(){
        String requete="select * from personne";
        List<Personne> list=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                Personne p=new Personne(rs.getInt("id"), rs.getString(2), rs.getString("prenom"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Personne readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
