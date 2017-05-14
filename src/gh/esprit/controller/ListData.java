/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.model.Jeux;
import gh.esprit.service.ServiceJeux;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Laser
 */
public class ListData {
    
    private ObservableList<Jeux> jx = FXCollections.observableArrayList();
    
    public ListData(){
        ServiceJeux sv = new ServiceJeux();
        try{
        jx= sv.afficherJeux();
        System.out.println(jx);
        }catch(Exception e){
            System.out.println("err List Data");
        }
        
    }
    public ListData(String key){
    
        ServiceJeux sv = new ServiceJeux();
        try{
            jx=sv.rechAll(key);
            //System.out.println(jx);
        }catch(Exception e){
            System.out.println("list data genre err");
        }
        
    }
    
    public ObservableList<Jeux> getJeux(){
        return jx;
    }
    
}
