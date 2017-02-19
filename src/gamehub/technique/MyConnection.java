package gamehub.technique;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fakher_Pc
 */
public class MyConnection {
    
        private String login = "root";
        private String password = "";
        private String url = "jdbc:mysql://localhost:3306/gamehub";
        private static Connection con;
        public  Connection etablirConnection(){
            try
            {
                
            
        
        con = DriverManager.getConnection(url, login, password);
                System.out.println("Connexion Etablie");
            }
            catch(SQLException ex){
                System.out.println("probleme d'établissement de connexion");
            }
            return con;
        }
        
        public static Connection getinstance(){
            if(con==null){
                new MyConnection().etablirConnection();
            }
                return con;
            }
                
            
        
}
     
    

