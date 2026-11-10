/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author hteto
 */
public class Donor extends User {
    
    private String collectionAddress;
    private String collectionInstructions;
    
    public Donor(String userID, String name,
            String phone, String email,
            String collectionAddress, String collectionsInstructions){
        
        super(userID, name, phone, email);
        
        this.collectionAddress = collectionAddress;
        this.collectionInstructions = collectionInstructions;
    }
    
    public String getCollectionAddress(){
        return collectionAddress;
    }
    
    public String getCollectionInstructions(){
        return collectionInstructions;
    }
    
    public void updateCollectionDetails(
            String collectionAddress,
            String collectionInstructions) {
        
        this.collectionAddress = collectionAddress;
        this.collectionInstructions = collectionInstructions;        
    }
    
    @Override
    public String getDetails(){
        return super.getDetails() + "\nCollection Address: " + collectionAddress + "\nCollection Address: " + collectionInstructions;
    }
    
}
