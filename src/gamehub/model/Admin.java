/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.model;

import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Foued
 */
public class Admin {
     private SimpleIntegerProperty id_admin;
    private SimpleStringProperty pseudo;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleIntegerProperty tel;
    private SimpleStringProperty etat;
    private SimpleIntegerProperty salaire;
    private LocalDate date_creation;

    public Admin(int id_admin, String pseudo, String nom, String prenom, String email, String password, int tel, String etat, int salaire, LocalDate date_creation) {
        this.id_admin = new SimpleIntegerProperty(id_admin);
        this.pseudo = new SimpleStringProperty(pseudo);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.tel =new SimpleIntegerProperty(tel);
        this.etat = new SimpleStringProperty(etat);
        this.salaire = new SimpleIntegerProperty(salaire);
        this.date_creation = date_creation;
    }
public Admin(String pseudo, String nom, String prenom, String email, String password, int tel, String etat, int salaire, LocalDate date_creation) {
        
        this.pseudo = new SimpleStringProperty(pseudo);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.tel =new SimpleIntegerProperty(tel);
        this.etat = new SimpleStringProperty(etat);
        this.salaire = new SimpleIntegerProperty(salaire);
        this.date_creation = date_creation;
    }
    
    public Admin(String pseudo, String nom, String prenom, String email, String password, int tel) {
        this.pseudo = new SimpleStringProperty(pseudo);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.tel =new SimpleIntegerProperty(tel);
    }

    public Admin() {
    }

    
    
    

    public int getId_admin() {
        return id_admin.get();
    }
    public SimpleIntegerProperty getId_adminProp(){
        return id_admin;
    }
    

    public void setId_admin(int id_admin) {
        this.id_admin = new SimpleIntegerProperty(id_admin);
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

    public int getSalaire() {
        return salaire.get();
    }
    public SimpleIntegerProperty getSalaireProp() {
        return salaire;
    }
    

    public void setSalaire(int salaire) {
        this.salaire = new SimpleIntegerProperty(salaire);
    }

    public LocalDate getDate_creation() {
        return this.date_creation;
    }
    public String getDate_creationStr(){
        return this.date_creation.toString();
    }
    public SimpleStringProperty getDate_creationProp(){
        return new SimpleStringProperty(this.getDate_creationStr());
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "Admin{" + "id_admin=" + id_admin + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", tel=" + tel + ", etat=" + etat + ", salaire=" + salaire + ", date_creation=" + date_creation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id_admin);
        hash = 61 * hash + Objects.hashCode(this.pseudo);
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
        final Admin other = (Admin) obj;
        if (this.id_admin != other.id_admin) {
            return false;
        }
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        return true;
    }
    
    
}
