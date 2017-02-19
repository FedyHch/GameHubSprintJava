/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.service;

import gamehub.model.Admin;
import gamehub.technique.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ServiceAdmin  {
private static ServiceAdmin instance;
    private Statement st;
    private ResultSet rs;
    
    public ServiceAdmin() {
    Connection conn= MyConnection.getInstance();      
    try {
            Statement st = MyConnection.getInstance().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ServiceAdmin getInstance(){
        if(instance==null) 
            instance=new ServiceAdmin();
        return instance;
    }

  
    
    public void insert(Admin o) {
        String req="INSERT INTO `admin`(`pseudo`, `nom`, `prenom`, `email`, `password`, `tel`, `etat`, `salaire`,`date_creation`) VALUES (?,?,?,?,?,?,?,?,?)";
    try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, o.getEtat());
            ps.setInt(8, o.getSalaire());
            ps.setDate(9, Date.valueOf(o.getDate_creation()));
            
            
            ps.executeUpdate();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String p) {
        String req2="DELETE FROM `admin` WHERE pseudo=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req2);
            ps.setString(1, p);
            ps.executeUpdate();
            System.out.println("supprimé");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ereur lors de la suppression");
        }
    }

    
    public ObservableList<Admin> displayAll() {
         ObservableList<Admin> ls= FXCollections.observableArrayList();
            String req3="select * from admin";
            try{
                Statement statement = MyConnection.getInstance().createStatement();
                ResultSet result = statement.executeQuery(req3);
                while(result.next()){
                    Admin admin = new Admin();
                    
                    admin.setPseudo(result.getString(2));
                    admin.setNom(result.getString(3));
                    admin.setPrenom(result.getString(4));
                    admin.setEmail(result.getString(5));
                    
                    admin.setTel(result.getInt(7));
                    admin.setEtat(result.getString(8));
                    admin.setSalaire(result.getInt(9));
                    
                    ls.add(admin);
                }
                
            }catch(SQLException ex){
                System.out.println("err affich");
            }
            return ls;
            }
    

    


    
    public void update(String pseudo , Admin o) {
            String req="UPDATE admin SET pseudo=?,nom=?,prenom=?,email=?,password=?,tel=? WHERE pseudo=?";
            try{
               PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
               
            ps.setString(1, o.getPseudo());
            ps.setString(2, o.getNom());
            ps.setString(3, o.getPrenom());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getPassword());
            ps.setInt(6, o.getTel());
            ps.setString(7, pseudo);
            ps.executeUpdate();
               
            }catch(SQLException e){
                System.out.println("erreur de modification");
            }
    }
   
    public Admin findByPseudo(String x) {
               String req="select * from admin where pseudo = ?";
        Admin a = new Admin();
         ObservableList<Admin> lst= FXCollections.observableArrayList();
        try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, x);
            ResultSet res =ps.executeQuery();
            while(res.next()) {
                Admin aa = new Admin();
                 aa.setId_admin((res.getInt(1)));
                 aa.setPseudo((res.getString(2)));
                 aa.setNom((res.getString(3)));
                 aa.setPrenom((res.getString(4)));
                 aa.setEmail((res.getString(5)));
                 aa.setPassword((res.getString(6)));
                 aa.setTel(res.getInt(7));
                 aa.setEtat((res.getString(8)));
                 aa.setSalaire((res.getInt(9)));
                 aa.setDate_creation((res.getDate(10)).toLocalDate());
                 lst.add(aa);
            
            }
            
            a=lst.get(0);
           
            
        }catch(SQLException e){
            System.out.println("err findbyid()");
        }
        return a;
    }
 
    
    }

    
   

