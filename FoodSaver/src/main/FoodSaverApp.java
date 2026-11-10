/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.FoodSaverApp to edit this template
 */
package main;

import javax.swing.SwingUtilities;

/**
 *
 * @author hteto
 */
public class FoodSaverApp {
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> { //create Swing GUI in Event Dispatch Thread
            MainMenuForm menu = new MainMenuForm(); //creating landing page window
            menu.setLocationRelativeTo(null); // to set the windown in the midlle of the screen 
            menu.setVisible(true); // to show the window
    });
    }
}
