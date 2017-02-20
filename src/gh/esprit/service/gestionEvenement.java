/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.service;

import gh.esprit.technique.MyConnection;
import gh.esprit.entity.Evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Kyogre
 */
public class gestionEvenement {
    public void ajouterEvenement(Evenement ev) throws SQLException{
        
        String req="insert into evenement(id_admin,object,description,date,adresse,path) values(?,?,?,?,?,?)";
       try{   
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
//        ps.setInt(1,ev.getId_evenement());
        ps.setInt(1,3);
        ps.setString(2,ev.getObject());
        ps.setString(3,ev.getDescription());
        ps.setDate(4,Date.valueOf(ev.getDate()));
        ps.setString(5,ev.getAdresse());
        ps.setString(6,ev.getPath());
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
                    ev.setPath(result.getString(7));
                   
                    ls.add(ev);
                }
    
      
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }
        public void modifierEvenement(Evenement ev){
        String req4="UPDATE `evenement` SET `object`=?,`description`=?,`date`=?,`adresse`=?,`path`=? WHERE id_evenement=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req4);
            
            ps.setString(1,ev.getObject());
            ps.setString(2,ev.getDescription());
            ps.setDate(3,Date.valueOf(ev.getDate()));
            ps.setString(4,ev.getAdresse());
                 ps.setString(5,ev.getPath());
            ps.setInt(6,ev.getId_evenement());
       
            ps.executeUpdate();
            System.out.println("Modifié");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la Modification");
        }
    }
         public String rechercherNomAdmin(int id){
             String nom="" ;
             
            
            String req5="select * FROM admin where id_admin=?";
            try{
               
                    PreparedStatement ps1 =MyConnection.getInstance().prepareStatement(req5);
                    ps1.setInt(1, id);
                ResultSet result = ps1.executeQuery();


            while(result.next()) {
                
            nom=(result.getString(3));
            }
      
                
            }catch(SQLException ex){
                System.out.println("err recherche affich");
            }
            return nom;
            }
      
                public ObservableList<Evenement> rechercheParObjetEvenement(String s){
            ObservableList<Evenement> ls= FXCollections.observableArrayList();
            String req3="select * from evenement where object like ?";
            try{
                 PreparedStatement ps1 =MyConnection.getInstance().prepareStatement(req3);
                    ps1.setString(1, "%"+s+"%");
                ResultSet result = ps1.executeQuery();
                while(result.next()){
                    Evenement ev = new Evenement();
                    ev.setId_evenement(result.getInt(1));
                    ev.setId_admin(result.getInt(2));
                    ev.setObject(result.getString(3));
                    ev.setDescription(result.getString(4));
                    ev.setDate(result.getDate(5).toLocalDate());
                    ev.setAdresse(result.getString(6));
                    ev.setPath(result.getString(7));
                   
                    ls.add(ev);
                }
    
      
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }
                   public ObservableList<Evenement> rechercheParNomAdmin(String s){
                  
                        int id=0 ;
             
            
            String req5="select * FROM admin where nom like ?";
            try{
               
                    PreparedStatement ps1 =MyConnection.getInstance().prepareStatement(req5);
                    ps1.setString(1, "%"+s+"%");
                ResultSet result = ps1.executeQuery();


            while(result.next()) {
                
            id=(result.getInt(1));
            }
      
                
            }catch(SQLException ex){
                System.out.println("err recherche affich");
            }
            
                       
                       
                       
                     
            ObservableList<Evenement> ls= FXCollections.observableArrayList();
            String req3="select * from evenement where id_admin=?";
            try{
                 PreparedStatement ps1 =MyConnection.getInstance().prepareStatement(req3);
                    ps1.setInt(1, id);
                ResultSet result = ps1.executeQuery();
                while(result.next()){
                    Evenement ev = new Evenement();
                    ev.setId_evenement(result.getInt(1));
                    ev.setId_admin(result.getInt(2));
                    ev.setObject(result.getString(3));
                    ev.setDescription(result.getString(4));
                    ev.setDate(result.getDate(5).toLocalDate());
                    ev.setAdresse(result.getString(6));
                    ev.setPath(result.getString(7));
                   
                    ls.add(ev);
                }
    
      
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }
        public ObservableList<Evenement> rechKeyUp(String s){
        ObservableList<Evenement> rs = FXCollections.observableArrayList();
        ObservableList<Evenement> rs2 = FXCollections.observableArrayList();
        
        rs.addAll(this.rechercheParNomAdmin(s));
        rs.addAll(this.rechercheParObjetEvenement(s));
        List<Evenement> rs1 = rs.stream().distinct().collect(Collectors.toList());
        rs1.forEach(e->rs2.add(e));
        
        
        return rs2;
              }     
}
    
