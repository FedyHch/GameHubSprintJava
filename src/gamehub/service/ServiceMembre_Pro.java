/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.service;

import gamehub.model.Admin;
import gamehub.model.Membre_pro;
import gamehub.technique.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ServiceMembre_Pro {

    
    public void insert(Membre_pro o) {
    String req="INSERT INTO `membre_pro`(`id_admin`, `pseudo`, `nom`, `prenom`, `email`, `password`, `tel`, `etat`, `rpoints`,) VALUES (?,?,?,?,?,?,?,?,?)";
    try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, o.getEtat());
            ps.setInt(8, o.getRpoints());
            
            ps.executeUpdate();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }    }

   
    public void delete(String Pseudo) {
String req2="DELETE FROM `membre_pro` WHERE pseudo=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req2);
            ps.setString(1, Pseudo);
            ps.executeUpdate();
            System.out.println("supprimé");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la suppression");
        }       }

  
    public ObservableList<Membre_pro> displayAll() {
           ObservableList<Membre_pro> ls= FXCollections.observableArrayList();
            String req3="select * from membre_pro";
            try{
                Statement statement = MyConnection.getInstance().createStatement();
                ResultSet result = statement.executeQuery(req3);
                while(result.next()){
                    Membre_pro mpro = new Membre_pro();
                    mpro.setId_mpro(result.getInt(1));
                    mpro.setPseudo(result.getString(2));
                    mpro.setNom(result.getString(3));
                    mpro.setPrenom(result.getString(4));
                    mpro.setEmail(result.getString(5));
                    mpro.setPassword(result.getString(6));
                    mpro.setTel(result.getInt(7));
                    mpro.setEtat(result.getString(8));
                    mpro.setRpoints(result.getInt(9));
                    ls.add(mpro);
                }
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return  ls;
    }

    

    
    public void update(int id_mpro,Membre_pro o) {
        String req="UPDATE `membre_pro` SET `id_mpro`=?,`pseudo`=?,`nom`=?,`prenom`=?,`email`=?,`password`=?,`tel`=?,`etat`=?,`rpoints`=? WHERE id_mpro=?";
            try{
               PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, o.getEtat());
            ps.setInt(8, o.getId_mpro());
               
            }catch(SQLException e){
                System.out.println("erreur de modification");
            }
    }
    public Membre_pro findByPseudo(String x) {
               String req="select * from membre_pro where pseudo = ?";
        Membre_pro mp = new Membre_pro();
         ObservableList<Membre_pro> lst= FXCollections.observableArrayList();
        try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, x);
            ResultSet res =ps.executeQuery();
            while(res.next()) {
                Membre_pro aa = new Membre_pro();
                 aa.setId_mpro((res.getInt(1)));
                 aa.setPseudo((res.getString(2)));
                 aa.setNom((res.getString(3)));
                 aa.setPrenom((res.getString(4)));
                 aa.setEmail((res.getString(5)));
                 aa.setPassword((res.getString(6)));
                 aa.setTel(res.getInt(7));
                 aa.setEtat((res.getString(8)));
                 aa.setRpoints((res.getInt(9)));
                 lst.add(aa);
            
            }
            
            mp=lst.get(0);
           
            
        }catch(SQLException e){
            System.out.println("err findbyid()");
        }
        return mp;
    }
    
}
