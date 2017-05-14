/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.technique;



import java.sql.*;


/**
 *
 * @author Laser
 */
public class MyConnection {
    
    private static Connection con;
    private final String url="jdbc:mysql://localhost:3306/game_hub";
    private final String user="root";
    private final String password="";
    
    private MyConnection(){
        
    }
    
    public Connection getConnexion(){
        try {
      con = DriverManager.getConnection(url, user, password);
            System.out.println("connexion terminée!");
    } catch (SQLException e) {
      e.printStackTrace();
            System.out.println("pas de connexion");
    }
        return con;
    }
    public static Connection getInstance(){
        if (con==null){
           new MyConnection().getConnexion();
        }
        return con;
    }
    
}
