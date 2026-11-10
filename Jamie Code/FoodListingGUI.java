/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsaver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author jsisk
 */
public class FoodListingGUI extends JFrame {
    private ArrayList<FoodListing> listings;
    private JTable table;
    private DefaultTableModel tableModel;
    
    private JTextField idField, titleField, origPriceField, discPriceField, donorField, extraField;
    private JComboBox<String> typeComboBox;
    
    public FoodListingGUI() {
        listings = new ArrayList<>();
        
        setTitle("Food Saver - Section 1: Food Listing Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JLabel titleLabel = new JLabel("Food Listing Management (Jamie Sisk - 25305913)", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);
        
        String[] columnNames = {"ID", "Type", "Title", "Original (€)", "Discount (€)", "Donor ID", "Extra Details"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 4, 5, 5));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Manage Listings (CRUD)"));
        
        controlPanel.add(new JLabel("Listing ID:"));
        idField = new JTextField();
        controlPanel.add(idField);
        
        controlPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        controlPanel.add(titleField);
        
        controlPanel.add(new JLabel("Original Price (€):"));
        origPriceField = new JTextField();
        controlPanel.add(origPriceField);
        
        controlPanel.add(new JLabel("Discounted Price (€):"));
        discPriceField = new JTextField();
        controlPanel.add(discPriceField);
        
        controlPanel.add(new JLabel("Donor ID:"));
        donorField = new JTextField();
        controlPanel.add(donorField);
        
        controlPanel.add(new JLabel("Listing Type:"));
        typeComboBox = new JComboBox<>(new String[]{"Meal Listing", "Bakery Listing"});
        controlPanel.add(typeComboBox);
        
        controlPanel.add(new JLabel("Dietary / Baked Date:"));
        extraField = new JTextField();
        controlPanel.add(extraField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Listing");
        JButton updateButton = new JButton("Update Price");
        JButton deleteButton = new JButton("Delete Selected");
        JButton clearButton = new JButton("Clear Fields");
        
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(controlPanel, BorderLayout.CENTER);
        southPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(e -> {
            try {
                String id = idField.getText().trim();
                String title = titleField.getText().trim();
                double orig = Double.parseDouble(origPriceField.getText().trim());
                double disc = Double.parseDouble(discPriceField.getText().trim());
                String donor = donorField.getText().trim();
                String extra = extraField.getText().trim();
                String type = (String) typeComboBox.getSelectedItem();
                
                if (id.isEmpty() || title.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "ID and Title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                FoodListing newListing;
                if (type.equals("Meal Listing")) {
                    newListing = new MealListing(id, title, orig, disc, donor, extra, "ASAP");
                } else {
                    newListing = new BakeryListing(id, title, orig, disc, donor, false, extra);
                }
                
                listings.add(newListing);
                refreshTable();
                clearFields();
                JOptionPane.showMessageDialog(this, "Listing added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers forprices.", "Format Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        updateButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row in the table to update.", "Selection Required",JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                String id = (String) tableModel.getValueAt(selectedRow, 0);
                double newDisc = Double.parseDouble(discPriceField.getText().trim());
                
                for (FoodListing l : listings) {
                    if(l.getListingID().equals(id)) {
                        l.setDiscountedPrice(newDisc);
                        break;
                    }
                }
                refreshTable();
                JOptionPane.showMessageDialog(this, "Listing price updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Enter a valid new discount price.", "Format Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        deleteButton.addActionListener( e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row in the table to update.", "Selection Required",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = (String) tableModel.getValueAt(selectedRow, 0);
            listings.removeIf(l -> l.getListingID().equals(id));
            refreshTable();
            JOptionPane.showMessageDialog(this, "Listing deleted successfully!");    
        });
        
        clearButton.addActionListener(e -> clearFields());
        
        loadSampleData();
        
    }
        
        private void refreshTable() {
            tableModel.setRowCount(0);
            for(FoodListing l : listings) {
                String type = l instanceof MealListing ? "Meal" : "Bakery";
                String extraInfo = "";
                if (l instanceof MealListing) {
                    extraInfo = "Dietary: " + ((MealListing) l).getDietaryType();
                } else if (l instanceof BakeryListing) {
                    extraInfo = "Baked Date: " + ((BakeryListing) l).getBakedDate();
                }
                
                Object[] rowData = {
                    l.getListingID(),
                    type,
                    l.getTitle(),
                    String.format("%.2f", l.getOriginalPrice()),
                    String.format("%.2f", l.getDiscountedPrice()),
                    l.getDonorID(),
                    extraInfo
                };
                tableModel.addRow(rowData);
            }
        }
        
        private void clearFields() {
            idField.setText("");
            titleField.setText("");
            origPriceField.setText("");
            discPriceField.setText("");
            donorField.setText("");
            extraField.setText("");
        }
        
        private void loadSampleData() {
            listings.add(new MealListing("M001", "Vegan Buddha Bowl", 12.50, 5.00, "DNR-101", "Vegan", "19:30"));
            listings.add(new BakeryListing("B001", "Sourdough Bread Loaf", 4.50, 2.00, "DNR-102", false, "2026-11-08"));
            refreshTable();
        }
        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new FoodListingGUI().setVisible(true);
            });
        }
        
    }

