/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author USER
 */


public class userModel {
    
    private String fname,lname,matric,department;
    private int id;
    
       public userModel(String fname, String lname, String matric, String department,  int id) {
    this.fname = fname;
        this.lname = lname;
        this.matric = matric;
        this.department = department;
       
       this.id = id;
   }
       
       
    
//        public void setFname(String fname) {
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

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMatric() {
        return matric;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

   

    public void setId(int id) {
        this.id = id;
    }
    
}
