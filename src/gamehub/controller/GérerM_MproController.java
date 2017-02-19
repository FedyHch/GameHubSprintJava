/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Membre;
import gamehub.model.Membre_pro;
import gamehub.service.ServiceMembre;
import gamehub.service.ServiceMembre_Pro;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Foued
 */
public class GérerM_MproController implements Initializable {
            private ListDataMembre listdatam =new ListDataMembre();
            private ListDataM_pro listdatamp = new ListDataM_pro();
            

    @FXML
    private TableColumn<Membre, String> pseudoM;
    @FXML
    private TableColumn<Membre, String> nomM;
    @FXML
    private TableColumn<Membre, String> emailM;
    @FXML
    private TableColumn<Membre, String> etatm;
    @FXML
    private TableColumn<Membre_pro, String> pseudomp;
    @FXML
    private TableColumn<Membre_pro, String> nommp;
    @FXML
    private TableColumn<Membre_pro, String> emailmp;
    
    @FXML
    private TableColumn<Membre_pro, String> etatmp;
    @FXML
    private TableView<Membre> tablem;
    @FXML
    private TableView<Membre_pro> tablempro;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField x;
    @FXML
    private TextField rech;
    @FXML
    private Button suppmp;
    @FXML
    private Button rechmp;
    @FXML
    private TextField y;
    @FXML
    private TextField rechy;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablem.setItems(listdatam.getMembre());
        
        pseudoM.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nomM.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        emailM.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        etatm.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        
        tablempro.setItems(listdatamp.getMembre_pro());
        pseudomp.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nommp.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        emailmp.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        etatmp.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        
        
        
        tablem.setOnMouseClicked(event->{
            String supprimer;
            supprimer =String.valueOf(listdatam.getMembre().get(tablem.getSelectionModel().getSelectedIndex()).getPseudo());
            x.setText(supprimer);
             });
        supprimer.setOnAction(event ->{
       ServiceMembre sm=new ServiceMembre();
     sm.delete(x.getText());
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText(null);
        alert.setContentText("Membre supprimé avec succés");
        alert.show();
      });
        
        
        
        
        
      tablempro.setOnMouseClicked(event->{
            String suppmp;
            suppmp =String.valueOf(listdatamp.getMembre_pro().get(tablempro.getSelectionModel().getSelectedIndex()).getPseudo());
            y.setText(suppmp);
             });
        suppmp.setOnAction(event ->{
       ServiceMembre_Pro smp=new ServiceMembre_Pro();
     smp.delete(y.getText());
     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Supprimer");
        alert1.setHeaderText(null);
        alert1.setContentText("Membre_pro supprimé avec succés");
        alert1.show();
      });
        
    }    

    @FXML
    private void SupprimerAction(ActionEvent event) {
        
    }

    @FXML
    private void Rechercher(ActionEvent event) {
        if(!rech.getText().equals("")){
            ListDataMembre lsm = new ListDataMembre(rech.getText());
           
        tablem.setItems(lsm.getMembre());
         
        
        pseudoM.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nomM.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        emailM.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        etatm.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        
    

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rechercher");
        alert.setHeaderText(null);
        alert.setContentText("Pseudo not found");
        alert.show();
     
        }
        
    }

    @FXML
    private void SuppM_ProAction(ActionEvent event) {
    }

    @FXML
    private void RechercherM_ProAction(ActionEvent event) {
        if(!rechy.getText().equals("")){
            ListDataM_pro lsm = new ListDataM_pro(rechy.getText());
           
        tablempro.setItems(lsm.getMembre_pro());
         
        
        pseudomp.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nommp.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        emailmp.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        etatmp.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        
    

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rechercher");
        alert.setHeaderText(null);
        alert.setContentText("Pseudo not found");
        alert.show();
     
        }
        
    }

    @FXML
    private void BAckAction(ActionEvent event) {
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
    

