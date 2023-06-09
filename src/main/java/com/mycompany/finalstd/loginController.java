/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalstd;

import java.io.IOException;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Services.*;
import Services.myConnection;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class loginController {

    @FXML
    private BorderPane mainpage;
    @FXML
    private TextField username_txfld;
    @FXML
    private PasswordField password_txfld;
    @FXML
    private Label login_erro;
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        System.out.println("login");
        Connection conn  =  testOracle.ConnectDB();
       
        adminAuth login = new adminAuth();
         login.setConn(conn);
         login.setUsername(username_txfld.getText());
        //set fullname and password
        login.setPassword(password_txfld.getText());
        login.Validate_login();
        if (login.flag == 1) {
            login_erro.setText("This field is required");
            username_txfld.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
        } else if (login.flag == 2) {
            login_erro.setText("This field is required");
            password_txfld.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");

        } else {
            login.login();
            if (login.flag_login == true) {

                
                  System.out.println(login.getFullname());
                System.out.println(login.getUsername());
                FXMLLoader loader =  new FXMLLoader(loginController.class.getResource("simple.fxml"));
                root = loader.load();
                 //crate an object for the controller
                SimpleController view =loader.getController() ;
                view.setFullname(login.getFullname());
                view.setUsername_la(login.getFullname());
                
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                //access the controller 
                
               
                stage.show();

            } else {
                login_erro.setText("Something went wrong");

            }
        }
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(loginController.class.getResource("admin.fxml"));
        mainpage.setCenter(view);
        
    }
    
}
