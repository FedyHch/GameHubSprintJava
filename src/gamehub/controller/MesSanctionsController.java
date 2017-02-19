/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.controller.ListData;
import gamehub.controller.ListData1;
import gamehub.service.Chaine;
import gamehub.service.Sanction;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fakher_Pc
 */
public class MesSanctionsController implements Initializable {
    @FXML
    private ImageView PdP;
    @FXML
    private TableView<Sanction> TabAffiche;
    @FXML
    private TableColumn<Sanction,String> T1;
    @FXML
    private TableColumn<Sanction, String> T2;
    @FXML
    private TableColumn<Sanction, String> T3;
    @FXML
    private TableColumn<Sanction, String> T4;
    ListData1 ld= new ListData1();
    ListData ld2= new ListData();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Chaine ch = new Chaine();
       ch=ld2.getChaines().get(0);
     Image img=new Image(ch.geturl_pdp());
       PdP.setImage(img);
        TabAffiche.setItems(ld.getSanction());
        T1.setCellValueFactory(cell->(cell.getValue().getsanctionProp()));
        T2.setCellValueFactory(cell->(cell.getValue().GetDateStrProp()));
        T3.setCellValueFactory(cell->(cell.getValue().getmotifProp()));
        T4.setCellValueFactory(cell->(cell.getValue().GetDate2StrProp()));
      
    }    

    @FXML
    private void Back(ActionEvent event) {
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
    
}
