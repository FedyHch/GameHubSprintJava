/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.model;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lenovo
 */
public class Publication {
    private SimpleIntegerProperty id_pub;
    private SimpleIntegerProperty id_chaine;
    private SimpleStringProperty text;
    private SimpleStringProperty type;
    private SimpleStringProperty titre ;
    private SimpleStringProperty url;
    private SimpleIntegerProperty jaimes ;

    public Publication() {
    }

    public Publication(int id_pub, int id_chaine, String text, String type, String titre, String url, int jaimes) {
        this.id_pub = new SimpleIntegerProperty(id_pub);
        this.id_chaine = new SimpleIntegerProperty(id_chaine);
        this.text = new SimpleStringProperty(text);
        this.type = new SimpleStringProperty(type);
        this.titre = new SimpleStringProperty(titre);
        this.url = new SimpleStringProperty(url);
        this.jaimes = new SimpleIntegerProperty(jaimes);
    }
    

    public Publication( int id_chaine, String text, String type, String titre, String url, int jaimes) {
        this.id_chaine = new SimpleIntegerProperty(id_chaine);
        this.text = new SimpleStringProperty(text);
        this.type = new SimpleStringProperty(type);
        this.titre = new SimpleStringProperty(titre);
        this.url = new SimpleStringProperty(url);
        this.jaimes = new SimpleIntegerProperty(jaimes);
    }

    public int getId_pub() {
        return id_pub.get();
    }

    public void setId_pub(int id_pub) {
        this.id_pub = new SimpleIntegerProperty(id_pub);
    }

    public int getId_chaine() {
        return id_chaine.get();
    }

    public void setId_chaine(int id_chaine) {
        this.id_chaine = new SimpleIntegerProperty(id_chaine);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text = new SimpleStringProperty(text);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type =new SimpleStringProperty(type);
    }

    public String getTitre() {
        return titre.get();
    }

    public void setTitre(String titre) {
        this.titre = new SimpleStringProperty(titre);
    }

    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url = new SimpleStringProperty(url);
    }

    public int getJaimes() {
        return jaimes.get();
    }

    public void setJaimes(int jaimes) {
        this.jaimes = new SimpleIntegerProperty(jaimes);
    }
    public SimpleIntegerProperty getIdPubProperty(){
        return id_pub;
    }
    public SimpleIntegerProperty getIdChaineProperty(){
        return id_chaine;
    }
    public SimpleStringProperty getTextProperty(){
        return text;
    }
    public SimpleStringProperty getTypeProperty(){
        return type;
    }
    public SimpleStringProperty getTitreProperty(){
        return titre;
    }
    public SimpleStringProperty getUrlProperty(){
        return url;
    }
    public SimpleIntegerProperty getJaimesProperty(){
        return jaimes;
    }

    @Override
    public String toString() {
        return "Publication{" + "id_pub=" + id_pub + ", id_chaine=" + id_chaine + ", text=" + text + ", type=" + type + ", titre=" + titre + ", url=" + url + ", jaimes=" + jaimes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id_pub);
        hash = 19 * hash + Objects.hashCode(this.id_chaine);
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
        final Publication other = (Publication) obj;
        if (!Objects.equals(this.id_pub, other.id_pub)) {
            return false;
        }
        return Objects.equals(this.id_chaine, other.id_chaine);
    }
}