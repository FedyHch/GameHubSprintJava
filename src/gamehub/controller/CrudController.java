/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.controller.ChannelView;
import gamehub.model.ServiceChaine;
import gamehub.service.Chaine;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fakher_Pc
 */
public class CrudController implements Initializable {
    @FXML
    private ImageView PdP;
    @FXML
    private SplitPane SplitPane;
    @FXML
    private AnchorPane Main;
    @FXML
    private ComboBox<String> CombTypeCh;
    @FXML
    private ComboBox<String> CombCons;
    @FXML
    private TextField txt2;
    @FXML
    private TextArea txt3;
    @FXML
    private Button Addid;
    @FXML
    private Button Update;
    @FXML
    private Button Delete;
    public String Avat;
    
    public String url_ch;
    
    private File selectedFile = null;
    
    private File selectedFile2 = null;
    @FXML
    private Button Profile;
    @FXML
    private Button Editer;
    @FXML
    private Button Sancction;
    @FXML
    private Button chnl;

    /**
     * Initializes the controller class.
     */
    public void SetCombo1(){
        List<String> lst = new ArrayList();
         lst.add("FPS");
        lst.add("RPG");
        lst.add("Stratégie");
        lst.add("Action");
        lst.add("Beat'em All");
        lst.add("Hack'n Slash");
        lst.add("Survival-Horror");
        lst.add("Simulation");
        lst.add("Course");
        lst.add("Sport");
        lst.add("MMO");
        ObservableList<String> lst2 = FXCollections.observableList(lst);
        CombTypeCh.setItems(lst2);
        CombTypeCh.getSelectionModel().selectFirst();}
    public void SetCombo2(){
        List<String> lst = new ArrayList();
        lst.add("PS4");
        lst.add("PC");
        lst.add("PS3");
        lst.add("Wii U");
         lst.add("Xbox 360");
          lst.add("Xbox One");
           lst.add("Playstation Vita");
            
        ObservableList<String> lst2 = FXCollections.observableList(lst);
        CombCons.setItems(lst2);
        CombCons.getSelectionModel().selectFirst();}
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.SetCombo1();
   this.SetCombo2();
   Delete.setVisible(false);
   Update.setVisible(false);
   Profile.setDisable(true);
   Editer.setDisable(true);
   Sancction.setDisable(true);
   chnl.setDisable(true);
   
   
        // TODO
    }    

    @FXML
    private void Avatar(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
             
            String imgpath = selectedFile.getAbsolutePath();
            if(imgpath.toUpperCase().endsWith(".JPG")||imgpath.toUpperCase().endsWith(".JPEG")||imgpath.toUpperCase().endsWith(".PNG")){
            
            Avat=("file:\\"+imgpath);
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
            
        }
        
    }

    @FXML
    private void URL_Image(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        selectedFile2 = fileChooser.showOpenDialog(null);

        if (selectedFile2 != null) {
             
            String imgpath = selectedFile2.getAbsolutePath();
            if(imgpath.toUpperCase().endsWith(".M3U8")){
            
            url_ch=("file:\\"+imgpath);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez choisir un lien");
        alert.show();
            }
            
        } else {
            System.out.println("File selection cancelled.");
            selectedFile = null;
            
        }
    }

    @FXML
    private void Add(ActionEvent event) {
        Chaine ch = new Chaine((txt2.getText()),CombTypeCh.getValue(),CombCons.getValue(),Avat,url_ch,txt3.getText());
            ServiceChaine sc = new ServiceChaine();
            sc.insert(ch);  
            Image img= new Image(Avat);
            PdP.setImage(img);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Chaine insérée avec succés!");
        alert.show();
        Addid.setVisible(false);
        txt2.setText("");
        txt3.setText("");
        Delete.setVisible(true);
        Update.setVisible(true);
        Profile.setDisable(false);
   Editer.setDisable(false);
   Sancction.setDisable(false);
   chnl.setDisable(false);
        
        
    }

    @FXML
    private void Modif(ActionEvent event) {
        Chaine ch = new Chaine((txt2.getText()),CombTypeCh.getValue(),CombCons.getValue(),Avat,url_ch,txt3.getText());
       ServiceChaine sc = new ServiceChaine();
            sc.maj(ch);  
            Image img= new Image(Avat);
            PdP.setImage(img);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Chaine Modifié avec succés!");
        alert.show();
        txt2.setText("");
        txt3.setText("");
    }

    @FXML
    private void Delete(ActionEvent event) {
         ServiceChaine sc= new ServiceChaine();
                    sc.deletechaine();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Chaine Supprimée avec succés!");
        alert.show();
        Addid.setVisible(true);
        Delete.setVisible(false);
        Update.setVisible(false);
        txt2.setText("");
        txt3.setText("");
        Image img=new Image("file:/C:/Users/Fakher_Pc/Documents/NetBeansProjects/GameHubFinal/src/gamehub/views/visualbug-facebook1.jpg");
        PdP.setImage(img);
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gamehub/views/Crud.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("Erreur lors de Redirection");
            }
        
        
        
    }

    @FXML
    private void Infos(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gamehub/views/AfficheProfil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("Erreur lors de Redirection");
            }
        
    }

    @FXML
    private void Edit(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gamehub/views/EditProfil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Erreur lors de Redirection");
            }
        
    }

    @FXML
    private void MesSanc(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gamehub/views/MesSanctions.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Erreur lors de Redirection");
            }
    }

    @FXML
    private void MyChannel(ActionEvent event) {
    ChannelView cv = new ChannelView();
    cv.View();
}
}
