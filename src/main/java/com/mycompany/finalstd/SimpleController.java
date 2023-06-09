/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalstd;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER
 */
public class SimpleController {

    @FXML
    private Label username_la;
    @FXML
    private BorderPane borderpane;
    @FXML
    private Pane borderpane_home;
    @FXML
    private Label fullname;
    @FXML
    private Label welcome_label;

    @FXML
    private void goHome(ActionEvent event) throws IOException {
         AnchorPane view  = FXMLLoader.load(getClass().getResource("home.fxml"));
          borderpane.setCenter(view);
    }

    @FXML
    private void AddStudent(ActionEvent event) throws IOException {
        
          
          AnchorPane view  = FXMLLoader.load(getClass().getResource("register.fxml"));
          borderpane.setCenter(view);
          System.out.println("add ");
    }

    @FXML
    private void fetch_std(ActionEvent event) throws IOException {
        
         AnchorPane view  = FXMLLoader.load(SimpleController.class.getResource("students_tb.fxml"));
          borderpane.setCenter(view);
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
    public void setUsername_la(String username_la) {
        this.username_la.setText(username_la);
        
    }

    public void setFullname(String fullname) {
        this.fullname.setText(fullname);
        
    }
    
}
