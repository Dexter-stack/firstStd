/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class testOracle {
     Connection conn = null;
    PreparedStatement prs = null;
    ResultSet Rs = null;
    
    
    
    public static Connection ConnectDB() throws SQLException{
        //jdbc:oracle:thin:@//localhost:1521/orcl [SYSTEM on SYSTEM]
//    String url = "jdbc:oracle:thin:@//localhost:1521/orcl:dexter";
        

        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "SYSTEM", "Muhammedforfame17");
            // Connection established
            System.out.println("Connected to Oracle server!");
    
    return connection;
    }
    
   
}