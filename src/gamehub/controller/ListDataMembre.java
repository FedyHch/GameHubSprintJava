/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Membre;
import gamehub.service.ServiceMembre;
import gamehub.service.ServiceMembre_Pro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ListDataMembre {
    private ObservableList<Membre> am = FXCollections.observableArrayList();
    public ListDataMembre(){
        ServiceMembre sm = new ServiceMembre();
        
        try{
            am=sm.displayAll();
            System.out.println(am);
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
                 
        }
    }
    public ListDataMembre(String Pseudo){
        try{
            ServiceMembre sm = new ServiceMembre();
            am.add(sm.findByPseudo(Pseudo));
            
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
            
                    
        }
    }  
        public ObservableList<Membre> getMembre(){
            return am;
    }
}
