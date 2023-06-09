/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalstd;

import Services.userModel;
import Services.form;
import Services.myConnection;
import Services.testOracle;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author USER
 */
public class students_tbController {

    @FXML
    private TableView<userModel> tableUser;
    @FXML
    private TableColumn<userModel, Integer> user_id_col;
    @FXML
    private TableColumn<userModel, String> fname_col;
    @FXML
    private TableColumn<userModel, String> lname_col;
    @FXML
    private TableColumn<userModel, String> matric_col;
    @FXML
    private TableColumn<userModel, String> dept_col;
    @FXML
    //private TableColumn<userModel, String> gender_col;
   // @FXML
    private TextField fname_txtfd;
    @FXML
    private TextField lname_txfld;
    @FXML
    private TextField matric_txfld;
    @FXML
    private TextField department_txfld;
    @FXML
    private TextField userId_txfld;
    
    private String fname,lname,matric,department,gender;
    private int id;
    @FXML
    private RadioButton FetchMale;
    @FXML
    private RadioButton fetchFMale;
    @FXML
    private RadioButton fetchAll;
    @FXML
    private Button fetch_std;
    private  userModel user;
    private PreparedStatement pst;
    //private String gender_chk;
    
//        public students_tbController(){
//        this.user_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
//        this.fname_col.setCellValueFactory(new PropertyValueFactory<>("fname"));
//       this.lname_col.setCellValueFactory(new PropertyValueFactory<>("lname"));
//        this.matric_col.setCellValueFactory(new PropertyValueFactory<>("matric"));
//        this.dept_col.setCellValueFactory(new PropertyValueFactory<>("department"));
//        }

//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public void setLname(String lname) {
//        this.lname = lname;
//    }
//
//    public void setMatric(String matric) {
//        this.matric = matric;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//   public students_tbController(String fname, String lname, String matric, String department, String gender, int id) {
//       this.fname = fname;
//        this.lname = lname;
//        this.matric = matric;
//        this.department = department;
//        this.gender = gender;
//        this.id = id;
//    }
    
     ObservableList<userModel> listU;
    int index =-1;
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
//        user_id_col.setCellValueFactory(new PropertyValueFactory<userModel,Integer>("id"));
//        fname_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("fname"));
//        lname_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("lname"));
//        matric_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("matric"));
//        dept_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("department"));
//        gender_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("gender"));
//        try {
//            form frm = new form();
//            listU = frm.loadUsers();
//            tableUser.setItems(listU);
//        } catch (SQLException ex) {
//            Logger.getLogger(userModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void clickTable(MouseEvent event) {
        if(event.getClickCount() == 1){
            user = tableUser.getSelectionModel().getSelectedItem();
            if(user != null){
                System.out.println(user.getFname());
                fname_txtfd.setText(user.getFname());
                lname_txfld.setText(user.getLname());
                matric_txfld.setText(user.getMatric());
                department_txfld.setText(user.getDepartment());
                //userId_txfld.setId(user.getFname());
            }
        }
    }

    @FXML
    private void FetchMale(ActionEvent event) {
        if(FetchMale.isSelected()){
            fetchFMale.setSelected(false);
            fetchAll.setSelected(false);
          //  this.gender_chk ="Female";
        }
    }

    @FXML
    private void fetchFMale(ActionEvent event) {
         if(fetchFMale.isSelected()){
            FetchMale.setSelected(false);
            fetchAll.setSelected(false);
          //  this.gender_chk ="Female";
        }
    }

    @FXML
    private void fetchAll(ActionEvent event) {
         if(fetchAll.isSelected()){
            FetchMale.setSelected(false);
            fetchFMale.setSelected(false);
          //  this.gender_chk ="Female";
        }
    }

    @FXML
    private void fetchStud(ActionEvent event) throws SQLException {
        Connection conn  =  testOracle.ConnectDB();
//        Connection conn = myConnection.ConnectDB();
        user_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        fname_col.setCellValueFactory(new PropertyValueFactory<>("fname"));
       lname_col.setCellValueFactory(new PropertyValueFactory<>("lname"));
        matric_col.setCellValueFactory(new PropertyValueFactory<>("matric"));
        dept_col.setCellValueFactory(new PropertyValueFactory<>("department"));
         
       // gender_col.setCellValueFactory(new PropertyValueFactory<userModel,String>("gender"));
       
       String sql ="";
       String gender = "";
       
         if(fetchFMale.isSelected()){
             gender = "Female";
              tableUser.setItems(FXCollections.observableArrayList());
             
           //sql = "SELECT * FROM user WHERE gender = '"+gender+"'";
            sql = "SELECT * FROM \"user\" WHERE \"gender\" = '"+gender+"'";
            

          
           
           
        }else if(FetchMale.isSelected()){
             gender = "Male";
            sql = "SELECT * FROM \"user\" WHERE \"gender\" = '"+gender+"'";
//            
              tableUser.setItems(FXCollections.observableArrayList());
         }else if(fetchAll.isSelected()){
            sql = "SELECT * FROM \"user\"";
            
             tableUser.setItems(FXCollections.observableArrayList());
        }else{
            sql = "SELECT * FROM \"user\"";
           
             tableUser.setItems(FXCollections.observableArrayList());
             
         }
       
           pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
         List<userModel> data =  new ArrayList<>();
         userModel user =  new userModel(rs.getString("fname"), rs.getString("lname"), rs.getString("matric"), rs.getString("department"), rs.getInt("id"));
         data.add(user);
         tableUser.getItems().addAll(data);
         
         
        }

    }
    
    
    
    
    
    
    
    
    
    
   
    
}
