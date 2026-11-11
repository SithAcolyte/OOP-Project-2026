/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package food;

/**
 *
 * @author jsisk
 */
public abstract class FoodListing {
    protected String listingID;
    protected String title;
    protected double originalPrice;
    protected double discountedPrice;
    protected String donorID;

    //Constructor
    public FoodListing(String listingID, String title, double originalPrice, double discountedPrice, String donorID) {
        this.listingID = listingID;
        this.title = title;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.donorID = donorID;
    }
    
    //Abstract methods to be implemented by subclasses
    public abstract String getDetails();
    public abstract double calculateDiscount();
    
    //Getters and Setters

    public String getListingID() {
        return listingID;
    }

    public void setListingID(String listingID) {
        this.listingID = listingID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }
    
    
    
}
