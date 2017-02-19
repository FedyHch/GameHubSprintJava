/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Admin;
import gamehub.service.ServiceAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Foued
 */
public class ListDataAdmin {
    private ObservableList<Admin> ad = FXCollections.observableArrayList();
    public ListDataAdmin(){
        ServiceAdmin sa = ServiceAdmin.getInstance();
        try{
            ad=sa.displayAll();
            System.out.println(ad);
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
            
                    
        }
    }
    public ListDataAdmin(String Pseudo){
        try{
            ServiceAdmin sa = ServiceAdmin.getInstance();
            ad.add(sa.findByPseudo(Pseudo));
            
        }catch(Exception e){
            System.out.println("erreur lors de l'affichage");
            
                    
        }
    }
            
        public ObservableList<Admin> getAdmins(){
            return ad;
    }
}
