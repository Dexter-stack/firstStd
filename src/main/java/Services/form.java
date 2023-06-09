/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author USER
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.mycompany.finalstd.students_tbController;

/**
 *
 * @author USER
 */
public class form {

    protected String fname, lasname, matric, male, female, gender, department;
    public int flag;
    public boolean exists;

    public String err_msg;
    protected Connection conn;
    public boolean flagsq;
    public form(){
        
    }

    public void set_connection(Connection conn) {
        this.conn = conn;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLasname(String lasname) {
        this.lasname = lasname;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public void Validate() {
        this.err_msg = "";
        if (this.fname.isEmpty()) {
            this.err_msg = "Please Enter your First Name";
            this.flag = 1;
        } else if (this.lasname.isEmpty()) {
            this.err_msg = "Please Enter your Last Name";
            this.flag = 2;
        } else if (this.matric.isEmpty()) {
            this.err_msg = "Please Enter your Matric Number";
            this.flag = 3;
        } else if (this.department.isEmpty()) {

            this.err_msg = "Please Enter your Department";
            this.flag = 4;
        } else if (this.gender.isEmpty()) {
            this.flag = 5;
            this.err_msg = "Please Select a gender";
        } else {
            this.flag = 0;
            this.err_msg = "success";
        }

    }

    public void register_std() throws SQLException {
//          boolean flag =false;
       String querry = "INSERT INTO \"user\" (\"id\", \"fname\", \"lname\", \"matric\", \"department\", \"gender\") " +
                  "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = this.conn.prepareStatement(querry);
        pst.setInt(1, 0);
        pst.setString(2, this.fname);
        pst.setString(3, this.lasname);
        pst.setString(4, this.matric);
        pst.setString(5, this.department);
        pst.setString(6, this.gender);

        if (pst.execute() == false) {
            this.flagsq = true;

        } else {
            this.flagsq = false;
        }

    }

    public void check_matric() throws SQLException {
        //write query
       // String sql = "SELECT * FROM user WHERE matric = ?";
        String sql = "SELECT * FROM \"user\" WHERE \"matric\" = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, this.matric);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            this.exists = true;
        } else {
            this.exists = false;
        }
    }

//    public  ObservableList<students_tbController> loadUsers() throws SQLException {
//        
//        ObservableList<students_tbController> list = FXCollections.observableArrayList();
//        PreparedStatement pst = this.conn.prepareStatement("SELECT * FROM user");
//        ResultSet rs = pst.executeQuery();
//        while (rs.next()) {
//            list.add(new students_tbController(rs.getString("fname"), rs.getString("lname"), rs.getString("matric"), rs.getString("department"), rs.getString("gender"), rs.getInt("id")));
////               students_tbController st =  new students_tbController();
////                list.add(st);
////               st.setId(rs.getInt("id"));
////               st.setDepartment(rs.getString("department"));
////               st.setFname(rs.getString("fname"));
////               st.setLname(rs.getString("lname"));
////               st.setMatric(rs.getString("matric"));
//              // st.setGender(rs.getString("gender"));
//                
//             
//               
//              
//        }
//        return list;
//    }

}