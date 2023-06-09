/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalstd;

import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Services.adminAuth;
import Services.myConnection;
import Services.testOracle;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @author USER
 */
public class adminController {

    @FXML
    private TextField username_admin;
    @FXML
    private TextField fullname_adm;
    @FXML
    private Button admin_submit;
    @FXML
    private Label username_err;
    @FXML
    private Label fullname_error;
    @FXML
    private Label password_error;
    @FXML
    private Label gender_error;
    @FXML
    private Label success_msg;
    @FXML
    private PasswordField password_adm;
    @FXML
    private Button admin_login;

    @FXML
    private void submit_adm(ActionEvent event) throws SQLException, IOException {
        
        
         adminAuth registerAdmin = new adminAuth();
          Connection conn  =  testOracle.ConnectDB();
        //set connection
       // Connection conn  =  myConnection.ConnectDB();
        registerAdmin.setConn(conn);
        //set username
        registerAdmin.setUsername(username_admin.getText());
        //set fullname and password
        registerAdmin.setPassword(password_adm.getText());
        registerAdmin.setFullname(fullname_adm.getText());
        
       
        
        registerAdmin.Validate();
        registerAdmin.check_username();
        if(registerAdmin.flag == 1){
            username_err.setText("This field is required");
            username_admin.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
        }else if(registerAdmin.flag == 2){
            fullname_error.setText("This field is required");
            fullname_adm.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
                
            
        }else if(registerAdmin.flag == 3){
            password_error.setText("This field is required");
            password_adm.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
           
        }else{
            registerAdmin.register_admin();
            if(registerAdmin.flag_saved == true){
                
                success_msg.setText("Admin Successfully Registered");
                App.setRoot("login");

                
                
                
            }else{
                success_msg.setText("Something went wrong");
                
            }
//           
             
        }
        
    }

    @FXML
    private void back_login(ActionEvent event) throws IOException {
         FXMLLoader loader =  new FXMLLoader(loginController.class.getResource("login.fxml"));
              Parent  root = loader.load();
                
                
              Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               Scene scene = new Scene(root);
                stage.setScene(scene);
                //access the controller 
                
               
                stage.show();
    }
    }
    
    
    

