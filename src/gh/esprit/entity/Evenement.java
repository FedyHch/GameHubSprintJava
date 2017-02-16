/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.entity;

import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kyogr
 */
public class Evenement {
    
    private SimpleIntegerProperty id_evenement;
    private SimpleIntegerProperty id_admin;
    private SimpleStringProperty object;
    private SimpleStringProperty description;
    private SimpleStringProperty adresse;
    private LocalDate date;
    

    public Evenement() {
    }
    

    public Evenement(int id_evenement, int id_admin, String object, String description,  LocalDate date, String adresse) {
        this.id_evenement = new SimpleIntegerProperty(id_evenement);
        this.id_admin = new SimpleIntegerProperty(id_admin);
        this.object = new SimpleStringProperty(object);
        this.description = new SimpleStringProperty(description);
        this.adresse = new SimpleStringProperty(adresse);
        this.date = date;
    }
     public Evenement( String object, String description, LocalDate date) {
       
        this.object = new SimpleStringProperty(object);
        this.description = new SimpleStringProperty(description);
        this.date = date;
    }

    public int getId_evenement() {
        return id_evenement.get();
    }
     public SimpleIntegerProperty getId_evenementPorperty() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
         this.id_evenement = new SimpleIntegerProperty(id_evenement);
    }

    public int getId_admin() {
        return id_admin.get();
    }
     public SimpleIntegerProperty getId_adminProperty() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = new SimpleIntegerProperty(id_admin);
    }
    public String getAdresse() {
        return adresse.get();
    }
     public SimpleStringProperty getAdresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = new SimpleStringProperty(adresse);
    }

    public String getObject() {
        return object.get();
    }
    public SimpleStringProperty getObjectProperty() {
        return object;
    }
     public void setObject(String object) {
        this.object = new SimpleStringProperty(object);
    }

   

    public String getDescription() {
        return description.get();
    }
       public SimpleStringProperty getDescriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public LocalDate getDate() {
        return date;
    }
        public String getDateStr() {
        return date.toString();
    }
    public SimpleStringProperty  getDateProperty() {
        return new SimpleStringProperty(this.getDateStr());
}   
    

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", id_admin=" + id_admin + ", object=" + object + ", description=" + description + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id_evenement);
        hash = 23 * hash + Objects.hashCode(this.id_admin);
        hash = 23 * hash + Objects.hashCode(this.object);
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
        final Evenement other = (Evenement) obj;
        if (!Objects.equals(this.id_evenement, other.id_evenement)) {
            return false;
        }
        if (!Objects.equals(this.id_admin, other.id_admin)) {
            return false;
        }
        if (!Objects.equals(this.object, other.object)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
