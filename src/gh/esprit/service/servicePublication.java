/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.service;

import gh.esprit.model.Publication;
import gh.esprit.technique.MyConnection;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public class servicePublication {
    private static servicePublication instance;
    
    public void ajouterPublication(Publication p){
        String req="insert into publication (id_chaine,text,type,titre,url,jaimes) values(?,?,?,?,?,?);";
        try {
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            //ps.setInt(1,p.getId_pub());
            ps.setInt(1,p.getId_chaine());
            ps.setString(2,p.getText());
            ps.setString(3,p.getType());
            ps.setString(4,p.getTitre());
            ps.setString(5,p.getUrl());
            ps.setInt(6,p.getJaimes());
            ps.executeUpdate();
                
        } catch (SQLException e) {
            System.out.println("erreur ajout"+e.getMessage());
        }
    }
    public ObservableList<Publication> afficherPublication(){        
        String req2="select * from publication";
        ObservableList<Publication> list=FXCollections.observableArrayList();
        try {
            PreparedStatement ste = MyConnection.getInstance().prepareStatement(req2);  
            ResultSet res = ste.executeQuery();
            while (res.next()) {
                Publication p = new Publication();
                p.setId_pub(res.getInt(1));
                p.setId_chaine(res.getInt(2));
                p.setText(res.getString(3));
                p.setType(res.getString(4));
                p.setTitre(res.getString(5));
                p.setUrl(res.getString(6));
                p.setJaimes(res.getInt(7)); 
                list.add(p);
            }        
            return list;    
        } catch (SQLException e) {
            System.out.println("erreur d'affichage"+e.getMessage());
        }
        return null;
    }   
    
    public void supprimerPublication(int x){
        String req ="delete from publication where id_pub=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1,x);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("erreur de suppression"+e.getMessage());
        }      
    }
    public void modifierPublication (int x,int m1,String m2 ,String m3 ,String m4, String m5 ,int m6){
        Publication p ;
        
        String req="UPDATE publication SET id_chaine=?,text=?,type=?,titre=?,url=?,jaimes=? WHERE id_pub=? ";
        try {
            PreparedStatement ps =MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1,m1);
            ps.setString(2,m2);
            ps.setString(3,m3);
            ps.setString(4,m4);
            ps.setString(5,m5);
            ps.setInt(6,m6);
            ps.setInt(7, x);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur "+e.getMessage());
        }
        
    } 
    public static servicePublication getInstance(){
        if(instance==null) 
            instance=new servicePublication();
        return instance;
    }
}