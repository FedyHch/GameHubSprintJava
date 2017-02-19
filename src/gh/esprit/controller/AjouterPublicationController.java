/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.service.servicePublication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import gh.esprit.model.Publication;
import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AjouterPublicationController implements Initializable {
    @FXML
    private TextField Lab1;
    
    @FXML
    private TextField Lab3;
    @FXML
    private TextField Lab4;
    @FXML
    private TextField Lab5;
   
    @FXML
    private Button ajouter;
    @FXML
    private Button idUrl;
    @FXML
    private ImageView idimgv;
    @FXML
    private TextArea Lab2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idUrl.setOnAction(event ->{
            FileChooser fc = new FileChooser();
            File seleFile = fc.showOpenDialog(null);
        
            if(seleFile!= null)
            {
                Lab5.setText(seleFile.getAbsolutePath());
                Image img = new Image("file:\\"+seleFile.getAbsolutePath());
                idimgv.setImage(img);
                 
                 
                         
            }else{
                System.out.println("erreur import");
            }
        });
        
        ajouter.setOnAction(event -> {
            if (!Lab1.getText().isEmpty() ) {
            Publication p = new Publication(Integer.parseInt(Lab1.getText()), Lab2.getText(),Lab3.getText(), Lab4.getText(),Lab5.getText(),0);
            servicePublication sp = servicePublication.getInstance();
            sp.ajouterPublication(p);
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("publication insérée avec succés!");
            alert.show();
            Lab1.setText("");
            Lab2.setText("");
            Lab3.setText("");
            Lab4.setText("");
            Lab5.setText("");     
        
        try {
                Parent pageafficher= FXMLLoader.load(getClass().getResource("/gh/esprit/views/afficherPublication.fxml"));
                Scene scene = new Scene(pageafficher);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
            }    
                
            }else{
               Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Id introuvable");
                alert.show();
            }
            
        });
        
    }    
    
}
