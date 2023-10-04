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

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Test/src/gui/recources/logo.png");
    public TerminalWindow(String name){
        super(name);

        activePanel = new JPanel();
        this.add(activePanel);
        loginPanel();

        this.setVisible(true);
        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setIconImage(logo);
        
    }

    public TerminalWindow(Store store){
        this(store.name());

        this.store = store;
        
    }

    private void loginPanel(){
        activePanel.removeAll();
        activePanel.setLayout(new FlowLayout());
        
        // Admin Button
        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(event -> onAdminClick());
        activePanel.add(adminButton);

        // Customer Button
        JButton customerButton = new JButton("Customer");
        customerButton.addActionListener(event -> onCustomerClick());
        activePanel.add(customerButton);
    
    }

    protected void onAdminClick(){
        // Reset Panel
        this.remove(activePanel);
        this.repaint();

        System.out.println("Admin Button Clicked");

        // activePanel =  
    }
    protected void onCustomerClick(){
        System.out.println("Customer Button Clicked");
    }
}
