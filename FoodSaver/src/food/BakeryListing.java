/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsaver;

/**
 *
 * @author jsisk
 */
public class BakeryListing extends FoodListing {
    private boolean containsAllergens;
    private String bakedDate;  
    
    public BakeryListing(String listingID, String title, double originalPrice, double discountedPrice, String donorID, boolean containsAllergens, String bakedDate) {
        super(listingID, title, originalPrice, discountedPrice, donorID);
        this.containsAllergens = containsAllergens;
        this.bakedDate = bakedDate;
    }
    
    @Override
    public double calculateDiscount() {
        return originalPrice - discountedPrice;
    }   
        @Override
        public String getDetails() {
            return "Meal Listing [ID: " + ", Title: " + title + ", Baked Date: " 
            + bakedDate + ", Allergens Present: " + containsAllergens + ", Price: €" + discountedPrice 
            + " (Was €" + originalPrice + ")]";
        }
        //Getters and Setters

    public boolean isContainsAllergens() {
        return containsAllergens;
    }

    public void setContainsAllergens(boolean containsAllergens) {
        this.containsAllergens = containsAllergens;
    }

    public String getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(String bakedDate) {
        this.bakedDate = bakedDate;
    }
}




