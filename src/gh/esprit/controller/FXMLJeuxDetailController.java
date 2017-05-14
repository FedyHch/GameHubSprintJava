/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.model.Jeux;
import gh.esprit.service.ServiceJeux;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laser
 */
public class FXMLJeuxDetailController implements Initializable {
    @FXML
    private Label lblTitre;
    private MediaView mview;
    @FXML
    private WebView webv;

    
    @FXML
    private ImageView Affiche;
    @FXML
    private Label Titre;
    @FXML
    private Label Desc;
    @FXML
    private Label dateSortie;
    @FXML
    private Label genre;
    @FXML
    private Label Mode;
    @FXML
    private Label Note;
    @FXML
    private Label Class;
    
    int idJ=FXMLJeuxFOController.getIdj();
    ServiceJeux sv = new ServiceJeux();
    @FXML
    private Button btRetour;
    private WebEngine webEngine;
    String vid;
    @FXML
    private Label prixDet;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Jeux j = sv.findById(idJ);
        Affiche.setImage(new Image(j.getAffiche()));
        
        Titre.setText(j.getNom());
        Desc.setText(j.getDescription());
        dateSortie.setText(j.GetDateStr());
        genre.setText(j.getGenre());
        Mode.setText(j.getMode());
        Note.setText(String.valueOf(j.getNote())+" /20");
        Class.setText(j.getClassification());
        prixDet.setText(j.getPrix()+" $");
        
         if(j.getTrailer()==null){
             vid="";
         }else{      
        String content_url_prefix ="<iframe width=\"350\" height=\"200\" src=\"";        
        String content_url_suffix="\" frameborder=\"0\" allowfullscreen></iframe>";
        String url_trailer= j.getTrailer().replace("watch?v=", "embed/");
//        url_trailer=url_trailer.substring(0,url_trailer.indexOf("&")-1);
        
        vid=content_url_prefix+url_trailer+content_url_suffix;
        
        webEngine = webv.getEngine();
        webEngine.loadContent(vid);
         }
        
        
        
        
        
        
        // TODO
    }    

    @FXML
    private void RetourAction(ActionEvent event) {
        
        try {
                webEngine.loadContent("");
                Stage stage1 = (Stage) btRetour.getScene().getWindow();
                stage1.close();
                                
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeuxFO.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("err redirection");
            }
    }
    
}
