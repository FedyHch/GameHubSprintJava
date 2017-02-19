/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.model;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Foued
 */
public class Membre {
    private SimpleIntegerProperty id_membre;
     private SimpleStringProperty pseudo;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleIntegerProperty tel;
    private SimpleStringProperty etat;
    private SimpleIntegerProperty points;

    public Membre(int id_membre, String pseudo, String nom, String prenom, String email, String password, int tel, String etat, int points) {
        this.id_membre = new SimpleIntegerProperty(id_membre);
         this.pseudo = new SimpleStringProperty(pseudo);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.tel =new SimpleIntegerProperty(tel);
        this.etat = new SimpleStringProperty(etat);
        this.points = new SimpleIntegerProperty(points);
    }

    public Membre() {
    }

    

    public int getId_membre() {
        return id_membre.get();
    }
    
    public SimpleIntegerProperty getId_membreProp() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = new SimpleIntegerProperty(id_membre);
    }

    public String getPseudo() {
        return pseudo.get();
    }
    public SimpleStringProperty getPseudoProp(){
        return pseudo;
    }
    

    public void setPseudo(String pseudo) {
        this.pseudo =new SimpleStringProperty(pseudo);
    }

    public String getNom() {
        return nom.get();
    }
    public SimpleStringProperty getNomProp(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }
    public SimpleStringProperty getPrenomProp(){
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom) ;
    }

    public String getEmail() {
        return email.get();
    }
    public SimpleStringProperty getEmailProp() {
        return email;
    }

    public void setEmail(String email) {
        this.email =new SimpleStringProperty(email) ;
    }

    public String getPassword() {
        return password.get();
    }
    
     public SimpleStringProperty getPasswordProp() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public int getTel() {
        return tel.get();
    }
    public SimpleIntegerProperty getTelProp() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = new SimpleIntegerProperty(tel);
    }

    public String getEtat() {
        return etat.get();
    }
    public SimpleStringProperty getEtatProp() {
        return etat;
    }
    

    public void setEtat(String etat) {
        this.etat = new SimpleStringProperty(etat);
    }

    public int getPoints() {
        return points.get();
    }
    public SimpleIntegerProperty getPointsProp() {
        return points;
    }

    public void setPoints(int points) {
        this.points = new SimpleIntegerProperty(points);
    }

    @Override
    public String toString() {
        return "Membre{" + "id_membre=" + id_membre + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", tel=" + tel + ", etat=" + etat + ", points=" + points + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id_membre);
        hash = 17 * hash + Objects.hashCode(this.pseudo);
        return hash;
    }
    
   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membre other = (Membre) obj;
        if (this.id_membre != other.id_membre) {
            return false;
        }
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        return true;
    }
    
}
