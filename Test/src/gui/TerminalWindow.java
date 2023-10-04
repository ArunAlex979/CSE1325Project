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

        // Create Fields
        JButton pastOrdersButton = new JButton("");
        JButton customerInfoButton = new JButton("");
        JButton inventoryButton = new JButton("");
        JButton logoutButton = new JButton("");
        // Add Listeners
        adminButton   .addActionListener(event -> onAdminClick());
        customerButton.addActionListener(event -> onCustomerClick());

        // Add Buttons
        bootPanel.add(adminButton);
        bootPanel.add(customerButton);

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


        setActivePanel(bootPanel);

        this.add(activePanel);
        this.setVisible(true);
        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public TerminalWindow(Store store){
        this(store.name());

        this.store = store;
        
    }

    private void setActivePanel(JPanel panel){
        activePanel.removeAll();
        this.activePanel = panel;
    }

    protected void onAdminClick(){
        // Reset Panel
        this.remove(activePanel);
        this.repaint();

        System.out.println("Admin Button Clicked");
        
    }
    protected void onCustomerClick(){
        System.out.println("Customer Button Clicked");
    }
}
