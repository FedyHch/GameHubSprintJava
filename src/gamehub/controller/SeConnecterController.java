package gamehub.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class SeConnecterController implements Initializable {
     
    
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private TextField username;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    

    @FXML
    private void SignupAction(ActionEvent event) {
       
            try{
                Parent parent1=FXMLLoader.load(getClass().getResource("/gamehub/view/Registration.fxml"));
                Scene scene= new Scene(parent1);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.out.println("erreur lors de la redirection");
            }
        
        
    }

    @FXML
    private void LoginAction(ActionEvent event) {
        if(username.getText().equals("test")&&(password.getText().equals("test") )){
            try{
            Parent parent1=FXMLLoader.load(getClass().getResource("/gamehub/view/Gestionutilisateurs.fxml"));
            Scene scene= new Scene(parent1);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            
        }catch(IOException e){
            System.out.println("erreur lors de la redirection");
        }
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("bienvenue : " + username.getText());
        alert.show();
        
            
        }else{
            System.out.println("erreur lors de l'authentification");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("please verify your username or password");
        alert.show();
//        try{
//            Parent parent1=FXMLLoader.load(getClass().getResource("/gamehub/view/SeConnecter.fxml"));
//            Scene scene= new Scene(parent1);
//            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//            
//            
//        }catch(IOException e){
//            System.out.println("erreur lors de la redirection");
//        }
        }
        
    }

    
}
