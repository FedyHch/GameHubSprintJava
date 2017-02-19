/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.ServiceSanction;
import gamehub.service.Sanction;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fakher_Pc
 */
public class ListData1 {
     private ObservableList<Sanction> sanc = FXCollections.observableArrayList();
  
    public ListData1(){
        ServiceSanction sc = new ServiceSanction();
        try{
            sanc = sc.readAll();
       
        
        }catch(Exception e){
            System.out.println("Erreur lors de l'affichage xxx");
        }
        
    }

    
    public ObservableList<Sanction> getSanction(){
        return sanc;
    }
    
}
