/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

import java.util.ArrayList;

/**
 *
 * @author hteto
 */
public class UserManager {

    private ArrayList<User> users; //store both Donor and Recipient

    //constructor to build a empty list
    public UserManager() {
        users = new ArrayList<User>();
    }
    
    //create a profile
    public void addUser(User user) {
        users.add(user);
    }

    //the copy of the list to show in the table
    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users);
    }

    public boolean deleteUser(String userID){
        for (int i = 0; i< users.size(); i++){
            if(users.get(i).getUserID().equals(userID)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

}