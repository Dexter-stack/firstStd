/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalstd;

import Services.form;
import Services.myConnection;
import Services.testOracle;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class RegisterController {

    @FXML
    private TextField fname_txtfd;
    @FXML
    private TextField lastnme_txt;
    @FXML
    private TextField matric_txtfd;
    @FXML
    private TextField dpt_txtf;
    @FXML
    private RadioButton male_rad;
    @FXML
    private RadioButton female_rad;
    @FXML
    private Button submit;
    @FXML
    private Label fname_error;
    @FXML
    private Label lname_error;
    @FXML
    private Label matric_error1;
    @FXML
    private Label department_error;
    @FXML
    private Label gender_error;
    @FXML
    private Label success_msg;
    
    private String gender = "";

    @FXML
    private void check_male(ActionEvent event) {
        if(male_rad.isSelected()){
            this.gender = "MALE";
            female_rad.setSelected(false);
        }
        
    }

    @FXML
    private void check_female(ActionEvent event) {
           if(female_rad.isSelected()){
           this.gender = "FEMALE";
            
            male_rad.setSelected(false);
        }
    }

    @FXML
    private void btn_submit(ActionEvent event) throws SQLException {
        
           form frm = new form();
        
        //set connection
       // Connection conn  =  myConnection.ConnectDB();
       Connection conn  =  testOracle.ConnectDB();
        frm.set_connection(conn);
        //set name 
        frm.setFname(fname_txtfd.getText());
        //set lastname
        frm.setLasname(lastnme_txt.getText());
        //set matric
        frm.setMatric(matric_txtfd.getText());
        //set department
        frm.setDepartment(dpt_txtf.getText());
        //set gender
        String gender ="";
         if(female_rad.isSelected()){
           gender = "female";
           frm.setGender("Female");
           
        }else if(male_rad.isSelected()){
             frm.setGender("Male");
             gender = "male";
         }else{
            frm.setGender("");
        }
        
        frm.Validate();
        frm.check_matric();
        if(frm.flag == 1){
            fname_error.setText("This field is required");
            fname_txtfd.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
        }else if(frm.flag == 2){
            lname_error.setText("This field is required");
            lastnme_txt.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
                
            
        }else if(frm.flag == 3){
            matric_error1.setText("This field is required");
            matric_txtfd.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
           
        }else if(frm.flag == 4){
            department_error.setText("This field is required");
            dpt_txtf.setStyle("-fx-border-color: transparent transparent  red transparent;-fx-background-color:transparent ");
           
        }else if(frm.flag == 5){
            gender_error.setText("This field is required");
            
        }else if(frm.exists == true){
            success_msg.setText("This user has registered");
            System.out.println(frm.exists);
           
         
        }else{
            frm.register_std();
            if(frm.flagsq == true){
                
                success_msg.setText("Student Successfully Registered");
                
                
                
            }else{
                success_msg.setText("Something went wrong");
                
            }
//           
             
        }
        
    }
    
}
