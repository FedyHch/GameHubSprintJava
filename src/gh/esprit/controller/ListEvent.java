/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.service.gestionEvenement;
import gh.esprit.entity.Evenement;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Kyogr
 */

public class ListEvent {
    
     /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<Evenement> events=FXCollections.observableArrayList();

    public ListEvent() {
        
        gestionEvenement gev= new gestionEvenement();
        events= gev.afficherEvenement();
        System.out.println(events);
    }
    
    public ObservableList<Evenement> getevents(){
        return events;
    }
   
}

