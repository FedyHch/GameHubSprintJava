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
public class Membre_pro {
     private SimpleIntegerProperty id_mpro;
     private SimpleStringProperty pseudo;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleIntegerProperty tel;
    private SimpleStringProperty etat;
    
    private SimpleIntegerProperty rpoints;

    public Membre_pro(int id_mpro, String pseudo, String nom, String prenom, String email, String password, int tel, String etat, int rpoints) {
        this.id_mpro = new SimpleIntegerProperty(id_mpro);
         this.pseudo = new SimpleStringProperty(pseudo);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.tel =new SimpleIntegerProperty(tel);
        this.etat = new SimpleStringProperty(etat);
        this.rpoints = new SimpleIntegerProperty(rpoints);
    }

    public Membre_pro() {
    }

    public int getId_mpro() {
        return id_mpro.get();
    }
    
    public SimpleIntegerProperty getId_mproProp() {
        return id_mpro;
    }

    public void setId_mpro(int id_mpro) {
        this.id_mpro = new SimpleIntegerProperty(id_mpro);
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

    public int getRpoints() {
        return rpoints.get();
    }
    public SimpleIntegerProperty getRpointsProp() {
        return rpoints;
    }

    public void setRpoints(int rpoints) {
        this.rpoints = new SimpleIntegerProperty(rpoints);
    }

    @Override
    public String toString() {
        return "Membre_pro{" + "id_mpro=" + id_mpro + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", tel=" + tel + ", etat=" + etat + ", rpoints=" + rpoints + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id_mpro);
        hash = 89 * hash + Objects.hashCode(this.pseudo);
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
        final Membre_pro other = (Membre_pro) obj;
        if (this.id_mpro != other.id_mpro) {
            return false;
        }
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        return true;
    }

}
