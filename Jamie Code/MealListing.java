/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsaver;

/**
 *
 * @author jsisk
 */
public class MealListing extends FoodListing {

private String dietaryType; // Example: Vegan, Gluten-Free etc...
private String prepTime; // Example: 6pm today

  public MealListing(String listingID, String title, double originalPrice, double discountedPrice, String donorID, String dietaryType, String prepTime) {
        super(listingID, title, originalPrice, discountedPrice, donorID);
        this.dietaryType = dietaryType;
        this.prepTime = prepTime;
    }

@Override
public double calculateDiscount() {
    return originalPrice - discountedPrice;
}

@Override
public String getDetails() {
    return "Meal Listing [ID: " + ", Title: " + title + ", Dietary: "
            + dietaryType + ", Ready By: " + prepTime + ", Price: €" + discountedPrice 
            + " (Was €" + originalPrice + ")]";
}

//Getters and Setters

    public String getDietaryType() {
        return dietaryType;
    }

    public void setDietaryType(String dietaryType) {
        this.dietaryType = dietaryType;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

}
