/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.technique;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Kyogr
 */
public class MyConnection{
    private static  String dbURL="jdbc:mysql://localhost:3306/game_hub";;
    private static String user="root";
    private static  String password="";
    
    
    private static Connection mcn;
    
    
    private MyConnection(){
        
        
    }
    public Connection etablirConnection(){
        try{
            mcn = DriverManager.getConnection(dbURL,user,password);
        }
        catch(SQLException ex){
            System.out.println("probleme connexion");
        }
        return mcn;
    }
        
    public static Connection getInstance() {
            if (mcn==null) {
                new MyConnection().etablirConnection();
                
                
            }
return mcn;
            
        
    }
    
}
