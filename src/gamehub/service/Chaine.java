package gamehub.service;


import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fakher_Pc
 */
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Chaine {
  


/**
 *
 * @author Fakher_Pc
 */

private SimpleIntegerProperty id_chaine;
private SimpleIntegerProperty id_mpro;
private SimpleStringProperty nomC;
private SimpleStringProperty type;
private SimpleStringProperty console;
private SimpleStringProperty url_pdp;
private SimpleStringProperty url_chaine;
private LocalDate membre_dep;
private LocalDate date_modif;
private SimpleStringProperty sign;



public Chaine()
{}
public Chaine(String nomC,String type,String console,String url_pdp,String url_chaine,String sign){
this.nomC=new SimpleStringProperty(nomC);
this.type=new SimpleStringProperty(type);
this.console=new SimpleStringProperty(console);
this.url_pdp=new SimpleStringProperty(url_pdp);
this.url_chaine=new SimpleStringProperty(url_chaine);
this.sign=new SimpleStringProperty(sign);

}


  

public String GetDateStr(){
    return this.membre_dep.toString();
    } 
public String GetDate2Str(){
    return this.date_modif.toString();
}
 public SimpleStringProperty GetDateStrProp(){
        return new SimpleStringProperty(this.GetDateStr());
    }
 public SimpleStringProperty GetDate2StrProp(){
        return new SimpleStringProperty(this.GetDate2Str());
    }
 public LocalDate getDate_sortie() {
        return membre_dep;
    }

    public SimpleIntegerProperty getId_chaineProp() {
        return id_chaine;
    }
    public int getId_chaine(){
        return id_chaine.get();
    }

    public void setId_chaine(int id_chaine) {
        this.id_chaine = new SimpleIntegerProperty(id_chaine);
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

    public SimpleStringProperty getNomC() {
        return nomC;
    }
    public String getNomc(){
        return nomC.get();
    }

    public void setNomC(String nomC) {
        this.nomC = new SimpleStringProperty(nomC);
    }
     public SimpleStringProperty gettypeProp() {
        return type;
    }
    public String gettype(){
        return type.get();
    }

    public void settype(String type) {
        this.type = new SimpleStringProperty(type);
    }
     public SimpleStringProperty geturl_pdpProp() {
        return url_pdp;
    }
    public String geturl_pdp(){
        return url_pdp.get();
    }

    public void seturl_pdp(String url_pdp) {
        this.url_pdp = new SimpleStringProperty(url_pdp);
    }
    
     public SimpleStringProperty geturl_chaineProp() {
        return url_chaine;
    }
    public String geturl_chaine(){
        return url_chaine.get();
    }

    public void seturl_chaine(String url_chaine) {
        this.url_chaine = new SimpleStringProperty(url_chaine);
    }
    
    public SimpleStringProperty getsignProp() {
        return sign;
    }
    public String getsign(){
        return sign.get();
    }

    public void setsign(String sign) {
        this.sign = new SimpleStringProperty(sign);
    }
 public SimpleStringProperty getconsolerop() {
        return console;
    }
    public String getconsole(){
        return console.get();
    }

    public void setconsole(String sign) {
        this.console = new SimpleStringProperty(sign);
    }
    public void setdate(LocalDate Membredep ){
    this.membre_dep= Membredep;
    }
    public void setdate2(LocalDate date_modif ){
    this.date_modif= date_modif;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id_chaine);
        hash = 53 * hash + Objects.hashCode(this.nomC);
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
        final Chaine other = (Chaine) obj;
        if (!Objects.equals(this.id_chaine, other.id_chaine)) {
            return false;
        }
        if (!Objects.equals(this.id_mpro, other.id_mpro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chaine{" + "id_chaine=" + id_chaine + ", id_mpro=" + id_mpro + ", nomC=" + nomC + ", type=" + type + ", url_pdp=" + url_pdp + ", url_chaine=" + url_chaine + ", membre_dep=" + membre_dep + ", sign=" + sign + '}';
    }

    
    


  


}
  

