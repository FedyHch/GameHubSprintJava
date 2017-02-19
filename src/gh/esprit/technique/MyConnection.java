/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MyConnection {
    
    private static Connection conn ;
    private final String url="jdbc:mysql://localhost:3306/game_hub";
    private final String login="root";
    private final String password="";
    
    private MyConnection(){}

    public Connection etablirConnection(){
        try {
            conn =DriverManager.getConnection(url,login,password);
            System.out.println("connexion etablie");
        } catch (SQLException e) {
            System.out.println("erreur de connection");
        }
        return conn;

}
    public static Connection getInstance(){
        
        if (conn==null) {
            new MyConnection().etablirConnection();
        }
        return conn;
    }
    
}
