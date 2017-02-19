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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Foued
 */
public class AjouterAdminController implements Initializable {
    @FXML
    private TextField pseudo;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField etat;
    @FXML
    private TextField salaire;
    @FXML
    private DatePicker date;
    @FXML
    private PasswordField password;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        Admin a=new Admin(pseudo.getText(),nom.getText(),prenom.getText(),email.getText(),password.getText(),Integer.parseInt(tel.getText()),etat.getText(),Integer.parseInt(salaire.getText()),date.getValue());
        ServiceAdmin ad= ServiceAdmin.getInstance();
        ad.insert(a);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter");
        alert.setHeaderText(null);
        alert.setContentText("Admin ajouté avec succés");
        alert.show();
        pseudo.setText("");
        nom.setText("");
        prenom.setText("");
        email.setText("");
        password.setText("");
        tel.setText("");
        etat.setText("");
        salaire.setText("");
        date.setValue(null);
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
