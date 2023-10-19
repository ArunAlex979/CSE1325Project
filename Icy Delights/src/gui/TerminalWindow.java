package gui;

import store.*;

import javax.swing.*;

import java.awt.*;

import java.io.*;

public class TerminalWindow extends JFrame{
    
    private Store store;
    private File fileName = new File("Icy Delights\\src\\gui\\recources\\SavedInfo.txt");

    private JPanel activePanel;
    private JPanel bootPanel;
    private JPanel adminPanel;
    private JPanel customerPanel;
    private JPanel inventoryPanel;
    private JPanel menuPanel;

    private JButton returnButton;
    private JButton addItemButton;
    private JButton addProductButton;

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Icy Delights\\src\\gui\\recources\\logo.png");
    
    public TerminalWindow(String name){

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Admin Panel /////////////////////////////////////////////////////////////////////////////////////

        adminPanel = new JPanel();

        JToolBar toolbar = new JToolBar("Icy Delights Toolbar");
        toolbar.setOrientation(1);
        toolbar.add(Box.createVerticalGlue());
        
        // Create Fields
        JButton customerInfoButton = new JButton("Customer Info");
        JButton inventoryButton    = new JButton("Inventory");
        JButton logoutButton       = new JButton("Logout");
        JButton menuButton         = new JButton("Menu");
        JButton pastOrdersButton   = new JButton("Past Orders");
        JButton saveButton         = new JButton("Save");
        JButton loadButton         = new JButton("Load");

        // Add Listeners
        customerInfoButton.addActionListener(event -> onCustomerInfoClick());
        inventoryButton   .addActionListener(event -> onInventoryClick());
        logoutButton      .addActionListener(event -> onLogoutClick());
        menuButton        .addActionListener(event -> onMenuClick());
        pastOrdersButton  .addActionListener(event -> onPastOrdersClick());
        saveButton        .addActionListener(event -> onSaveClick());
        loadButton        .addActionListener(event -> onLoadClick());

        // Add Buttons
        toolbar   .add(customerInfoButton);
        toolbar   .add(inventoryButton);
        toolbar   .add(logoutButton);
        toolbar   .add(menuButton);
        toolbar   .add(pastOrdersButton);
        toolbar   .add(saveButton);
        toolbar   .add(loadButton);
        adminPanel.add(toolbar, BorderLayout.PAGE_START);
        


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Boot Panel //////////////////////////////////////////////////////////////////////////////////////

        bootPanel = new JPanel();

        // Create Fields
        JButton adminButton    = new JButton("Admin");
        JButton customerButton = new JButton("Customer");
        
        // Add Listeners
        adminButton   .addActionListener(event -> onAdminClick());
        customerButton.addActionListener(event -> onCustomerClick());

        // Add Buttons
        bootPanel.add(adminButton);
        bootPanel.add(customerButton);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Customer Panel //////////////////////////////////////////////////////////////////////////////////
 
        // Setup Panel
        customerPanel  = new JPanel();

        // Create Fields
        JButton iceCreamButton    = new JButton("Ice Cream");

        // Add Listeners
        iceCreamButton   .addActionListener(event -> onLogoutClick());

        // Add Buttons
        customerPanel.add(iceCreamButton);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inventory Panel /////////////////////////////////////////////////////////////////////////////////

        //Set Up Panel
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        //Create fields
        returnButton = new JButton("Return");
        addItemButton = new JButton("Add Item");

        // Add Listeners
        returnButton.addActionListener(event -> setActivePanel(adminPanel));
        addItemButton.addActionListener(event -> onNewItemClick());

        //Add Fields
        inventoryPanel.add(new JLabel(String.format("%-7s %-15s %-4s %-15s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        inventoryPanel.add(addItemButton);
        inventoryPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Product Panel /////////////////////////////////////////////////////////////////////////////////// 

        // Setup Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        // Create Fields
        addProductButton = new JButton("Add Product");
        
        // Add Listeners
        addProductButton.addActionListener(event -> onNewProductClick());

        // Add Buttons
        menuPanel.add(addProductButton);
        menuPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Set up JFrame /////////////////////////////////////////////////////////////////////////////////// 

        activePanel    = new JPanel();
        store = new Store(name);
        setActivePanel(bootPanel);
        this.setName(name);
        this.setIconImage(logo);
        this.setSize(800,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public TerminalWindow(Store store){
        this(store.name());
    }

    protected void onSaveClick(){
        System.out.println("Save Button Clicked");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("fileName"));
            store.save(bw);
            bw.close();
        }catch(Exception e){
            System.out.println(fileName.toPath());
            JOptionPane.showMessageDialog(this,"Im going to kms " + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }

    protected void onLoadClick(){
        System.out.println("Load Button Clicked");
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            store.close();
            store.load(br);
            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Unable to can PLEASE PLEASE PLEASE" + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
        }
        
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

        updateInventoryPanel();

        setActivePanel(inventoryPanel);

        Object [] inventory = store.inventory();
        System.out.printf("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity");
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
    protected void onProductsClick(){

        System.out.println("Products Button Clicked");

        setActivePanel(menuPanel);
    }

    protected void onNewItemClick(){
        Object [] itemTypes = {ItemType.CONSUMABLE,ItemType.SUPPLIES,ItemType.MERCHANDISE};

        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField numberInStock = new JTextField();

        JComboBox<ItemType> itemType = new JComboBox(itemTypes);

        Object [] infoNeeded = {"Item Name",itemName,"Item Price",itemPrice,"Item Type",itemType,"Number in Stock", numberInStock};
        
        int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        
        if(button == JOptionPane.OK_OPTION){
            store.add(new Item(itemName.getText(),Integer.parseInt(itemPrice.getText()),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
            updateInventoryPanel();
            setActivePanel(inventoryPanel);
        }
        
    }
    protected void updateInventoryPanel(){
        inventoryPanel.removeAll();

        inventoryPanel.add(new JLabel(String.format("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        
        Object [] inventory = store.inventory();
        for(int x = 0;x<inventory.length;x++){
            inventoryPanel.add(new JLabel(inventory[x].toString()));
        }

        inventoryPanel.add(addItemButton);
        inventoryPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        
    }
    protected void updateMenuPanel(){
        menuPanel.removeAll();

        // menuPanel.add(new JLabel(String.format("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        
        Object [] inventory = store.inventory();
        for(int x = 0;x<inventory.length;x++){
            inventoryPanel.add(new JLabel(inventory[x].toString()));
        }

        menuPanel.add(addProductButton);
        menuPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        
    }
    protected void onMenuClick(){

        System.out.println("Menu Button Clicked");

        setActivePanel(menuPanel);
        
    }
    protected void onNewProductClick(){
        Object [] itemTypes = {ItemType.CONSUMABLE,ItemType.MERCHANDISE};
        Object [] possibleIngredients = store.inventory();

        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField numberInStock = new JTextField();

        JComboBox<ItemType> itemType = new JComboBox(itemTypes);
        

        Object [] infoNeeded = {"Item Name",itemName,"Item Price",itemPrice,"Item Type",itemType,"Number in Stock", numberInStock};
        
        int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        
        if(button == JOptionPane.OK_OPTION){
            store.add(new Item(itemName.getText(),Integer.parseInt(itemPrice.getText()),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
            updateInventoryPanel();
            setActivePanel(inventoryPanel);
        }
    }
}
