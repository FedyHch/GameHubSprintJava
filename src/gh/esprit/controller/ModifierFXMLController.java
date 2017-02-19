/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.entity.Evenement;
import gh.esprit.service.gestionEvenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * @author Kyogr
 */
public class ModifierFXMLController implements Initializable {
    @FXML
    private TextField id_evenement;
    @FXML
    private TextField object;
    @FXML
    private Button bmod;
    @FXML
    private TextArea description;
    @FXML
    private Button retour;
    @FXML
    private DatePicker date;
    
   public String y;
    @FXML
    private TextField adresse;
    @FXML
    private ImageView imvm;
    @FXML
    private Button bsm;
    
    private File selectedFile;
   
    private String path;
    
    

   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Image img = new Image(FXMLDocumentController.getPatho());
        imvm.setImage(img);
            
         object.setText(FXMLDocumentController.getTitro());
         description.setText(FXMLDocumentController.getDescripto());
         id_evenement.setText(FXMLDocumentController.getIdevento());
         date.setValue(FXMLDocumentController.getDato());
         adresse.setText(FXMLDocumentController.getAdresso());
         path=(FXMLDocumentController.getPatho());
         System.out.println("hello");
   }    
    
    @FXML
    private void bmodAction(ActionEvent event) {
        
        Evenement ev = new Evenement();
        ev.setId_admin(1);
        ev.setDate(date.getValue());
        ev.setDescription(description.getText());
        ev.setObject(object.getText());
        ev.setAdresse(adresse.getText());
        ev.setId_evenement(Integer.parseInt(id_evenement.getText()));
        ev.setPath(path);
            gestionEvenement gev = new gestionEvenement();
            try{
            gev.modifierEvenement(ev);
            } catch(Exception e){System.out.println("aaaa");}
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Evenement modifié!");
        alert.show();
        id_evenement.setText("");
        object.setText("");
        description.setText("");
       
        
    }

    @FXML
    private void bretAction(ActionEvent event) {
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
    private void bsmAction(ActionEvent event) {
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
        imvm.setImage(img);
    }
    
}
