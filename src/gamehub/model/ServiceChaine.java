package gamehub.model;


import gamehub.service.Chaine;
import gamehub.technique.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fakher_Pc
 */
public class ServiceChaine {
    Connection conn = MyConnection.getinstance();
    public void insert(Chaine c){
      
       
      
        String req ="insert into chaine (id_mpro,nomC,type,console,url_pdp,url_chaine,membre_depuis,date_modif,signature) values(2,?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, c.getNomc());
            ps.setString(2,c.gettype());
            ps.setString(3,c.getconsole());
            ps.setString(4,c.geturl_pdp());
            ps.setString(5,c.geturl_chaine());
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.setDate(7, Date.valueOf(LocalDate.now()));
            ps.setString(8, c.getsign());
            ps.executeUpdate();
        System.out.println("Chaine crée avec succes"); 
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout "+ex.getMessage());
        }
        
        }
        public void deletechaine(){
        String req="delete from chaine where id_chaine=(SELECT id_chaine FROM (SELECT * FROM chaine) as del ORDER BY `id_chaine` DESC LIMIT 1) ";
        try{
         PreparedStatement ps = conn.prepareStatement(req);
         ps.executeUpdate();
         System.out.println("Chaine Supprimé avec succes");
         } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
}
}
     public ObservableList<Chaine> readAll(){
    
  ObservableList<Chaine> list=FXCollections.observableArrayList();      
    String req="select * from chaine where id_chaine=(SELECT id_chaine FROM chaine ORDER BY id_chaine DESC LIMIT 1) ";
    try {
            PreparedStatement ps = conn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                Chaine c=new Chaine();
                c.setNomC(rs.getString(3));
                c.settype(rs.getString(4));
                c.setconsole(rs.getString(5));
                c.seturl_pdp(rs.getString(6));
                c.seturl_chaine(rs.getString(7));
                c.setdate(rs.getDate(8).toLocalDate());
                c.setdate2(rs.getDate(9).toLocalDate());
                c.setsign(rs.getString(10));
                list.add(c);}
               return list;
               
               
            
         } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du l'affichage "+ex.getMessage());
            return null;
}
     }
      
     public void maj(Chaine c){
        String req="UPDATE `chaine` SET `nomC`=?,`type`=?,`console`=?,`url_pdp`=?,`url_chaine`=?,`date_modif`=?,`signature`=?  WHERE id_chaine=(SELECT id_chaine FROM (SELECT * FROM chaine) as upd ORDER BY `id_chaine` DESC LIMIT 1) ";
        try{
        PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, c.getNomc());
            ps.setString(2,c.gettype());
            ps.setString(3,c.getconsole());
            ps.setString(4,c.geturl_pdp());
            ps.setString(5,c.geturl_chaine());
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.setString(7, c.getsign());
   
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        }catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la MAJ "+ex.getMessage());
        }
        }
}
     

