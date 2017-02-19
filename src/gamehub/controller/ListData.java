/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.service.Chaine;
import gamehub.model.ServiceChaine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fakher_Pc
 */
public class ListData {
     private ObservableList<Chaine> ch = FXCollections.observableArrayList();
    
    public ListData(){
        ServiceChaine sc = new ServiceChaine();
        try{
        ch= sc.readAll();
        System.out.println(ch);
        }catch(Exception e){
            System.out.println("Erreur lors de l'affichage");
        }
        
    }

    public ObservableList<Chaine> getChaines(){
        return ch;
    }
    
}
