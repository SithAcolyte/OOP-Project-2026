/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author hteto
 */
public class User {
 
    //data members filds for user info
    private String userID;
    private String name;
    private String phone;
    private String email;

    //constructor
    public User(String userID, String name, String phone, String email) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //getter and setter 
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // to change contact details, for future editing
    public void updateContactDetail(String phone, String email){
        this.phone = phone;
        this.email = email;
    }
    
    //to display details
    public String getDetails(){
        return "User ID: " + userID + "\nName: " + name +
         "\nPhone: " + phone + "\nEmail: " + email;       
    }
    
}
