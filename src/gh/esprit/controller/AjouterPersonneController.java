/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.service.gestionEvenement;
import gh.esprit.entity.Evenement;
import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class AjouterPersonneController implements Initializable {

    
    @FXML
    private Button baj;
    @FXML
    private DatePicker date;
    @FXML
    private TextArea desc;
    @FXML
    private TextField object;
    @FXML
    private Button retour;
    @FXML
    private TextField adresse;
    @FXML
    private Button bs;
    @FXML
    private ImageView imgva;
    
    public String path;
    
    private File selectedFile=null;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
      
            
          
        
        }
        
        
    
    @FXML
    private void bajAction(ActionEvent event) {
         Evenement ev = new Evenement(1,1,object.getText(), desc.getText() ,date.getValue(), adresse.getText(),path);
            gestionEvenement gev = new gestionEvenement();
            try{
            gev.ajouterEvenement(ev);
            } catch(Exception e){System.out.println("aaaa");}
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        object.setText("");
        desc.setText("");
        adresse.setText("");
        date.setValue(null);
    }

    @FXML
    private void retAction(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLDocument.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                
            }
        
         
    }

    @FXML
    private void bsAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
             
            String imgpath = selectedFile.getAbsolutePath();
            if(imgpath.toUpperCase().endsWith(".JPG")||imgpath.toUpperCase().endsWith(".JPEG")||imgpath.toUpperCase().endsWith(".PNG")){
            
            path=("file:\\"+imgpath);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez choisir une image");
        alert.show();
            }
            
        } else {
            System.out.println("File selection cancelled.");
            selectedFile = null;
            
        }
        Image img = new Image(path);
        imgva.setImage(img);
    }

}
