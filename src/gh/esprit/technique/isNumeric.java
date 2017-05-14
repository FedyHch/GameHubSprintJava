/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.esprit.technique;

/**
 *
 * @author Laser
 */
public class isNumeric {
    
    public static boolean isFloat(String f){
        
        try  
  {  
    float d = Float.parseFloat(f);  
  }  
  catch(Exception nfe)  
  {  
    return false;  
  }  
  return true;
        
    }
   
    
    
}
