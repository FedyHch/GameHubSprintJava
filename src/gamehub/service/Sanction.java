/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.service;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Fakher_Pc
 */
public class Sanction {
private SimpleIntegerProperty id_mpro;
private SimpleStringProperty sanction;
private SimpleStringProperty motif;
private LocalDate duree;
private LocalDate datedesanc;

public Sanction()
{}
public Sanction(String sanction,String motif){
this.sanction=new SimpleStringProperty(sanction);
this.motif=new SimpleStringProperty(motif);


}
public String GetDateStr(){
    return this.duree.toString();
    } 
public String GetDate2Str(){
    return this.datedesanc.toString();
    } 
public SimpleStringProperty GetDateStrProp(){
        return new SimpleStringProperty(this.GetDateStr());
    }

    @Override
    public String toString() {
        return "Sanction{" + "id_mpro=" + id_mpro + ", sanction=" + sanction + ", motif=" + motif + ", duree=" + duree + ", datedesanc=" + datedesanc + '}';
    }
public SimpleStringProperty GetDate2StrProp(){
        return new SimpleStringProperty(this.GetDate2Str());
    }
public LocalDate getDuree() {
        return this.duree;
    }
public LocalDate getDate_sanc() {
        return this.datedesanc;
    }
  

    public SimpleIntegerProperty getId_mproProp() {
        return id_mpro;
    }
    public int getId_mpro(){
        return id_mpro.get();
    }

    public void setId_mpro(int id_mpro) {
        this.id_mpro = new SimpleIntegerProperty(id_mpro);
    }

    public SimpleStringProperty getsanctionProp() {
        return sanction;
    }
    public String getSanc(){
        return sanction.get();
    }

    public void setSanc(String sanction) {
        this.sanction = new SimpleStringProperty(sanction);
    }
     public SimpleStringProperty getmotifProp() {
        return motif;
    }
    public String getmotif(){
        return motif.get();
    }

    public void setmotif(String motif) {
        this.motif = new SimpleStringProperty(motif);
    }
     
    public void setduree(LocalDate duree ){
    this.duree= duree;
    }
    public void setdatesanc(LocalDate datedesanc){
        this.datedesanc=datedesanc;
    }
}
