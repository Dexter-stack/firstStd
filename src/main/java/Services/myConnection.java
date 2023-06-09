/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class myConnection {
    
    Connection conn = null;
    PreparedStatement prs = null;
    ResultSet Rs = null;
    
    public static Connection ConnectDB(){
        try{
            
          //  Class.forName("com.mysql.jdbc.Driver");
            Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/management","root","");
            return conn;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
