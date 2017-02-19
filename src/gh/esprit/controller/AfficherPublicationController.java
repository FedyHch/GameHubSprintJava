/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import gh.esprit.model.Publication;
import gh.esprit.service.servicePublication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AfficherPublicationController implements Initializable {
    @FXML
    private TableView<Publication> idTable;
    @FXML
    private TableColumn<Publication, Integer> idCol1;
    @FXML
    private TableColumn<Publication, Integer> idCol2;
    @FXML
    private TableColumn<Publication, String> idCol3;
    @FXML
    private TableColumn<Publication, String> idCol4;
    @FXML
    private TableColumn<Publication, String> idCol5;
    @FXML
    private TableColumn<Publication, String> idCol6;
    @FXML
    private TableColumn<Publication, Integer> idCol7;
    
    private final ListData listdata = new ListData();
    
    private static int idChaineM ;
    private static String idTextM;
    private static String idTypeM;
    private static String idTitreM;
    private static String idUrlM;
    private static int idJaimesM;
    private static int idPubM;
    
    
    @FXML
    private Button btSupp;
   
    @FXML
    private Button btAjout;
    @FXML
    private Button btModif;
    /**
     * Initializes the controller class.
     */
    
    /**
     * Initializes the controller class.
     * @return
     */
    public static int getidPubM(){
        return idPubM ;
    }
    public static int getidChaineM(){
        return idChaineM ;
    }
    
    public static String getIdTextM(){
        return idTextM;
    }
    public static String getIdTypeM(){
        return idTypeM;
    }
    public static String getIdTitreM(){
        return idTitreM;
    }
    public static String getIdUrlM(){
        return idUrlM;
    }
    public static int getIdJaimesM(){
        return idJaimesM ;
    }
    @FXML
    private Button btpartage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String accessToken="EAACEdEose0cBALjNaoaKmP4kpz4jw7kY84h9PxYMV71j2kU0kKOlAUtG1X5nsElZBV6t7gvZCbWbcMbRZBzHtC5evFI4s1j60MyUJHYGuuceuARjuD3vs7S1CwTX11UtoElnQAj7TLLwILidSX8JMY6BUdBhCvNVPtZAjpkmEYIejLeqza2wtmZCtL7KYlTEZD";
        FacebookClient fbcl= new DefaultFacebookClient(accessToken);
        User me = fbcl.fetchObject("me", User.class);
        
        idTable.setItems(listdata.getPubs());
        idCol1.setCellValueFactory(cell -> (cell.getValue().getIdPubProperty()).asObject());   
        idCol2.setCellValueFactory(cell -> (cell.getValue().getIdChaineProperty()).asObject());
        idCol3.setCellValueFactory(cell -> cell.getValue().getTextProperty());
        idCol4.setCellValueFactory(cell -> cell.getValue().getTypeProperty());
        idCol5.setCellValueFactory(cell -> cell.getValue().getTitreProperty());
        idCol6.setCellValueFactory(cell -> cell.getValue().getUrlProperty());
        idCol7.setCellValueFactory(cell -> (cell.getValue().getJaimesProperty()).asObject());
        
        
        btSupp.setOnAction(event -> {
            servicePublication sp = servicePublication.getInstance();
            sp.supprimerPublication(Integer.parseInt(String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getId_pub())));           
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("publication supprimer avec succés!");
        alert.show();  
            try {
                Parent pageajout = FXMLLoader.load(getClass().getResource("/gh/esprit/views/afficherPublication.fxml"));
                Scene scene = new Scene(pageajout);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }                
        });
        
        btAjout.setOnMouseClicked(event -> {
            try {
                Parent pageajout= FXMLLoader.load(getClass().getResource("/gh/esprit/views/ajouterPublication.fxml"));
                Scene scene = new Scene(pageajout);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
            }
        });
        
        btModif.setOnMouseClicked(event -> {
            try {
                idPubM=listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getId_pub();
                idChaineM=listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getId_chaine();
                idTextM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getText());
                idTypeM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getType());
                idTitreM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getTitre());
                idUrlM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getUrl());
                idJaimesM=listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getJaimes();
                Parent pageajout= FXMLLoader.load(getClass().getResource("/gh/esprit/views/modifierPublication.fxml"));
                Scene scene = new Scene(pageajout);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
            } catch (Exception e) {
            }
        }); 
        btpartage.setOnMouseClicked(event -> {
            try {
                idPubM=listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getId_pub();
                idTextM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getText());
                idTitreM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getTitre());
                idUrlM = String.valueOf(listdata.getPubs().get(idTable.getSelectionModel().getSelectedIndex()).getUrl());
                
                fbcl.publish("me/feed", FacebookType.class, Parameter.with("message", idTitreM+"\n  "+idTextM));
//                fbcl.publish("me/photos", GraphResponse.class,
//                BinaryAttachment.with("le nom de l image", getClass().getResourceAsStream(idUrlM)),
//                Parameter.with("message", idTitreM+"\n  "+idTextM));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("publication partager sur facebook avec succés!");
                alert.show();                  
            } catch (Exception e) {
            }
        });
    }        
}
