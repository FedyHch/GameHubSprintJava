/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehubfx;

import gamehub.controller.SeConnecterController;
import gamehub.technique.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Foued
 */
public class GameHubFx extends Application {
    private Stage stage;
    private Parent parent;
    
    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;
        this.stage.setTitle("Se Connecter");
        
         parent = FXMLLoader.load(getClass().getResource("/gamehub/view/SeConnecter.fxml"));
        Scene scene = new Scene(parent);
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         launch(args);
        
        
    }
    
}
