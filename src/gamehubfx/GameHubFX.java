/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehubfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author Laser
 */
public class GameHubFX extends Application {
    
    private Stage primaryStage;
    private Parent parentPage;
    
    @Override
    public void start(Stage primarystage) throws IOException {
        this.primaryStage = primarystage;
        this.primaryStage.setTitle("GameHub");
        
        parentPage = FXMLLoader.load(getClass().getResource("/gh/esprit/views/FXMLAcceuil.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
