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

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Test/src/gui/recources/logo.png");
    public TerminalWindow(String name){
        
        // Set up JFrame
        this.setName(name);
        this.setIconImage(logo);

        // Initialize Panels
        activePanel   = new JPanel();
        adminPanel    = new JPanel();
        bootPanel     = new JPanel();
        customerPanel = new JPanel();

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

    }
    protected void onLogoutClick(){
        
        System.out.println("Logout Button Clicked");

        setActivePanel(bootPanel);

    }
    protected void onCustomerClick(){

        System.out.println("Customer Button Clicked");

        setActivePanel(customerPanel);
    }
}
