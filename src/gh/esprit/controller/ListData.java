/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.model.Publication;
import gh.esprit.service.servicePublication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public class ListData {
    private ObservableList<Publication> pubs=FXCollections.observableArrayList();
    
    public ListData() {
        
        servicePublication sper=servicePublication.getInstance();
        pubs= sper.afficherPublication();
        System.out.println(pubs);
    }
    
    public ObservableList<Publication> getPubs(){
        return pubs;
    }  
    
}
