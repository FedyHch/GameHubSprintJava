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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Foued
 */
public class GestionutilisateursController implements Initializable {
        private ListDataAdmin listdata =new ListDataAdmin();

    @FXML
    private TableView<Admin> table;
    @FXML
    private TableColumn<Admin, String> pseudo;
    @FXML
    private TableColumn<Admin, String> nom;
    @FXML
    private TableColumn<Admin, String> prenom;
    @FXML
    private TableColumn<Admin, String> email;
    @FXML
    private TableColumn<Admin, Integer> tel;
    @FXML
    private TableColumn<Admin, String> etat;
    @FXML
    private TableColumn<Admin, Integer> salaire;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TextField pseudoa;
    @FXML
    private Button m_mpro;
    
   public static String x;
   
   public static String getX(){
       return x;
   }
  
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setItems(listdata.getAdmins());
        
        
        pseudo.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nom.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        prenom.setCellValueFactory(cell->(cell.getValue().getPrenomProp()));
        email.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        
        tel.setCellValueFactory(cell->(cell.getValue().getTelProp().asObject()));
        etat.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        salaire.setCellValueFactory(cell->(cell.getValue().getSalaireProp().asObject()));
        
        
        
        
        table.setOnMouseClicked(event->{
            String supprimer;
            supprimer =String.valueOf(listdata.getAdmins().get(table.getSelectionModel().getSelectedIndex()).getPseudo());
            pseudoa.setText(supprimer);
             x =String.valueOf(listdata.getAdmins().get(table.getSelectionModel().getSelectedIndex()).getPseudo());
           

        });
        
        
        
        
      supprimer.setOnAction(event ->{
       ServiceAdmin sa=ServiceAdmin.getInstance();
     sa.delete(pseudoa.getText());  
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText(null);
        alert.setContentText("Admin supprimé avec succés");
        alert.show();
      });
     
    }    

    @FXML
    private void AjouterAction(ActionEvent event) {
        try{
                Parent parent =FXMLLoader.load(getClass().getResource("/gamehub/view/AjouterAdmin.fxml"));
                Scene scene= new Scene(parent);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.out.println("erreur lors de la redirection");
            }
        
        
    }

    

    @FXML
    private void SupprimerAction(ActionEvent event) {
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        try{
                Parent parent =FXMLLoader.load(getClass().getResource("/gamehub/view/ModifierCompte.fxml"));
                Scene scene= new Scene(parent);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.out.println("erreur lors de la redirection");
            }
    }

    @FXML
    private void RechercherAction(ActionEvent event) {
        if(!rech.getText().equals("")){
            ListDataAdmin ldr = new ListDataAdmin(rech.getText());
           
        table.setItems(ldr.getAdmins());
         
        
        pseudo.setCellValueFactory(cell->(cell.getValue().getPseudoProp()));
        nom.setCellValueFactory(cell->(cell.getValue().getNomProp()));
        prenom.setCellValueFactory(cell->(cell.getValue().getPrenomProp()));
        email.setCellValueFactory(cell->(cell.getValue().getEmailProp()));
        
        tel.setCellValueFactory(cell->(cell.getValue().getTelProp().asObject()));
        etat.setCellValueFactory(cell->(cell.getValue().getEtatProp()));
        salaire.setCellValueFactory(cell->(cell.getValue().getSalaireProp().asObject()));

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rechercher");
        alert.setHeaderText(null);
        alert.setContentText("Pseudo not found");
        alert.show();
     
        }
    
    }

    @FXML
    private void GererAction(ActionEvent event) {
        try{
                Parent parent =FXMLLoader.load(getClass().getResource("/gamehub/view/Gérer M_Mpro.fxml"));
                Scene scene= new Scene(parent);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.out.println("erreur lors de la redirection");
            }
    }
}