/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;



import gh.esprit.entity.Evenement;
import gh.esprit.service.gestionEvenement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kyogr
 */
public class FXMLDocumentController implements Initializable {
    private TextField txt;
    @FXML
    private Button baj;
    @FXML
    private Button bsup;
    @FXML
    private Button bmod;
    @FXML
    private TableColumn<Evenement, Integer> id_evenement;
    @FXML
    private TableColumn<Evenement, String> object;
    @FXML
    private TableColumn<Evenement, String> description;
    @FXML
    private TableView<Evenement> tab;
    @FXML
    private TableColumn<Evenement, Integer> id_admin;
    @FXML
    private TableColumn<Evenement, String> date;
    
    private ListEvent listev = new ListEvent();
    
 
    @FXML
    private TextField obj;
    
   private static String  titro ,idevento ,descripto,adresso ;
   private static LocalDate dato;
    
    
   public static String getIdevento () {
       
       return idevento ;
   } 
   public static String getTitro () {
       
       return titro ;
   }
   public static String getDescripto () {
       
       return descripto ;
   }
   public static LocalDate  getDato () {
       
       return dato ;
   }
    public static String getAdresso () {
       
       return adresso ;
   }
    @FXML
    private TableColumn<Evenement, String> adresse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tab.setItems(listev.getevents());
        id_evenement.setCellValueFactory(cell -> (cell.getValue().getId_evenementPorperty()).asObject());
        id_admin.setCellValueFactory(cell -> (cell.
                getValue().getId_adminProperty()).asObject());
        object.setCellValueFactory(cell -> cell.
                getValue().getObjectProperty());
        description.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());
        date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        adresse.setCellValueFactory(cell -> cell.
                getValue().getAdresseProperty());       
        
         
        tab.setOnMouseClicked(event -> {
         
       
    titro = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getObject());
    idevento = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getId_evenement());
    descripto = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getDescription());
    adresso = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getAdresse());
    dato = listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getDate();
    
      obj.setText(titro);
    });
      
       
        
       
    }
        
      
       
        // TODO

    @FXML
    private void bajAction(ActionEvent event) {
       

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/AjoutFXML.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                
            }
        }
    


  
    @FXML
    private void bsupAction(ActionEvent event) {
        
            gestionEvenement gev = new gestionEvenement();
            try{
            gev.supprimerEvenement(titro);
            } catch(Exception e){System.out.println("aaaa");}
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
    private void bmodAction(ActionEvent event) {
        
        if (idevento==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez choisir un événement");
        alert.show();
            
        } else{
        
        
  try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/gh/esprit/views/ModifierFXML.fxml"));
         Parent root = (Parent) loader.load();
         ModifierFXMLController ctrl = loader.getController();
         

         Scene newScene = new Scene(root);
         Stage newStage = new Stage();
         newStage.setScene(newScene);
         newStage.show();
      } catch (Exception e) {
        
      }
        
    }
    }    
}
    

    

