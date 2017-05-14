/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;

import gh.esprit.model.Jeux;
import gh.esprit.service.ServiceJeux;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import gh.esprit.technique.isNumeric;

/**
 * FXML Controller class
 *
 * @author Laser
 */
public class FXMLJeuxController implements Initializable {
    @FXML
    private TableView<Jeux> table;
    @FXML
    private TableColumn<Jeux, Integer> id;
    @FXML
    private TableColumn<Jeux, String> nom;
    @FXML
    private TableColumn<Jeux, String> genre;
    @FXML
    private TableColumn<Jeux, Float> note;
    @FXML
    private TableColumn<Jeux, String> desc;
    @FXML
    private TableColumn<Jeux, String> date;
    @FXML
    private TableColumn<Jeux, String> cl;
    @FXML
    private TableColumn<Jeux, String> mode;
    @FXML
    private TableColumn<Jeux, Float> prix;
    @FXML
    private TableColumn<Jeux, String> aff;
    
   private final ListData listdata = new ListData();
    @FXML
    private Tab tabafficher;
    @FXML
    private TextField titre2;
    @FXML
    private TextField note2;
    @FXML
    private TextField affiche2;
    @FXML
    private TextField prix2;
    @FXML
    private TextArea desc2;
    @FXML
    private DatePicker date2;
    @FXML
    private Button btAjout;
    @FXML
    private ImageView imglogo;
    @FXML
    private TextField rechText;
    @FXML
    private TableView<Jeux> tebRech;
    @FXML
    private TableColumn<Jeux, String> titre3;
    @FXML
    private TableColumn<Jeux, Float> note3;
    @FXML
    private TableColumn<Jeux, String> genre3;
    @FXML
    private TableColumn<Jeux, Float> prix3;
    
    @FXML
    private Button btRech;
    @FXML
    private ImageView imglogo1;
    private TableColumn<Jeux, Integer> id3;
    @FXML
    private ImageView imglogo3;
    @FXML
    private TextField titre4;
    @FXML
    private TextField id4;
    @FXML
    private TextField prix4;
    @FXML
    private Button modif;
    @FXML
    private TextArea desc4;
    @FXML
    private TextField note4;
    @FXML
    private ImageView imgjeux;
    @FXML
    private Button ajaffiche;
    
    private File selectedFile = null;
    
    @FXML
    private ComboBox<String> combgenre;
    @FXML
    private ComboBox<String> combmode;
    @FXML
    private ComboBox<String> combclass;
    @FXML
    private Button suppBt;
    @FXML
    private TableColumn<Jeux, ImageView> Affiche3;
    @FXML
    private TextField trailer2;
    
    
    
    private void setComboboxGenre(){
        List<String> list = new ArrayList<>();
        list.add("FPS");
        list.add("MMoRPG");
        list.add("Aventure");
        list.add("Strategie");
        list.add("Infiltration");
        list.add("Plateforme");
        list.add("Arcade");
        list.add("Combat");
        list.add("Course");
        list.add("RPG");
        list.add("Gestion");
        list.add("Moba");
        list.add("Action");
        ObservableList<String> obList = FXCollections.observableList(list);
        combgenre.setItems(obList);
        combgenre.getSelectionModel().selectFirst();
    }
    
    private void setComboboxMode(){
        List<String> list = new ArrayList<>();
        list.add("Solo");
        list.add("Multijoueurs");
        list.add("Solo/Multijoueurs");
        
        ObservableList<String> obList = FXCollections.observableList(list);
        combmode.setItems(obList);
        combmode.getSelectionModel().selectFirst();
    }
    
    private void setComboboxClass(){
        List<String> list = new ArrayList<>();
        list.add("PEGI 3");
        list.add("PEGI 7");
        list.add("PEGI 12");
        list.add("PEGI 16");
        list.add("PEGI 18");
        ObservableList<String> obList = FXCollections.observableList(list);
        combclass.setItems(obList);
        combclass.getSelectionModel().selectFirst();
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        
        
       table.setItems(listdata.getJeux());
       
       
       
       id.setCellValueFactory(cell -> (cell.getValue().getId_jeuxProp()).asObject());
      nom.setCellValueFactory(cell -> cell.getValue().getNomProp());
      genre.setCellValueFactory(cell -> cell.getValue().getGenreProp());
      note.setCellValueFactory(cell -> (cell.getValue().getNoteProp()).asObject());
      desc.setCellValueFactory(cell -> cell.getValue().getDescriptionProp());
      
      date.setCellValueFactory(cell ->cell.getValue().GetDateStrProp());
      
      cl.setCellValueFactory(cell -> cell.getValue().getClassificationProp());
      mode.setCellValueFactory(cell -> cell.getValue().getModeProp());
      prix.setCellValueFactory(cell -> (cell.getValue().getPrixProp()).asObject());
      aff.setCellValueFactory(cell -> {
      ServiceJeux sv = new ServiceJeux();
      return (sv.getAdmin(cell.getValue().getId_admin()));
      });
      
      table.setOnMouseClicked(event->{
          
          String urlimg;
          urlimg = String.valueOf(listdata.getJeux()
                .get(table.getSelectionModel().getSelectedIndex())
                .getAffiche());
         Image img1 = new Image(urlimg,true);
         
       imgjeux.setImage(img1);
       
              
              });
       
       tebRech.setOnMouseClicked(event->{
            ListData listdatarech = new ListData(rechText.getText());
          
          id4.setText(String.valueOf(listdatarech.getJeux()
                .get(tebRech.getSelectionModel().getSelectedIndex())
                .getId_jeux()));
          
          if(!id4.getText().equals("")){
        ServiceJeux sv = new ServiceJeux();
        Jeux j = sv.findById(Integer.parseInt(id4.getText()));
        titre4.setText(j.getNom());
        note4.setText(String.valueOf( j.getNote()));
        prix4.setText(String.valueOf(j.getPrix()));
        desc4.setText(j.getDescription());
        }else{
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information!");
            alert.setHeaderText(null);
            alert.setContentText("veuiller saisir un id");
            alert.show();
        }
         
        
        
      });
       
       
       tebRech.setItems(listdata.getJeux());
       
      titre3.setCellValueFactory(cell -> cell.getValue().getNomProp());
      genre3.setCellValueFactory(cell -> cell.getValue().getGenreProp());
      note3.setCellValueFactory(cell -> (cell.getValue().getNoteProp()).asObject());
      
      prix3.setCellValueFactory(cell -> (cell.getValue().getPrixProp()).asObject());
      
     Affiche3.setCellValueFactory(cell-> {
            Image img = new Image(cell.getValue().getAffiche());
            ImageView imageview = new ImageView(img);
            imageview.setFitHeight(100);
            imageview.setFitWidth(100);
            return new SimpleObjectProperty<>(imageview);
            
        });
       
       
       
       
       
       this.setComboboxGenre();
       this.setComboboxMode();
       this.setComboboxClass();
        
       
        
      

              }

    @FXML
    private void ajoutAction(ActionEvent event) {
        
            //genre2.getText()
            //mode2.getText()
        if(!(titre2.getText().isEmpty()||note2.getText().isEmpty()||date2.getValue()==null||affiche2.getText().isEmpty()||trailer2.getText().isEmpty()||!(isNumeric.isFloat(note2.getText()))||!(isNumeric.isFloat(prix2.getText())))){
            
            
            if(!(Float.parseFloat(note2.getText())<0 || Float.parseFloat(note2.getText())>20 )){
                if(!((Float.parseFloat(prix2.getText()))<0)){
                if(trailer2.getText().startsWith("https://www.youtube.com")){
                    
            Jeux j = new Jeux(titre2.getText(),combgenre.getValue(),Float.parseFloat(note2.getText()),desc2.getText(),date2.getValue(),combclass.getValue(),combmode.getValue(),Float.parseFloat(prix2.getText()),affiche2.getText(),trailer2.getText(),1);
            ServiceJeux sv = new ServiceJeux();
            sv.ajouterJeux(j);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Jeu insérée avec succés!");
        alert.show();
        
        //api Notification
        ImageView Notifimg=new ImageView(new Image("file:/C:/Users/Laser/Documents/NetBeansProjects/GameHubFX/src/gh/esprit/affiches/classic.png"));
        Notifimg.setFitHeight(100);
        Notifimg.setFitWidth(100);
        Notifications notif = Notifications.create().text("Un nouveau jeu de genre"+combgenre.getValue()+" a été ajouté\n"+"Titre : "+titre2.getText()+"\n Allez le Consulter!! ")
                .title("GameHub").graphic(Notifimg).hideAfter(Duration.seconds(10))
                .position(Pos.BOTTOM_RIGHT);
                notif.show();
        // fin api Notification
                
        
        titre2.setText("");
        combgenre.getSelectionModel().selectFirst();
        note2.setText("");
        desc2.setText("");
        date2.setValue(null);
        combclass.getSelectionModel().selectFirst();
        combmode.getSelectionModel().selectFirst();
        prix2.setText("");
        affiche2.setText("");
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeux.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("err redirection");
            }
        
                }else{
                    
                    Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("veillez choisir un trailer valide depuis youtube");
        alert.show();
                    
                }
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Le Prix doit être superieur ou égal à 0 ");
        alert.show();
                    
                }
            }else{
               Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("La note doit etre entre 0 et 20!");
        alert.show(); 
            }
        }else{
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Verifier vos parametres");
        alert.show();
        }
        
        
    
    }

    @FXML
    private void rechercheAction(ActionEvent event) {
        if(!rechText.getText().equals("")){
        ListData listdatarech = new ListData(rechText.getText());
        tebRech.setItems(listdatarech.getJeux());
        
        
      titre3.setCellValueFactory(cell -> cell.getValue().getNomProp());
      genre3.setCellValueFactory(cell -> cell.getValue().getGenreProp());
      note3.setCellValueFactory(cell -> (cell.getValue().getNoteProp()).asObject());
      
      
      
      
      
      prix3.setCellValueFactory(cell -> (cell.getValue().getPrixProp()).asObject());
        }
        else{
             tebRech.setItems(listdata.getJeux());
       
      titre3.setCellValueFactory(cell -> cell.getValue().getNomProp());
      genre3.setCellValueFactory(cell -> cell.getValue().getGenreProp());
      note3.setCellValueFactory(cell -> (cell.getValue().getNoteProp()).asObject());
      
      prix3.setCellValueFactory(cell -> (cell.getValue().getPrixProp()).asObject());
        }
//      Jeux j = table.getSelectionModel().getSelectedItem();
//        System.out.println(j.getNomProp()); 
//    
        
        
    }
    
    @FXML
    private void modifAction(ActionEvent event) {
        
        if(!(titre4.getText().isEmpty()||note4.getText().isEmpty()||prix4.getText().isEmpty()||desc4.getText().isEmpty())){
        
             if(!(Float.parseFloat(note4.getText())<0 || Float.parseFloat(note4.getText())>20 )){
                 if(!((Float.parseFloat(prix4.getText()))<0)){
            ServiceJeux sv = new ServiceJeux();
        Jeux j = sv.findById(Integer.parseInt(id4.getText()));
        j.setNom(titre4.getText());
        j.setNote(Float.parseFloat(note4.getText()));
        j.setPrix(Float.parseFloat(prix4.getText()));
        j.setDescription(desc4.getText());
        
        //api Notification******************************************************
        ImageView Notifimg=new ImageView(new Image("file:/C:/Users/Laser/Documents/NetBeansProjects/GameHubFX/src/gh/esprit/affiches/classic.png"));
        Notifimg.setFitHeight(100);
        Notifimg.setFitWidth(100);
        Notifications notif = Notifications.create().text("Le jeu "+titre4.getText()+"\n a été modifié \n Allez le Consulter!")
                .title("GameHub").graphic(Notifimg).hideAfter(Duration.seconds(10))
                .position(Pos.BOTTOM_RIGHT).onAction((ActionEvent event1) -> {
                    System.out.println("redirection Notification ...");
                    FXMLJeuxFOController.SetIdj(Integer.parseInt(id4.getText()));
                    
                    
                    try {
                        
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gh/esprit/views/FXMLJeuxDetail.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        
                        
                        stage.setScene(new Scene(root1));
                        stage.show();
                        
                        
                    } catch (IOException ex) {
                        System.out.println("err redirection");
                    }
            });
                

                notif.show();
        // fin api Notification*************************************************
        
        System.out.println(j);
        sv.modifierJeux(Integer.parseInt(id4.getText()), j);
        System.out.println("modif succes from Controller");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Modification effectuée avec succes");
        alert.show();
                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeux.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("err redirection");
            }
                 }else{
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Le Prix doit être superieur ou égal à 0 ");
        alert.show(); 
                 }
                }else{
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("La note doit etre entre 0 et 20!");
        alert.show(); 
            
        }
             
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Il faut séléctionner un jeu à modifier");
        alert.show();
        }
    }      

    @FXML
    private void ajoutAfficheAction(ActionEvent event) {
        
        
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
             
            String imgpath = selectedFile.getAbsolutePath();
            if(imgpath.toUpperCase().endsWith(".JPG")||imgpath.toUpperCase().endsWith(".JPEG")||imgpath.toUpperCase().endsWith(".PNG")){
            
            affiche2.setText("file:\\"+imgpath);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez choisir une image");
        alert.show();
            }
            
        } else {
            System.out.println("File selection cancelled.");
            selectedFile = null;
            affiche2.setText("");
        }
    }

    
    @FXML
    private void SuppAction(ActionEvent event) {
        
        if(!(id4.getText().isEmpty())){
        ServiceJeux sv = new ServiceJeux();
        sv.supprimerJeux(Integer.parseInt(id4.getText()));
        System.out.println("suppression avec succes from Controller");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Jeux Supprimé");
        alert.show();
                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLJeux.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("err redirection");
            }  
    }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Il faut choisir un jeu à supprimer");
        alert.show();
        }
        
    }

    @FXML
    private void combGenreAction(ActionEvent event) {
    }

    @FXML
    private void combModeAction(ActionEvent event) {
    }

   
    

    
}
