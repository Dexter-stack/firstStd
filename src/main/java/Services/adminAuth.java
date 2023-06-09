/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class adminAuth {
    
    
    private String username,password,fullname;
    public int flag;
    public boolean exists, flag_saved,flag_login;
    private Connection conn;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getUsername(){
        return this.username;
    }
    public String getFullname(){
        return this.fullname;
    }

     public void Validate(){
         
        if(this.username.isEmpty()){
            
            this.flag = 1;
        }else if(this.fullname.isEmpty()){
            
            this.flag = 2;
         }else if(this.password.isEmpty()){
            
            this.flag = 3;
        
        
        
        }else{
            this.flag = 0;
           
        }
        
    }
     
     
     public void Validate_login(){
         
        if(this.username.isEmpty()){
            
            this.flag = 1;
       
         }else if(this.password.isEmpty()){
            
            this.flag = 2;
        
        
        
        }else{
            this.flag = 0;
           
        }
        
    }
    
     
     
      public void check_username() throws SQLException{
          //write query
          String sql = "SELECT * FROM \"admin\" WHERE \"username\" = ?";

           PreparedStatement pst = conn.prepareStatement(sql);
           pst.setString(1, this.username);

           ResultSet rs = pst.executeQuery();
           if(rs.next()){
               this.exists = true;
           }else{
               this.exists = false;
           }
      }
      
      
      public void register_admin() throws SQLException{
//          boolean flag =false;
           String querry = "INSERT INTO \"admin\" (\"id\", \"username\", \"fullname\", \"password\") " +
                  "VALUES (?, ?, ?, ?)";

          
              PreparedStatement pst = this.conn.prepareStatement(querry);
              pst.setInt(1, 0);
              pst.setString(2, this.username);
              pst.setString(3, this.fullname);
              pst.setString(4, this.password);
             
              
              if(pst.execute() == false){
                 this. flag_saved = true;
                 
              }else{
                  this.flag_saved = false;
              }
               
              
         
         
      }
      
      
      public void login() throws SQLException{
          
          String sql = "SELECT * FROM \"admin\" WHERE \"username\" = ? AND \"password\" = ?";

         PreparedStatement  pst = conn.prepareStatement(sql);

            pst.setString(1, this.username);
            pst.setString(2, this.password);
           ResultSet rs =pst.executeQuery();
           
           if(rs.next()){
               this.flag_login = true;
                this.username = rs.getString("username");
                this.fullname = rs.getString("fullname");
           }else{
               this.flag_login = false;
           }
      }
    
    
    
    
}

