/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsaver;

import java.util.ArrayList;

/**
 *
 * @author jsisk
 */
public class ListingManager {
    private ArrayList<FoodListing> listings;
    
    public ListingManager() {
        listings = new ArrayList<>();
    }
    
    public void addListing(FoodListing listing) {
        listings.add(listing);
        System.out.println("Successfully added: " + listing.getTitle());
    }
    
    public void displayListings() {
        System.out.println("\n--- Current Active Food Listings ---");
        if (listings.isEmpty()) {
            System.out.println("No active listings available.");
        } else {
            for (FoodListing l : listings) {
                System.out.println(l.getDetails());
            }
        }
    }
    
    public FoodListing searchListing(String id) {
        for (FoodListing l : listings) {
            if(l.getListingID().equalsIgnoreCase(id)) {
                return l;
            }
        }
        return null;
    }
    
    // ADDED: Missing update method to support main method call
    public boolean updateListingPrice(String id, double newDiscountedPrice) {
        FoodListing l = searchListing(id);
        if (l != null) {
            l.setDiscountedPrice(newDiscountedPrice);
            System.out.println("Updated listing " + id + " with new price: €" + newDiscountedPrice);
            return true;
        }
        System.out.println("Listing ID " + id + " not found for update.");
        return false;
    }
    
    public boolean deleteListing(String id) {
        FoodListing l = searchListing(id);
        if (l != null) {
            listings.remove(l);
            System.out.println("Successfully deleted listing ID: " + id);
            return true;
        }
        System.out.println("Listing ID " + id + " not found for deletion.");
        return false;
    }

    // Main execution / test runner
    public static void main(String[] args) {
        ListingManager manager = new ListingManager();

        // 1. CREATE test records
        FoodListing meal1 = new MealListing("M001", "Vegan Buddha Bowl", 12.50, 5.00, "DNR-101", "Vegan", "19:30");
        FoodListing bakery1 = new BakeryListing("B001", "Sourdough Bread Loaf", 4.50, 2.00, "DNR-102", false, "2026-11-08");

        manager.addListing(meal1);
        manager.addListing(bakery1);

        // 2. READ / DISPLAY test records
        manager.displayListings();

        // 3. UPDATE test record
        System.out.println("\n--- Performing Update ---");
        manager.updateListingPrice("B001", 1.50);

        // 4. SEARCH test record
        System.out.println("\n--- Performing Search ---");
        FoodListing found = manager.searchListing("M001");
        if (found != null) {
            System.out.println("Found: " + found.getDetails());
        }

        // 5. DELETE test record
        System.out.println("\n--- Performing Delete ---");
        manager.deleteListing("M001");

        // Display final state
        manager.displayListings();
    }
}