/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamehub.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Foued
 */
public class MyConnection {
    private static  String dbURL ;
    private static  String user ;
    private static  String password ;
    private static Connection conn;
 private MyConnection(){
     dbURL= "jdbc:mysql://localhost:3306/game_hub";
     user="root";
     password="";
     
 }
 public Connection etablirConnection(){
     try{
         conn = DriverManager.getConnection(dbURL,user,password);
         System.out.println("Connexion établie");
     }
     catch (SQLException ex){
         System.out.println("problème d'établissement de connexion");
     }
     return conn;
 }
 
 
 public static Connection getInstance(){
     if (conn==null){
         new MyConnection().etablirConnection();
         
     }
        return conn;
 }
}
