/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.model.Jeux;
import gh.esprit.service.ServiceJeux;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laser
 */
public class FXMLJeuxFOController implements Initializable {
    @FXML
    private TableView<Jeux> top3Tab;
     @FXML
    private TableColumn<Jeux, ImageView> AfficheTop;
    @FXML
    private TableColumn<Jeux, String> titreTop;
    @FXML
    private TableView<Jeux> tabJeux;
    @FXML
    private TableColumn<Jeux, String> titreJeux;
    @FXML
    private TableColumn<Jeux, Float> noteJeux;
    @FXML
    private TableColumn<Jeux, String> genreJeux;
    @FXML
    private TextField Rech;
    @FXML
    private Button rechBT;
    @FXML
    private ImageView imgJeux;
    @FXML
    private Button detailBt;
    
    private final ListData listdata = new ListData();
    
    private static int idJ=0;
   
    public static int getIdj(){
        return idJ;
    }
    public static void SetIdj(int id){
        idJ=id;
    }
    
    
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceJeux sv = new ServiceJeux();
        ObservableList<Jeux> lstTop = sv.AfficherTopTrois();
       top3Tab.setItems(lstTop);
       titreTop.setCellValueFactory(cell -> cell.getValue().getNomProp());
       AfficheTop.setCellValueFactory(cell-> {
            Image img = new Image(cell.getValue().getAffiche());
            ImageView imageview = new ImageView(img);
            imageview.setFitHeight(100);
            imageview.setFitWidth(100);
            return new SimpleObjectProperty<>(imageview);
            
        });
       top3Tab.setOnMouseClicked(event->{
          idJ = lstTop
                .get(top3Tab.getSelectionModel().getSelectedIndex())
                .getId_jeux();
          
          if(idJ!=0){
            
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeuxDetail.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println(idJ);
                
                System.out.println("err redirection detail");
            }    
            
        }
          
       } );
       
        tabJeux.setItems(listdata.getJeux());
        titreJeux.setCellValueFactory(cell -> cell.getValue().getNomProp());
        noteJeux.setCellValueFactory(cell ->cell.getValue().getNoteProp().asObject());
        genreJeux.setCellValueFactory(cell->cell.getValue().getGenreProp());
            
     tabJeux.setOnMouseClicked(event->{
         ListData lstRech = new ListData(Rech.getText());
          idJ = lstRech.getJeux()
                .get(tabJeux.getSelectionModel().getSelectedIndex())
                .getId_jeux();
          
          String urlimg;
          urlimg = String.valueOf(lstRech.getJeux()
                .get(tabJeux.getSelectionModel().getSelectedIndex())
                .getAffiche());
         Image img1 = new Image(urlimg,true);
       imgJeux.setImage(img1);
       
       
              
              });
        
        
        
        
        
        
                
        
    }    

//    @FXML
//    private void rechercherAction(ActionEvent event) {
//        
//        if(!Rech.getText().equals("")){
//        ListData listdatarech = new ListData(Rech.getText());
//        tabJeux.setItems(listdatarech.getJeux());
//        
//        
//      titreJeux.setCellValueFactory(cell -> cell.getValue().getNomProp());
//      noteJeux.setCellValueFactory(cell -> cell.getValue().getNoteProp().asObject());
//      AfficheTop.setCellValueFactory(cell-> {
//            Image img = new Image(cell.getValue().getAffiche());
//            ImageView imageview = new ImageView(img);
//            imageview.setFitHeight(100);
//            imageview.setFitWidth(100);
//            return new SimpleObjectProperty<>(imageview);
//            
//        });
//      
//      
//     
//      
//      
//      
//        }
//        else{
//             Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Veuillez verifier vos keys");
//        alert.show();
//        }
//
//        
//        
//    }
    

    @FXML
    private void detailAction(ActionEvent event) {
        if(idJ!=0){
            
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeuxDetail.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println(idJ);
                
                System.out.println("err redirection detail");
            }    
            
        }else{
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner un jeu");
            alert.show();
        }
       
        
        
    }

    @FXML
    private void RechKeyUp1(KeyEvent event) {
        
        if(!Rech.getText().equals("")){
        ListData listdatarech = new ListData(Rech.getText());
        tabJeux.setItems(listdatarech.getJeux());
        
        
      titreJeux.setCellValueFactory(cell -> cell.getValue().getNomProp());
      noteJeux.setCellValueFactory(cell -> cell.getValue().getNoteProp().asObject());
      genreJeux.setCellValueFactory(cell->cell.getValue().getGenreProp());
      
        }
        else{
            tabJeux.setItems(listdata.getJeux());
        titreJeux.setCellValueFactory(cell -> cell.getValue().getNomProp());
        noteJeux.setCellValueFactory(cell ->cell.getValue().getNoteProp().asObject());
        genreJeux.setCellValueFactory(cell->cell.getValue().getGenreProp());
        }
    }
        
        
    }
    

