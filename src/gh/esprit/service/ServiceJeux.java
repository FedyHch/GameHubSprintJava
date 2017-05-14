package gh.esprit.service;

import gh.esprit.model.Jeux;
import gh.esprit.technique.MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Laser
 */
public class ServiceJeux {
    
    
    
  
    
    public void ajouterJeux (Jeux j){
        try{
        String req="insert into jeux(nom,genre,note,description,date_sortie,classification,mode,prix,affiche,trailer,id_admin) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ste = MyConnection.getInstance().prepareStatement(req);
        ste.setString(1, j.getNom());
        ste.setString(2, j.getGenre());
        ste.setFloat(3, j.getNote());
        ste.setString(4, j.getDescription());
        ste.setDate(5, Date.valueOf(j.getDate_sortie()));
        ste.setString(6, j.getClassification());
        ste.setString(7, j.getMode());
        ste.setFloat(8, j.getPrix());
        ste.setString(9, j.getAffiche());
        ste.setString(10, j.getTrailer());
        ste.setInt(11, j.getId_admin());
        
        ste.executeUpdate();
        
        System.out.println("succes");
        }catch(SQLException e){
            System.out.println("err sv ajouterJeux()");
        }
        
    }
    
    public void supprimerJeux (int id_jeux){
        try{
        String req="delete from jeux where id_jeux=?";
        
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        ps.setInt(1, id_jeux);
        ps.executeUpdate();
        System.out.println("jeu supprimé");
        }catch(SQLException e){
            System.out.println("err supprimerJeux()");
        }
        
    }
    
    public ObservableList<Jeux> afficherJeux(){
        String req="select * from jeux";
        ObservableList<Jeux> ls = FXCollections.observableArrayList();
        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        
        ResultSet res = ps.executeQuery();
        
        while(res.next()){
            Jeux j = new Jeux();
            j.setId_jeux(res.getInt(1));
            j.setNom(res.getString(2));
            j.setGenre(res.getString(3));
            j.setNote(res.getFloat(4));
            j.setDescription(res.getString(5));
            j.setDate_sortie(res.getDate(6).toLocalDate());
            j.setClassification(res.getString(7));
            j.setMode(res.getString(8));
            j.setPrix(res.getFloat(9));
            j.setAffiche(res.getString(10));
            j.setTrailer(res.getString(11));
            j.setId_admin(res.getInt(12));
            ls.add(j);
        }
        }catch(Exception e){
                System.out.println("afficherJeux() err");
                }
//            ls.add(new Jeux(res.getInt(1), res.getString(2), res.getString(3), res.getFloat(4), res.getString(5),res.getDate(6).toLocalDate(), res.getString(7), res.getString(8), res.getFloat(9), res.getString(10)/*, res.getInt(11)*/));
    return ls;    
    }
        
        
        
    public void modifierJeux(int id_jeux , Jeux j){
        try{
        String req = "update jeux set nom=?,note=?,description=?,prix=? where id_jeux=?";
        PreparedStatement ste = MyConnection.getInstance().prepareStatement(req);
        
        ste.setString(1, j.getNom());
        ste.setFloat(2, j.getNote());
        ste.setString(3, j.getDescription());
        ste.setFloat(4, j.getPrix());
        ste.setInt(5, id_jeux);
       
        
        ste.executeUpdate();
        }catch(SQLException e){
            System.out.println("err modifierjeux()");
        }
        
    }
    public ObservableList<Jeux> rechercheGenre(String genre){
        String req = "select * from Jeux where genre like ?";
        ObservableList<Jeux> ls = FXCollections.observableArrayList();
        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, "%"+genre+"%");
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Jeux j = new Jeux();
            j.setId_jeux(res.getInt(1));
            j.setNom(res.getString(2));
            j.setGenre(res.getString(3));
            j.setNote(res.getFloat(4));
            j.setDescription(res.getString(5));
            j.setDate_sortie(res.getDate(6).toLocalDate());
            j.setClassification(res.getString(7));
            j.setMode(res.getString(8));
            j.setPrix(res.getFloat(9));
            j.setAffiche(res.getString(10));
            ls.add(j);
        }
         System.out.println("rechgenre terminée avec succes");
        
        
           
        }catch(SQLException e){
            System.out.println("recherche genre");
        }
        return (ls);
        
    }
    
    public ObservableList<Jeux> rechercheTitre(String titre){
        String req = "select * from Jeux where nom like ?";
        ObservableList<Jeux> ls = FXCollections.observableArrayList();
        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, "%"+titre+"%");
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Jeux j = new Jeux();
            j.setId_jeux(res.getInt(1));
            j.setNom(res.getString(2));
            j.setGenre(res.getString(3));
            j.setNote(res.getFloat(4));
            j.setDescription(res.getString(5));
            j.setDate_sortie(res.getDate(6).toLocalDate());
            j.setClassification(res.getString(7));
            j.setMode(res.getString(8));
            j.setPrix(res.getFloat(9));
            j.setAffiche(res.getString(10));
            ls.add(j);
        }
         System.out.println("rechtitre terminée avec succes");
        
        
           
        }catch(SQLException e){
            System.out.println("recherche titre");
        }
        return (ls);
        
    }
    
    public ObservableList<Jeux> rechercheDesc(String desc){
        String req = "select * from Jeux where description like ?";
        ObservableList<Jeux> ls = FXCollections.observableArrayList();
        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        ps.setString(1, "%"+desc+"%");
        ResultSet res = ps.executeQuery();
        while(res.next()){
            Jeux j = new Jeux();
            j.setId_jeux(res.getInt(1));
            j.setNom(res.getString(2));
            j.setGenre(res.getString(3));
            j.setNote(res.getFloat(4));
            j.setDescription(res.getString(5));
            j.setDate_sortie(res.getDate(6).toLocalDate());
            j.setClassification(res.getString(7));
            j.setMode(res.getString(8));
            j.setPrix(res.getFloat(9));
            j.setAffiche(res.getString(10));
            ls.add(j);
        }
         System.out.println("rechdesc terminée avec succes");
        
        
           
        }catch(SQLException e){
            System.out.println("recherche desc");
        }
        return (ls);
        
    }
    public ObservableList<Jeux> rechAll(String key){
        ObservableList<Jeux> rs = FXCollections.observableArrayList();
        ObservableList<Jeux> rs2 = FXCollections.observableArrayList();
        rs.addAll(this.rechercheTitre(key));
        rs.addAll(this.rechercheGenre(key));
        rs.addAll(this.rechercheDesc(key));
        List<Jeux> rs1 = rs.stream().distinct().collect(Collectors.toList());
        rs1.forEach(j->rs2.add(j));
        
        
        return rs2;
     }
    public Jeux findById(int id){
        String req="select * from jeux where id_jeux = ?";
        Jeux xxx = new Jeux();
        List<Jeux> lst = new ArrayList<>();
        try{
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet res =ps.executeQuery();
            while(res.next()) {
                Jeux j = new Jeux();
                 j.setId_jeux(res.getInt(1));
            j.setNom(res.getString(2));
            j.setGenre(res.getString(3));
            j.setNote(res.getFloat(4));
            j.setDescription(res.getString(5));
            j.setDate_sortie(res.getDate(6).toLocalDate());
            j.setClassification(res.getString(7));
            j.setMode(res.getString(8));
            j.setPrix(res.getFloat(9));
            j.setAffiche(res.getString(10));
            j.setTrailer(res.getString(11));
            lst.add(j);    
            }
            
            xxx=lst.get(0);
           
            
        }catch(SQLException e){
            System.out.println("err findbyid()");
        }
        return xxx;
    }
    
    public ObservableList<Jeux> AfficherTopTrois(){
        
        List<Jeux> ls;
        ls=this.afficherJeux().stream().sorted((j1,j2)->(((Float)j2.getNote()).compareTo((Float)j1.getNote()))).limit(3).collect(Collectors.toList());
        ObservableList<Jeux> obs = FXCollections.observableArrayList(ls);
        return obs;
        
        
    }
    
    public SimpleStringProperty getAdmin(int id_admin){
        String req ="select nom from admin where id_admin=?";
        String nom_admin="";
        try{
        PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
        ps.setInt(1, id_admin);
        
        ResultSet res = ps.executeQuery();
        while(res.next()){
            nom_admin=res.getString(1);
            
        }
        }catch(SQLException e){
            System.out.println("err getAdmin()");
        }
        return new SimpleStringProperty(nom_admin);
    }
     
    
}