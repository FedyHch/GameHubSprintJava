/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Admin;
import gamehub.service.ServiceAdmin;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Foued
 */
public class ModifierCompteController implements Initializable {
    @FXML
    private TextField pseudom;
    @FXML
    private TextField nomm;
    @FXML
    private TextField prenomm;
    @FXML
    private TextField emailm;
    @FXML
    private TextField telm;
    @FXML
    private PasswordField passm;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        ServiceAdmin sa=ServiceAdmin.getInstance();
        Admin a = sa.findByPseudo(GestionutilisateursController.getX());
        pseudom.setText(a.getPseudo());
        nomm.setText(a.getNom());
        prenomm.setText(a.getPrenom());
        emailm.setText(a.getEmail());
        passm.setText(a.getPassword());
        telm.setText(String.valueOf(a.getTel()));
        
       
    }    

    @FXML
    private void ModifierAction(ActionEvent event) {
       
        Admin a = new Admin(pseudom.getText(),nomm.getText(),prenomm.getText(),emailm.getText(),passm.getText(),Integer.parseInt(telm.getText()));
        ServiceAdmin sa =ServiceAdmin.getInstance();
        sa.update(GestionutilisateursController.getX(), a);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Modification éffectuée avec succes");
        alert.show();
        
              try{
            Parent parent1=FXMLLoader.load(getClass().getResource("/gamehub/view/Gestionutilisateurs.fxml"));
            Scene scene= new Scene(parent1);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            
        }catch(IOException e){
            System.out.println("erreur lors de la redirection");
        }
    }
    
    
}
