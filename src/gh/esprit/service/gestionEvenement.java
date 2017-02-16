/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.service;

import gh.esprit.technique.MyConnection;
import gh.esprit.entity.Evenement;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Kyogre
 */
public class gestionEvenement {
    public void ajouterEvenement(Evenement ev) throws SQLException{
        
        String req="insert into evenement(id_admin,object,description,date,adresse) values(?,?,?,?,?)";
       try{   
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
//        ps.setInt(1,ev.getId_evenement());
        ps.setInt(1,ev.getId_admin());
        ps.setString(2,ev.getObject());
        ps.setString(3,ev.getDescription());
        ps.setDate(4,Date.valueOf(ev.getDate()));
        ps.setString(5,ev.getAdresse());
        ps.executeUpdate();
           System.out.println("Ajout effectué avec success");
        
       }catch(Exception e){e.printStackTrace();}
    
    }
 public void supprimerEvenement(String s){
        String req2="delete from Evenement where object=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req2);
            ps.setString(1, s);
            ps.executeUpdate();
            System.out.println("supprimé");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la suppression");
        }
    }
        public ObservableList<Evenement> afficherEvenement(){
            ObservableList<Evenement> ls= FXCollections.observableArrayList();
            String req3="select * from evenement";
            try{
                Statement statement = MyConnection.getInstance().createStatement();
                ResultSet result = statement.executeQuery(req3);
                while(result.next()){
                    Evenement ev = new Evenement();
                    ev.setId_evenement(result.getInt(1));
                    ev.setId_admin(result.getInt(2));
                    ev.setObject(result.getString(3));
                    ev.setDescription(result.getString(4));
                    ev.setDate(result.getDate(5).toLocalDate());
                    ev.setAdresse(result.getString(6));
                   
                    ls.add(ev);
                }
    
      
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }
        public void modifierEvenement(Evenement ev){
        String req4="UPDATE `evenement` SET `object`=?,`description`=?,`date`=?,`adresse`=? WHERE id_evenement=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req4);
            
            ps.setString(1,ev.getObject());
            ps.setString(2,ev.getDescription());
            ps.setDate(3,Date.valueOf(ev.getDate()));
            ps.setString(4,ev.getAdresse());
            ps.setInt(5,ev.getId_evenement());
            ps.executeUpdate();
            System.out.println("Modifié");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la Modification");
        }
    }
        
}
    
