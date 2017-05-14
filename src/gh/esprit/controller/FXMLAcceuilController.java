/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laser
 */
public class FXMLAcceuilController implements Initializable {
    @FXML
    private Button boBt;
    @FXML
    private Button foBt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackAction(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeux.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("err redirection here");
            }  
    }

    @FXML
    private void FrontAction(ActionEvent event) {
        
        try {
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
