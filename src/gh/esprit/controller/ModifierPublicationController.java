/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import gh.esprit.service.servicePublication;
import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ModifierPublicationController implements Initializable {
    @FXML
    private TextField lab1;
    
    @FXML
    private TextField lab3;
    @FXML
    private TextField lab4;
    @FXML
    private TextField lab5;
    @FXML
    private TextField lab6;
    @FXML
    private Button btMod;
    @FXML
    private ImageView idimgv;
    @FXML
    private Button idUrl;
    @FXML
    private TextArea lab2;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int m1=AfficherPublicationController.getidChaineM();
        lab1.setText(String.valueOf(m1));
        String m2=AfficherPublicationController.getIdTextM();
        lab2.setText(m2);
        String m3=AfficherPublicationController.getIdTypeM();
        lab3.setText(m3);
        String m4=AfficherPublicationController.getIdTitreM();
        lab4.setText(m4);
        String m5=AfficherPublicationController.getIdUrlM();
        lab5.setText(m5);
        int m6=AfficherPublicationController.getIdJaimesM();
        lab6.setText(String.valueOf(m6));
        int x=AfficherPublicationController.getidPubM();
        
        btMod.setOnAction(event -> {
            servicePublication sp = servicePublication.getInstance();
            sp.modifierPublication(x,Integer.parseInt(lab1.getText()),lab2.getText(),lab3.getText(),lab4.getText(),lab5.getText(),Integer.parseInt(lab6.getText()));
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("publication modifiers avec succés!");
        alert.show(); 
        try {
                Parent pageajout= FXMLLoader.load(getClass().getResource("/gh/esprit/views/afficherPublication.fxml"));
                Scene scene = new Scene(pageajout);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
            }
        });
        
        idUrl.setOnAction(event ->{
            FileChooser fc = new FileChooser();
            File seleFile = fc.showOpenDialog(null);
        
            if(seleFile!= null)
            {
                 lab5.setText(seleFile.getAbsolutePath());
                 Image img = new Image("file:\\"+seleFile.getAbsolutePath());
                 idimgv.setImage(img);
                             
            }else{
                System.out.println("erreur import");
             }
        });
    }        
}
