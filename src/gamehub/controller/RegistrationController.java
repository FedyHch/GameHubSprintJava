/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.controller;

import gamehub.model.Membre;
import gamehub.service.ServiceMembre;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.*;

/**
 * FXML Controller class
 *
 * @author Foued
 */
public class RegistrationController implements Initializable {
    @FXML
    private TextField pseudo;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField cpassword;
    @FXML
    private Button signup;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignupAction(ActionEvent event) {
                      
                           
            if(pseudo.getText().equals("")||(nom.getText().equals(""))||(prenom.getText().equals(""))||email.getText().equals("")||(tel.getText().equals(""))||(password.getText().equals(""))||cpassword.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez Remplir tous les champs ");
        alert.show();
            
        }else{
                if(!password.getText().equals(cpassword.getText())) {
             Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Information Dialog");
        alert1.setHeaderText(null);
        alert1.setContentText("Veuillez vérifier votre mot de passe ");
        alert1.show();
            } else{
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("bienvenue : " + pseudo.getText() + " you are in");
               
               Membre m = new Membre();
               ServiceMembre sm = new ServiceMembre();
               m.setPseudo(pseudo.getText());
               m.setNom(nom.getText());
               m.setPrenom(prenom.getText());
               m.setEmail(email.getText());
               m.setTel(Integer.parseInt(tel.getText()));
               m.setPassword(password.getText());
               sm.insrice(m);
            
            final String username="badreddinne.taamallah@esprit.tn";
                final String pass="etudiantesprit123";
                
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
                
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                      @Override
                      protected PasswordAuthentication getPasswordAuthentication(){
                          return new PasswordAuthentication(username,pass);
                      }
			
	  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("badreddinne.taamallah@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email.getText()));
                        message.setSubject("Game Hub");
			
			message.setText("Salut Mr/Mrs "+prenom.getText()+" "+nom.getText()+".\n\n Vous êtes inscrits à l'application gamehub ,  Merci de faire partie de notre membres. ");

			Transport.send(message);  
                        
}catch(Exception e){
                    System.out.println("erreur lors de l'envoi");
}
            }
   }
    }

    @FXML
    private void BackAction(ActionEvent event) {
        try{
                Parent parent1=FXMLLoader.load(getClass().getResource("/gamehub/view/SeConnecter.fxml"));
                Scene scene= new Scene(parent1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.out.println("erreur lors de la redirection");
            }
    }
}

