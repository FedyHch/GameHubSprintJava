/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.service;

import gamehub.model.Membre;
import gamehub.technique.MyConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ServiceMembre  {

    
    public void insert(Membre o) {
        String req="INSERT INTO `membre`(`id_membre`, `pseudo`, `nom`, `prenom`, `email`, `password`, `tel`, `etat`, `points`) VALUES (?,?,?,?,?,?,?,?,?)";
    try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, o.getEtat());
            ps.setInt(8, o.getPoints());
            
            ps.executeUpdate();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

   
    public void delete(String Pseudo) {
String req2="DELETE FROM `membre` WHERE pseudo=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req2);
            ps.setString(1, Pseudo);
            ps.executeUpdate();
            System.out.println("supprimé");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la suppression");
        }    }

    
    public ObservableList<Membre> displayAll() {
   ObservableList<Membre> ls= FXCollections.observableArrayList();
            String req3="select * from membre";
            try{
                Statement statement = MyConnection.getInstance().createStatement();
                ResultSet result = statement.executeQuery(req3);
                while(result.next()){
                    Membre membre = new Membre();
                    membre.setId_membre(result.getInt(1));
                    membre.setPseudo(result.getString(2));
                    membre.setNom(result.getString(3));
                    membre.setPrenom(result.getString(4));
                    membre.setEmail(result.getString(5));
                    membre.setPassword(result.getString(6));
                    membre.setTel(result.getInt(7));
                    membre.setEtat(result.getString(8));
                    membre.setPoints(result.getInt(9));
                    ls.add(membre);
                }
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }

    

    public void  update(int id_membre,Membre o) {
        String req="UPDATE `membre` SET `id_membre`=?,`pseudo`=?,`nom`=?,`prenom`=?,`email`=?,`password`=?,`tel`=?,`etat`=?,`points`=? WHERE id_membre=?";
            try{
               PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, o.getEtat());
            ps.setInt(8, o.getPoints());
               
            }catch(SQLException e){
                System.out.println("erreur de modification");
            }
    }
    public void insrice(Membre o){
        String req="INSERT INTO `membre`(`pseudo`, `nom`, `prenom`, `email`, `password`, `tel`, `etat`, `points`) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, "actif");
            ps.setInt(8, 5);
            
            ps.executeUpdate();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Membre findByPseudo(String x) {
               String req="select * from membre where pseudo = ?";
        Membre m = new Membre();
         ObservableList<Membre> lst= FXCollections.observableArrayList();
        try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, x);
            ResultSet res =ps.executeQuery();
            while(res.next()) {
                Membre aa = new Membre();
                 aa.setId_membre((res.getInt(1)));
                 aa.setPseudo((res.getString(2)));
                 aa.setNom((res.getString(3)));
                 aa.setPrenom((res.getString(4)));
                 aa.setEmail((res.getString(5)));
                 aa.setPassword((res.getString(6)));
                 aa.setTel(res.getInt(7));
                 aa.setEtat((res.getString(8)));
                 aa.setPoints((res.getInt(9)));
                 lst.add(aa);
            
            }
            
            m=lst.get(0);
           
            
        }catch(SQLException e){
            System.out.println("err findbyid()");
        }
        return m;
    }
    }
 


    
    

