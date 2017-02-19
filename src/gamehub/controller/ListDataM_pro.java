/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Membre_pro;
import gamehub.service.ServiceMembre_Pro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ListDataM_pro {
     private ObservableList<Membre_pro> mp = FXCollections.observableArrayList();
    public ListDataM_pro(){
        ServiceMembre_Pro smp = new ServiceMembre_Pro();
        
        try{
            mp=smp.displayAll();
            System.out.println(mp);
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
            
                    
        }
    }
     public ListDataM_pro(String Pseudo){
        try{
            ServiceMembre_Pro smp = new ServiceMembre_Pro();
            mp.add(smp.findByPseudo(Pseudo));
            
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
            
                    
        }
    }  
            
        public ObservableList<Membre_pro> getMembre_pro(){
            return mp;
    }
}

