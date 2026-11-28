/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author hteto
 */
public class Recipient extends User {

    private String preferredCollectionMethod;

    public Recipient(String userID, String name, String phone,
                     String email, String preferredCollectionMethod) {
        super(userID, name, phone, email);
        this.preferredCollectionMethod = preferredCollectionMethod;
    }

    public String getPreferredCollectionMethod() {
        return preferredCollectionMethod;
    }

    public void setPreferredCollectionMethod(String method) {
        this.preferredCollectionMethod = method;
    }

    @Override
    public String getDetails() {
        return super.getDetails()
                + "\nPreferred Collection Method: " + preferredCollectionMethod;
    }
}