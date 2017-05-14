/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.model;

import java.sql.Date;
import java.time.LocalDate;
import gamehubfx.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Objects;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Laser
 */
public class Jeux {
    
    private SimpleIntegerProperty id_jeux;
    private SimpleStringProperty nom;
    private SimpleStringProperty genre;
    private SimpleFloatProperty note;
    private SimpleStringProperty description;
    private LocalDate date_sortie;
    //private SimpleDateFormat date_sortie;
    private SimpleStringProperty classification;
    private SimpleStringProperty mode;
    private SimpleFloatProperty prix;
    private SimpleStringProperty affiche;
    private SimpleStringProperty trailer;
    private SimpleIntegerProperty id_admin;
    
 
    public Jeux(int id_jeux, String nom, String genre, float note, String description, LocalDate date_sortie, String classification, String mode, float prix, String affiche,String trailer, int id_admin) {
        this.id_jeux = new SimpleIntegerProperty(id_jeux);
        this.nom = new SimpleStringProperty(nom);
        this.genre = new SimpleStringProperty(genre);
        this.note = new SimpleFloatProperty(note);
        this.description = new SimpleStringProperty(description);
        this.date_sortie = date_sortie;
        this.classification = new SimpleStringProperty(classification);
        this.mode = new SimpleStringProperty(mode);
        this.prix = new SimpleFloatProperty(prix);
        this.affiche = new SimpleStringProperty(affiche);
        this.trailer = new SimpleStringProperty(trailer);
        this.id_admin = new SimpleIntegerProperty (id_admin);
        
    }
    
    

    public Jeux(String nom, String genre, float note, String description, LocalDate date_sortie, String classification, String mode, float prix, String affiche,String trailer, int id_admin) {
        
        this.nom = new SimpleStringProperty(nom);
        this.genre = new SimpleStringProperty(genre);
        this.note = new SimpleFloatProperty(note);
        this.description = new SimpleStringProperty(description);
        this.date_sortie = date_sortie;
        this.classification = new SimpleStringProperty(classification);
        this.mode = new SimpleStringProperty(mode);
        this.prix = new SimpleFloatProperty(prix);
        this.affiche = new SimpleStringProperty(affiche);
        this.id_admin = new SimpleIntegerProperty (id_admin);
        this.trailer = new SimpleStringProperty(trailer);
    }
    
    public Jeux(){
        
    }

    public String GetDateStr(){
        return this.date_sortie.toString();
    } 
    public SimpleStringProperty GetDateStrProp(){
        return new SimpleStringProperty(this.GetDateStr());
    }
    
    public int getId_jeux() {
        return id_jeux.get();
    }

    public void setId_jeux(int id_jeux) {
        this.id_jeux = new SimpleIntegerProperty(id_jeux);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre = new SimpleStringProperty(genre);
    }

    public float getNote() {
        return note.get();
    }

    public void setNote(float note) {
        this.note = new SimpleFloatProperty(note);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public LocalDate getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(LocalDate date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getClassification() {
        return classification.get();
    }

    public void setClassification(String classification) {
        this.classification = new SimpleStringProperty(classification);
    }

    public String getMode() {
        return mode.get();
    }

    public void setMode(String mode) {
        this.mode = new SimpleStringProperty(mode);
    }

    public float getPrix() {
        return prix.get();
    }

    public void setPrix(float prix) {
        this.prix = new SimpleFloatProperty(prix);
    }

    public String getAffiche() {
        return affiche.get();
    }

    public void setAffiche(String affiche) {
        this.affiche = new SimpleStringProperty(affiche);
    }
    
    public String getTrailer(){
        return trailer.get();
    }
    
    public void setTrailer(String trailer){
        this.trailer = new SimpleStringProperty(trailer);
    }

    public int getId_admin() {
        return id_admin.get();
    }

    public void setId_admin(int id_admin) {
        this.id_admin = new SimpleIntegerProperty(id_admin);
    }

    public SimpleIntegerProperty getId_jeuxProp() {
        return id_jeux;
    }

    public SimpleStringProperty getNomProp() {
        return nom;
    }

    public SimpleStringProperty getGenreProp() {
        return genre;
    }

    public SimpleFloatProperty getNoteProp() {
        return note;
    }

    public SimpleStringProperty getDescriptionProp() {
        return description;
    }

    public SimpleStringProperty getClassificationProp() {
        return classification;
    }

    public SimpleStringProperty getModeProp() {
        return mode;
    }

    public SimpleFloatProperty getPrixProp() {
        return prix;
    }

    public SimpleStringProperty getAfficheProp() {
        return affiche;
    }
    public SimpleStringProperty getTrailerProp(){
        return trailer;
    }
    public SimpleIntegerProperty getId_adminProp() {
        return id_admin;
    }
    
    
    

    @Override
    public String toString() {
        return "Jeux{" + "id_jeux=" + id_jeux.get() + ", nom=" + nom.get() + ", genre=" + genre.get() + ", note=" + note.get() + ", description=" + description.get() + ", date_sortie=" + date_sortie + ", classification=" + classification.get() + ", mode=" + mode.get() + ", prix=" + prix.get() + ", affiche=" + affiche.get() +", trailer=" + trailer.get() + ", id_admin=" + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jeux other = (Jeux) obj;
        if (!Objects.equals(this.id_jeux.get(), other.id_jeux.get())) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        int hash = 5;
        hash+= this.id_jeux.get()*3;
        return hash;
    }
    
    
    
    
    
    
    
}
