package gui;

import store.*;

import javax.swing.*;

import java.awt.*;
import java.awt.image.*;

import java.io.*;

public class TerminalWindow extends JFrame{
    
    private Store store;
    private JLabel display;
    private File fileName;

    private JPanel activePanel;
    private JPanel bootPanel;
    private JPanel adminPanel;
    private JPanel customerPanel;
    private JPanel inventoryPanel;

    private JFrame newItemFrame;

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Test/src/gui/recources/logo.png");
    public TerminalWindow(String name){
        
        

        // Set up JFrame
        this.setName(name);
        this.setIconImage(logo);

        // Initialize Panels
        activePanel    = new JPanel();
        adminPanel     = new JPanel();
        bootPanel      = new JPanel();
        customerPanel  = new JPanel();
        inventoryPanel = new JPanel();

        //////////////////////////////////////////////////
        // Admin Panel ///////////////////////////////////

        // Create Toolbar
        JToolBar toolbar = new JToolBar("Icy Delights Toolbar");
        toolbar.setOrientation(1);
        toolbar.add(Box.createVerticalGlue());
        
        // Create Fields
        JButton customerInfoButton = new JButton("Customer Info");
        JButton inventoryButton    = new JButton("Inventory");
        JButton logoutButton       = new JButton("Logout");
        JButton pastOrdersButton   = new JButton("Past Orders");
        

        // Add Listeners
        customerInfoButton.addActionListener(event -> onCustomerInfoClick());
        inventoryButton   .addActionListener(event -> onInventoryClick());
        logoutButton      .addActionListener(event -> onLogoutClick());
        pastOrdersButton  .addActionListener(event -> onPastOrdersClick());

        // Add Buttons
        toolbar   .add(customerInfoButton);
        toolbar   .add(inventoryButton);
        toolbar   .add(logoutButton);
        toolbar   .add(pastOrdersButton);
        adminPanel.add(toolbar, BorderLayout.PAGE_START);


        //////////////////////////////////////////////////
        // Boot Panel ////////////////////////////////////


        // Create Fields
        JButton adminButton    = new JButton("Admin");
        JButton customerButton = new JButton("Customer");
        
        // Add Listeners
        adminButton   .addActionListener(event -> onAdminClick());
        customerButton.addActionListener(event -> onCustomerClick());

        // Add Buttons
        bootPanel.add(adminButton);
        bootPanel.add(customerButton);

        //////////////////////////////////////////////////
        // Customer Panel ////////////////////////////////
 
       // Create Fields
        JButton iceCreamButton    = new JButton("Ice Cream");
        
        // Add Listeners
        iceCreamButton   .addActionListener(event -> onLogoutClick());

        // Add Buttons
        customerPanel.add(iceCreamButton);

        store = new Store(name);

        setActivePanel(bootPanel);

        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public TerminalWindow(Store store){
        this(store.name());

        this.store = store;
        
    }

    private void setActivePanel(JPanel panel){
        this.remove(activePanel);
        this.activePanel = panel;
        this.add(activePanel);
        this.setVisible(true);
        this.repaint();
    }

    protected void onAdminClick(){

        System.out.println("Admin Button Clicked");

        setActivePanel(adminPanel);
    }
    protected void onPastOrdersClick(){
        
        System.out.println("Past Orders Button Clicked");

    }
    protected void onCustomerInfoClick(){
        
        System.out.println("Customer Info Button Clicked");
        
    }
    protected void onInventoryClick(){
        
        System.out.println("Inventory Button Clicked");

        onNewItemClick();

        repaintInventoryPanel();

        adminPanel.add(inventoryPanel,CENTER_ALIGNMENT);
        adminPanel.repaint();
        this.repaint();
        Object [] inventory = store.inventory();
        for(int x = 0;x<inventory.length;x++){
            System.out.println(inventory[x]);
        }

    }
    protected void onLogoutClick(){
        
        System.out.println("Logout Button Clicked");

        setActivePanel(bootPanel);

    }
    protected void onCustomerClick(){

        System.out.println("Customer Button Clicked");

        setActivePanel(customerPanel);
    }

    protected void onNewItemClick(){
        Object [] itemTypes = {ItemType.CONSUMABLE,ItemType.SUPPLIES,ItemType.MERCHANDISE};
        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField numberInStock = new JTextField();
        JComboBox<ItemType> itemType = new JComboBox(itemTypes);
        Object [] infoNeeded = {"Item Name",itemName,"Item Price",itemPrice,"Item Type",itemType,"Number in Stock", numberInStock};
        //int button = JOptionPane.showInputDialog(this, infoNeeded, "New Computer", JOptionPane.OK_CANCEL_OPTION);
        int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        if(button == JOptionPane.OK_OPTION){
            store.add(new Item(itemName.getText(),Long.parseLong(itemPrice.getText()),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
        }
        
    }
    protected void repaintInventoryPanel(){
        inventoryPanel.removeAll();

        
        Object [] inventory = store.inventory();

        for(int x = 0;x<inventory.length;x++){
            inventoryPanel.add(new JLabel(inventory[x].toString()));
        }
        
    }
}
