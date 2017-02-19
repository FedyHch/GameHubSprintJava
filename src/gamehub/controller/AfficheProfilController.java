/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.controller.ListData;
import gamehub.model.ServiceChaine;
import gamehub.service.Chaine;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fakher_Pc
 */
public class AfficheProfilController implements Initializable {
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private TextField txt5;
    @FXML
    private TextArea txt6;
    private final ListData ld =new ListData();
    @FXML
    private ImageView PdP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Chaine ch= new Chaine();
   
   ch=ld.getChaines().get(0);
   Image img=new Image(ch.geturl_pdp());
   PdP.setImage(img);        
       
        txt1.setText(ch.getNomc());
        txt2.setText(ch.gettype());
        txt3.setText(ch.getconsole());
        txt4.setText(ch.GetDateStr());
        txt5.setText(ch.GetDate2Str());
        txt6.setText(ch.getsign());
                
       
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
                System.out.println("Erreur lors de Redirection");
            }
        
    }

    @FXML
    private void Sanctions(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/gamehub/views/MesSanctions.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                System.out.println("Erreur lors de Redirection");
            }
        
    }

    @FXML
    private void MyChannel(ActionEvent event) {
         ChannelView cv = new ChannelView();
    cv.View();
    }
    
}
