/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.controller;


import javafx.scene.image.ImageView;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import gh.esprit.entity.Evenement;
import gh.esprit.service.gestionEvenement;
import gh.esprit.technique.ImagV;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private TableColumn<Evenement, String> id_admin;
    @FXML
    private TableColumn<Evenement, String> date;
    
    private String path;
    
    private ListEvent listev = new ListEvent();
    
 
    @FXML
    private TextField obj;
    
   private static String  titro ,idevento ,descripto,adresso,patho ;
   private static LocalDate dato;
   
     public static String getPatho () {
       
       return patho ;
   } 
    
    
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
    @FXML
    private Button api;
    @FXML
    private Label labtitre;
    @FXML
    private Label labdate;
    @FXML
    private ImageView imgv;
    @FXML
    private ImageView search;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestionEvenement gev = new gestionEvenement();
        
        search.setImage(ImagV.getImage("file:\\C:/Riot Games/search.png"));

        imgv.setImage(ImagV.getImage("file:\\C:/Riot Games/affiche.png"));
        
        idevento=null;
        
        
         tab.setItems(listev.getevents());
        id_evenement.setCellValueFactory(cell -> (cell.getValue().getId_evenementPorperty()).asObject());
        id_admin.setCellValueFactory((cell) -> { return new SimpleStringProperty(gev.rechercherNomAdmin(cell.getValue().getId_admin()));});
        
        
        object.setCellValueFactory(cell -> cell.
                getValue().getObjectProperty());
        description.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());
        date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        adresse.setCellValueFactory(cell -> cell.
                getValue().getAdresseProperty()); 
      
        
         
        tab.setOnMouseClicked(event -> {
    patho = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getPath());
    imgv.setImage(ImagV.getImage(patho));
    titro = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getObject());
    idevento = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getId_evenement());
    descripto = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getDescription());
    adresso = String.valueOf(listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getAdresse());
    dato = listev.getevents().get(tab.getSelectionModel().getSelectedIndex()).getDate();
    labdate.setText("");
           

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
                Parent page1 = FXMLLoader.load(getClass().getResource("/gh/esprit/views/ModifierFXML.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                
            }
             
        }
    }

    @FXML
    private void apiAction(ActionEvent event) throws BadElementException, IOException {
   
        int indentation = 0;
      Random r = new Random();
        try {
            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(titro+r.toString()+"certificates.pdf"));
            } catch (FileNotFoundException ex) {
                
            }
         
            doc.open();
            doc.addHeader(titro, idevento);
            doc.addTitle("love");
           
             String imageUrl = patho;

         Image image2 = Image.getInstance(new URL(imageUrl));
         float scaler = ((doc.getPageSize().getWidth() - doc.leftMargin()
               - doc.rightMargin() - indentation) / image2.getWidth()) * 100;
         image2.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            image2.scaleAbsolute(530, 600f);

//        image2.scalePercent(scaler);
//         image2.scaleAbsolute(700, 900);
        doc.add(image2); 
        Paragraph paragraph1 = new Paragraph("L'événement '"+titro+"', sera lieu à "+adresso+" ,le "+dato);
        Paragraph paragraph2 = new Paragraph("Description :"+descripto);
        Paragraph paragraph3 = new Paragraph(" \n ");
        paragraph2.setSpacingBefore(20f);
        Chunk linebreak = new Chunk(new DottedLineSeparator());
        doc.add(paragraph3);
        doc.add(linebreak);  
        doc.add(paragraph1);
        doc.add(paragraph2);
        doc.add(linebreak); 
 
            doc.close();
        } catch (DocumentException ex) {
           
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void keyAction(KeyEvent event) {
        gestionEvenement gev = new gestionEvenement();
        if (obj.getText().equals("")) {
            
         tab.setItems(listev.getevents());
        id_evenement.setCellValueFactory(cell -> (cell.getValue().getId_evenementPorperty()).asObject());
        id_admin.setCellValueFactory((cell) -> { return new SimpleStringProperty(gev.rechercherNomAdmin(cell.getValue().getId_admin()));});
        
        
        object.setCellValueFactory(cell -> cell.
                getValue().getObjectProperty());
        description.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());
        date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        adresse.setCellValueFactory(cell -> cell.
                getValue().getAdresseProperty()); 
            
            
            
        }
        else{
            ListEvent lev = new ListEvent(obj.getText());
            tab.setItems(lev.getevents());
        id_evenement.setCellValueFactory(cell -> (cell.getValue().getId_evenementPorperty()).asObject());
        id_admin.setCellValueFactory((cell) -> { return new SimpleStringProperty(gev.rechercherNomAdmin(cell.getValue().getId_admin()));});
        
        
        object.setCellValueFactory(cell -> cell.
                getValue().getObjectProperty());
        description.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());
        date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        adresse.setCellValueFactory(cell -> cell.
                getValue().getAdresseProperty()); 
        }
        
        
    }
}
    

    

