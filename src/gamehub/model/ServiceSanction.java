/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.model;

import gamehub.service.Sanction;
import gamehub.technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fakher_Pc
 */
public class ServiceSanction {
     Connection conn = MyConnection.getinstance();
    public ObservableList<Sanction> readAll(){
    
  ObservableList<Sanction> list=FXCollections.observableArrayList();      
    String req="Select * from sanction where id_mpro=2";
    try {
            PreparedStatement ps = conn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                Sanction sc=new Sanction();
               
              sc.setSanc(rs.getString(3));
                sc.setduree(rs.getDate(4).toLocalDate());
                sc.setmotif(rs.getString(5));
                sc.setdatesanc(rs.getDate(6).toLocalDate());
                
                
                list.add(sc);
               
            }
               
               
               
            
         } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du l'affichage xxx"+ex.getMessage());
            
}
        System.out.println(list);
    return list;
    
     }
      
    
}
