package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TerminalWindow extends JFrame{
    
  //  private Store store;

    private JPanel activePanel;
    private JPanel bootPanel;
    private JPanel adminPanel;
    private JPanel customerPanel;
    private JPanel inventoryPanel;
    private JPanel finishPanel;
    private JPanel menuPanel;

    private JButton returnButton;
    private JButton addItemButton;
    private JButton addProductButton;

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Icy Delights\\src\\gui\\recources\\logoICY.png");
    
    public TerminalWindow(String name){



        /* 
	This is the background color for the frame that is used
	in the main window.
	Found the RGB numbers using "Windows Paint" color picker tool to color match
	Changed the background of the buttom to match the background of the frame. 
	*/
	Color colors[] = new Color[5];
	colors[4] = new Color(238,238,238);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Admin Panel /////////////////////////////////////////////////////////////////////////////////////

        adminPanel = new JPanel();

        JToolBar toolbar = new JToolBar("Icy Delights Toolbar");
       // toolbar.setOrientation(1);
      //  toolbar.add(Box.createVerticalGlue());
        
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
     //   inventoryButton   .addActionListener(event -> onInventoryClick());
        logoutButton      .addActionListener(event -> onLogoutClick());
        menuButton        .addActionListener(event -> onMenuClick());
        pastOrdersButton  .addActionListener(event -> onPastOrdersClick());
      //  saveButton        .addActionListener(event -> onSaveClick());
      //  loadButton        .addActionListener(event -> onLoadClick());
      

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

// We are using BorderLayout for the boot panael 
       bootPanel = new JPanel(new BorderLayout(100,100));

        //bootPanel.setBackground(Color.gray);



        // Create Fields
        JButton logoBootPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logo.png")); 

       // JButton adminButton    = new JButton("Admin");
        JButton adminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));

        JButton customerButton = new JButton("ORDER NOW!");
        // Color Change for the buttons
        adminButton.setBackground(colors[4]);
        customerButton.setBackground(colors[4]);
        logoBootPanel.setBackground(colors[4]);
        // Add Listeners
        adminButton   .addActionListener(event -> onAdminClick());
        customerButton.addActionListener(event -> onCustomerClick());

        // Add Buttons
        bootPanel.add(adminButton, BorderLayout.SOUTH);
      
        
        bootPanel.add(logoBootPanel, BorderLayout.NORTH);

        bootPanel.add(customerButton, BorderLayout.CENTER);


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Customer Panel //////////////////////////////////////////////////////////////////////////////////
 
        // Setup Panel
        customerPanel = new JPanel();
        Font myFont = new Font("Ink Free",Font.BOLD,30);
        Font smallFont = new Font("Ink Free",Font.BOLD,20);
  

        JTextField textfield;
	
       
       //    customerPanel  = new JPanel(new BorderLayout(100,100));  
 
      //  customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));
        
        // Create Fields
        textfield = new JTextField();
        TextField text = new TextField(20);
        text.setFont(smallFont);

		textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        JButton logoCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton logo2CustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton customerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton vanilla       = new JButton("Vanilla");
        JButton chocolate     = new JButton("Chocolate");
        JButton strawberry    = new JButton("Strawberry");
        JButton mint          = new JButton("Mint");
        JButton cookieDough   = new JButton("Cookie Dough");
        JButton rockyRoad     = new JButton("Rocky Road");
        JButton mocha         = new JButton("Mocha");
        JButton coffee        = new JButton("Coffee");
        
        JButton banana        = new JButton("Banana");
        JButton peach         = new JButton("Peach");
        JButton finish       = new JButton("Finish");
       

       // Changing the color of the button. 
       
    customerPanelAdminButton.setBackground(colors[4]);
    logoCustomerPanel.setBackground(colors[4]);
    logo2CustomerPanel.setBackground(colors[4]);
        
        // Add Listeners
        customerPanelAdminButton   .addActionListener(event -> onLogoutClick());


        // Add Buttons
    customerPanel.add(logoCustomerPanel);
    customerPanel.add(logo2CustomerPanel);
    customerPanel.add(customerPanelAdminButton);
    customerPanel.add(vanilla);
    customerPanel.add(chocolate);
    customerPanel.add(strawberry);
    customerPanel.add(mint);
    customerPanel.add(cookieDough);
    customerPanel.add(rockyRoad);
    customerPanel.add(mocha);
    customerPanel.add(coffee);
    customerPanel.add(finish);
    customerPanel.add(banana);
    customerPanel.add(peach);
    customerPanel.add(textfield);
    customerPanel.add(text);

   // vanilla.addActionListener(event -> textfield.setText("Added Vanilla ice cream"));
    vanilla.addActionListener(event -> addOnClick());
    finish.addActionListener(event -> finishOnClick());
    customerPanel.setLayout(new GridLayout(5, 5, 20, 30));

    // ActionListener for button click
    ActionListener buttonClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Button Clicked");
        }
    };

     ActionListener vanillaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Vanilla Button Clicked");
        }
    };
     ActionListener chocolateClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Chocolate Button Clicked");
        }
    };
     ActionListener strawberryClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Strawberry Button Clicked");
        }
    };
     ActionListener mintClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Mint Button Clicked");
        }
    };
     ActionListener cookieDoughClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("CookieDough Button Clicked");
        }
    };
     ActionListener rockyRoadClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("RockyRoad Button Clicked");
        }
    };
     ActionListener mochaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Mocha Button Clicked");
        }
    };
     ActionListener coffeeClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Coffee Button Clicked");
        }
    };
     ActionListener bananaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Banana Button Clicked");
        }
    };
     ActionListener peachClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText("Peach Button Clicked");
        }
    };
   


    // Add ActionListener to buttons
    vanilla.addActionListener(vanillaClickListener);
    chocolate.addActionListener(chocolateClickListener);
    strawberry.addActionListener(strawberryClickListener);
    mint.addActionListener(mintClickListener);
    cookieDough.addActionListener(cookieDoughClickListener);
    rockyRoad.addActionListener(rockyRoadClickListener);
    mocha.addActionListener(mochaClickListener);
    coffee.addActionListener(coffeeClickListener);
    banana.addActionListener(bananaClickListener);
    peach.addActionListener(peachClickListener);
    finish.addActionListener(buttonClickListener);

    // Finish Panel
    finishPanel = new JPanel();
    JTextField totalFinishPanel;
    JTextField  nameFinishPanel;
    JTextField  phoneNumberFinishPanel;
    JTextField  emailFinishPanel;
   


        totalFinishPanel = new JTextField();
        nameFinishPanel = new JTextField();
        phoneNumberFinishPanel = new JTextField();
        emailFinishPanel = new JTextField();
        totalFinishPanel.setFont(myFont);

    JButton logofinishPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton logo2finishPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 

    JButton finishPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
   JButton nameLogo       = new JButton("Enter Your Name Here -->");
   JButton phoneLogo       = new JButton("Enter Your Phone Number Here -->");
   JButton emailLogo       = new JButton("Enter Your Email Here -->");
   JButton totalLogo       = new JButton("Your Total -->");
      
   JButton submitTotalLogo       = new JButton("Place Order");
   JButton submitNameLogo       = new JButton("Submit");
   JButton submitPhoneLogo       = new JButton("Submit");
   JButton submitEmailLogo       = new JButton("Submit");




    nameLogo.setFont(myFont);
    phoneLogo.setFont(myFont);
    emailLogo.setFont(myFont);
    totalLogo.setFont(myFont);

    submitTotalLogo.setFont(myFont);
    submitNameLogo.setFont(myFont);
    submitPhoneLogo.setFont(myFont);
    submitEmailLogo.setFont(myFont);

    // color 
    finishPanelAdminButton.setBackground(colors[4]);
    logofinishPanel.setBackground(colors[4]);
    logo2finishPanel.setBackground(colors[4]);
    nameLogo.setBackground(colors[4]);
    phoneLogo.setBackground(colors[4]);
    emailLogo.setBackground(colors[4]);
    totalLogo.setBackground(colors[4]);

   

    finishPanel.add(logofinishPanel);
    finishPanel.add(logo2finishPanel);
    finishPanel.add(finishPanelAdminButton);

    finishPanel.add(nameLogo);
    finishPanel.add(nameFinishPanel);
    finishPanel.add(submitNameLogo);

    finishPanel.add(phoneLogo);
    finishPanel.add(phoneNumberFinishPanel);
    finishPanel.add(submitPhoneLogo);

    finishPanel.add(emailLogo); 
    finishPanel.add(emailFinishPanel); 
    finishPanel.add(submitEmailLogo);

    finishPanel.add(totalLogo);
    finishPanel.add(totalFinishPanel);
    finishPanel.add(submitTotalLogo);

    
  
    finishPanelAdminButton   .addActionListener(event -> onLogoutClick());
   

  finishPanel.setLayout(new GridLayout(5, 3, 20, 30)); 


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
       // addItemButton.addActionListener(event -> onNewItemClick());

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
      //  addProductButton.addActionListener(event -> onNewProductClick());

        // Add Buttons
        menuPanel.add(addProductButton);
        menuPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Set up JFrame /////////////////////////////////////////////////////////////////////////////////// 

        activePanel    = new JPanel();
      //  store = new Store(name);
        setActivePanel(bootPanel);
        this.setName(name);
        this.setIconImage(logo);
        this.setSize(1500, 800); //1500, 800
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    // public TerminalWindow(Store store){
    //     this(store.name());
    // }

    // protected void onSaveClick(){
    //     System.out.println("Save Button Clicked");
    //     try{
    //         BufferedWriter bw = new BufferedWriter(new FileWriter("fileName"));
    //         store.save(bw);
    //         bw.close();
    //     }catch(Exception e){
    //         System.out.println(fileName.toPath());
    //         JOptionPane.showMessageDialog(this,"Im going to kms " + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
            
    //     }
        
    // }

    // protected void onLoadClick(){
    //     System.out.println("Load Button Clicked");
    //     try{
    //         BufferedReader br = new BufferedReader(new FileReader(fileName));
    //         store.close();
    //         store.load(br);
    //         br.close();
    //     }catch(Exception e){
    //         JOptionPane.showMessageDialog(this,"Unable to can PLEASE PLEASE PLEASE" + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
    //     }
        
    // }
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
    // protected void onInventoryClick(){
        
    //     System.out.println("Inventory Button Clicked");

    //     updateInventoryPanel();

    //     setActivePanel(inventoryPanel);

    //     Object [] inventory = store.inventory();
    //     System.out.printf("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity");
    //     for(int x = 0;x<inventory.length;x++){
    //         System.out.println(inventory[x]);
    //     }

    // }
    protected void onLogoutClick(){
        
        System.out.println("Logout Button Clicked");

        setActivePanel(bootPanel);

    }
   
      protected void addOnClick(){
        
        System.out.println("add Button Clicked");
       
        
        

    }
    protected void finishOnClick(){
        
        System.out.println("finish Button Clicked");
        setActivePanel(finishPanel);
        

    }
    protected void onCustomerClick(){

        System.out.println("Customer Button Clicked");

        setActivePanel(customerPanel);
    }
    protected void onProductsClick(){

        System.out.println("Products Button Clicked");

        setActivePanel(menuPanel);
    }

    // protected void onNewItemClick(){
    //     Object [] itemTypes = {ItemType.CONSUMABLE,ItemType.SUPPLIES,ItemType.MERCHANDISE};

    //     JTextField itemName = new JTextField();
    //     JTextField itemPrice = new JTextField();
    //     JTextField numberInStock = new JTextField();

    //     JComboBox<ItemType> itemType = new JComboBox(itemTypes);

    //     Object [] infoNeeded = {"Item Name",itemName,"Item Price",itemPrice,"Item Type",itemType,"Number in Stock", numberInStock};
        
    //     int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        
    //     if(button == JOptionPane.OK_OPTION){
    //         store.add(new Item(itemName.getText(),Integer.parseInt(itemPrice.getText()),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
    //         updateInventoryPanel();
    //         setActivePanel(inventoryPanel);
    //     }
        
    // }
    // protected void updateInventoryPanel(){
    //     inventoryPanel.removeAll();

    //     inventoryPanel.add(new JLabel(String.format("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        
    //     Object [] inventory = store.inventory();
    //     for(int x = 0;x<inventory.length;x++){
    //         inventoryPanel.add(new JLabel(inventory[x].toString()));
    //     }

    //     inventoryPanel.add(addItemButton);
    //     inventoryPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        
    // }
    // protected void updateMenuPanel(){
    //     menuPanel.removeAll();

    //     // menuPanel.add(new JLabel(String.format("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        
    //     Object [] inventory = store.inventory();
    //     for(int x = 0;x<inventory.length;x++){
    //         inventoryPanel.add(new JLabel(inventory[x].toString()));
    //     }

    //     menuPanel.add(addProductButton);
    //     menuPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        
    // }
    protected void onMenuClick(){

        System.out.println("Menu Button Clicked");

        setActivePanel(menuPanel);
        
    }
    // protected void onNewProductClick(){
    //     Object [] itemTypes = {ItemType.CONSUMABLE,ItemType.MERCHANDISE};
    //     Object [] possibleIngredients = store.inventory();

    //     JTextField itemName = new JTextField();
    //     JTextField itemPrice = new JTextField();
    //     JTextField numberInStock = new JTextField();

    //     JComboBox<ItemType> itemType = new JComboBox(itemTypes);
        

    //     Object [] infoNeeded = {"Item Name",itemName,"Item Price",itemPrice,"Item Type",itemType,"Number in Stock", numberInStock};
        
    //     int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        
    //     if(button == JOptionPane.OK_OPTION){
    //         store.add(new Item(itemName.getText(),Integer.parseInt(itemPrice.getText()),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
    //         updateInventoryPanel();
    //         setActivePanel(inventoryPanel);
    //     }
    // }
    
}
