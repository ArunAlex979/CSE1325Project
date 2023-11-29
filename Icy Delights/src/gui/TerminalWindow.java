package gui;

import store.*;

import java.util.*;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalWindow  extends JFrame{
    
    private Store store;
    private Customer currentCustomer;
    private Order currentOrder;
    private File fileName = new File("Icy Delights\\src\\gui\\recources\\SavedInfo.txt");

    private JPanel activePanel;
    private JPanel bootPanel;
    private JPanel adminPanel;
    private JPanel customerPanel;
    private JPanel inventoryPanel;
    private JPanel finishPanel;
    private JPanel previousOrNewCustomerPanel;
    private JPanel previousCustomerPanel;
    private JPanel newCustomerPanel;

    private JButton returnButton;
    private JButton addItemButton;

    JButton [] flavorButtons;

    private TextField textRow1;

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Icy Delights\\src\\gui\\recources\\logoICY.png");
    
    public TerminalWindow(String name) throws IOException{
        store = new Store(name);
        onLoadClick();
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

        // adminPanel = new JPanel();

        JToolBar toolbar = new JToolBar("Icy Delights Toolbar");
        toolbar.setOrientation(1);
        toolbar.add(Box.createVerticalGlue());


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Boot Panel //////////////////////////////////////////////////////////////////////////////////////

        // We are using BorderLayout for the boot panael 
        bootPanel = new JPanel(new BorderLayout(100,100));

        // Create Fields
        JButton logoBootPanel  = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logo.png")); 
        JButton adminButton    = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton customerButton = new JButton("ORDER NOW!");
      
        // Color Change for the buttons
        adminButton   .setBackground(colors[4]);
        customerButton.setBackground(colors[4]);
        logoBootPanel .setBackground(colors[4]);

        // Add Listeners
        adminButton   .addActionListener(event -> onInventoryClick());
        customerButton.addActionListener(event -> onOrderNowClick());

        // Add Buttons
        bootPanel.add(adminButton, BorderLayout.SOUTH);
        bootPanel.add(logoBootPanel, BorderLayout.NORTH);
        bootPanel.add(customerButton, BorderLayout.CENTER);

        Font myFont    = new Font("Ink Free",Font.BOLD,30);
        Font smallFont = new Font("Ink Free",Font.BOLD,20);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // New or Previous  Customer Panel /////////////////////////////////////////////////////////////////
        previousOrNewCustomerPanel = new JPanel(new BorderLayout(100,100));
        
        // Create Fields
        JButton logoPreviousOrNewCustomerPanel        = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logo.png")); 
        JButton PreviousOrNewCustomerPanelAdminButton = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton previousCustomerButton                = new JButton("Previous Customer");
        JButton newCustomerButton                     = new JButton("New Customer");
        
        // Color Change for the buttons
        logoPreviousOrNewCustomerPanel       .setBackground(colors[4]);
        PreviousOrNewCustomerPanelAdminButton.setBackground(colors[4]);
        previousCustomerButton               .setBackground(colors[4]);
        newCustomerButton                    .setBackground(colors[4]);
        previousCustomerButton               .setFont(myFont);
        newCustomerButton                    .setFont(myFont);

        // Add Buttons
        previousOrNewCustomerPanel.add(PreviousOrNewCustomerPanelAdminButton, BorderLayout.SOUTH);
        previousOrNewCustomerPanel.add(logoPreviousOrNewCustomerPanel, BorderLayout.NORTH);
        previousOrNewCustomerPanel.add(previousCustomerButton, BorderLayout.WEST);
        previousOrNewCustomerPanel.add(newCustomerButton, BorderLayout.CENTER);

        // Add Listeners
        PreviousOrNewCustomerPanelAdminButton.addActionListener(event -> onAdminClick());
        previousCustomerButton               .addActionListener(event -> previousCustomerPanelClick());
        newCustomerButton                    .addActionListener(event -> onNewCustomerClick());

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Previous Customer Panel /////////////////////////////////////////////////////////////////////////

        previousCustomerPanel = new JPanel();

        // Create Fields
        JTextField inputPhoneNumber = new JTextField(20);

        JButton logopreviousCustomerPanel        = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoD.png")); 
        JButton previousCustomerPanelAdminButton = new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton previousCustomerPanelPhoneNumber = new JButton("Enter Your Phone Number");
        JButton previousCustomerPanelSubmit      = new JButton("Submit");

        // Color Change for the buttons
        logopreviousCustomerPanel       .setBackground(colors[4]);
        previousCustomerPanelAdminButton.setBackground(colors[4]);
        previousCustomerPanelPhoneNumber.setBackground(colors[4]);
        previousCustomerPanelSubmit     .setBackground(colors[4]);
        previousCustomerPanelPhoneNumber.setFont(myFont);
        previousCustomerPanelSubmit     .setFont(myFont);
        inputPhoneNumber                .setFont(myFont);
        // Add Buttons
        previousCustomerPanel.add(logopreviousCustomerPanel);
        previousCustomerPanel.add(previousCustomerPanelPhoneNumber);
        previousCustomerPanel.add(inputPhoneNumber);
        previousCustomerPanel.add(previousCustomerPanelSubmit);
        previousCustomerPanel.add(previousCustomerPanelAdminButton);

        // Add Listeners
        previousCustomerPanelAdminButton.addActionListener(event -> onLogoutClick());
        previousCustomerPanelSubmit     .addActionListener(event -> searchPhoneNumber(inputPhoneNumber));    

        previousCustomerPanel.setLayout(new GridLayout(5, 0, 20, 30));

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Customer Panel //////////////////////////////////////////////////////////////////////////////////
 
        // Setup Panel
        customerPanel = new JPanel();

        // Create Fields
                  textRow1 = new TextField(20);
        TextField textRow2 = new TextField(20);
        TextField textRow3 = new TextField(20);
        TextField textRow4 = new TextField(20);
        textRow1.setFont(smallFont);
        textRow2.setFont(smallFont);
        textRow3.setFont(smallFont);
        textRow4.setFont(smallFont);

	
        JButton logoCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton customerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton customerPanelBackButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\back.png"));
        JButton finish       = new JButton("Finish");
        createFlavorButtons();
       

       // Changing the color of the button. 
       
        customerPanelAdminButton.setBackground(colors[4]);
        logoCustomerPanel.setBackground(colors[4]);
        customerPanelBackButton.setBackground(colors[4]);
        finish.setBackground(Color.MAGENTA);
        
        // Add Listeners
        customerPanelAdminButton   .addActionListener(event -> onLogoutClick());
        
        customerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add Buttons
        c.weightx = .5;
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        customerPanel.add(logoCustomerPanel,c);
        c.gridx = 1;
        customerPanel.add(textRow1,c);
        c.gridx = 2;
        customerPanel.add(customerPanelAdminButton,c);
        int numButtons = flavorButtons.length;
        int count = 0;
        c.ipady = (int) ((tk.getScreenSize().getHeight()-logoCustomerPanel.getHeight())/(numButtons*4/3));
        c.fill = GridBagConstraints.HORIZONTAL;
        for(int y = 1;y<=numButtons/2.0+1;y++){
            for(int x = 0;x<2;x++,count++){
                if(count == numButtons) break;
                c.gridx = x;
                c.gridy = y;
                 customerPanel.add(flavorButtons[count],c);
                 System.out.println(count);
            }
        }
        c.gridheight = (int) (numButtons/4.0+1);
        c.gridx = 2;
        c.gridy =  4;      
        c.fill = GridBagConstraints.BOTH;
        customerPanel.add(finish,c);
   
        finish.addActionListener(event -> onFinishClick());
        customerPanelBackButton.addActionListener(event -> onOrderNowClick());
        

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Finish Panel ////////////////////////////////////////////////////////////////////////////////////
    


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inventory Panel /////////////////////////////////////////////////////////////////////////////////

        //Set Up Panel
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        //Create fields
        returnButton = new JButton("Return");
        addItemButton = new JButton("Add Item");

        // Add Listeners
        returnButton.addActionListener(event -> setActivePanel(bootPanel));
        addItemButton.addActionListener(event -> onNewItemClick());

        //Add Fields
        inventoryPanel.add(new JLabel(String.format("%-7s %-15s %-4s %-15s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        inventoryPanel.add(addItemButton);
        inventoryPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Set up JFrame /////////////////////////////////////////////////////////////////////////////////// 

        activePanel    = new JPanel();
        
        setActivePanel(bootPanel);
        this.setName(name);
        this.setIconImage(logo);
        this.setSize(1500,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        
    }

    protected void onSaveClick(){
        System.out.println("Save Button Clicked");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            store.save(bw);
            bw.close();
        }catch(Exception e){
            System.out.println(fileName.toPath());
            JOptionPane.showMessageDialog(this,"Saving to the file " + fileName + "has failed miserably because " + e,"How About Do Better Next Time :)",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    protected void onLoadClick(){
        System.out.println("Load Button Clicked");
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            store.load(br);
            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Now is " + fileName + "even a real file because the computer says " + e,"Nice Try",JOptionPane.ERROR_MESSAGE);
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

    protected void onInventoryClick(){
        
        System.out.println("Inventory Button Clicked");

        updateInventoryPanel();

        setActivePanel(inventoryPanel);

        ArrayList<Item> inventory = store.inventory();
        System.out.printf("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity");
        for(int x = 0;x<inventory.size();x++){
            System.out.println(inventory.get(x));
        }

    }

    protected void onLogoutClick(){
        
        System.out.println("Logout Button Clicked");

        setActivePanel(bootPanel);

    }
    protected void onOrderNowClick(){

        System.out.println("Customer Button Clicked");

        setActivePanel(previousOrNewCustomerPanel);
    }
    protected void orderonCustomerClick(){

        System.out.println(" Order Customer Button Clicked");
        currentOrder = new Order(currentCustomer.fullName());
        setActivePanel(customerPanel);
        
    }
    protected void previousCustomerPanelClick(){

        System.out.println("Previous Customer Panel Button Clicked");

         setActivePanel(previousCustomerPanel);

    }

    protected void onNewItemClick(){
        Object [] itemTypes = {ItemType.FLAVOR,ItemType.TOPPING};

        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField numberInStock = new JTextField();

        JComboBox<ItemType> itemType = new JComboBox(itemTypes);

        Object [] infoNeeded = {"Item Name",itemName,"Item Type",itemType,"Number in Stock", numberInStock};
        
        int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Item", JOptionPane.OK_CANCEL_OPTION);
        
        if(button == JOptionPane.OK_OPTION){
            store.add(new Item(itemName.getText(),(ItemType) itemType.getSelectedItem(),Long.parseLong(numberInStock.getText())));
            updateInventoryPanel();
            setActivePanel(inventoryPanel);
        }
        onSaveClick();
    }

    protected void onNewCustomerClick(){

        JTextField name = new JTextField();
        JTextField phoneNumber = new JTextField();
        JTextField email = new JTextField();

        Object [] infoNeeded = {"Name",name,"Phone Number",phoneNumber,"Email Address", email};
        
        int button = JOptionPane.showConfirmDialog(this, infoNeeded, "New Customer", JOptionPane.OK_CANCEL_OPTION);
        
        if(button == JOptionPane.OK_OPTION){
            // String firstName, String lastName, String email, Short phoneNumber
            String [] fullName = name.getText().split(" ");
            if (fullName.length == 2) {
            currentCustomer = new Customer(fullName[0],fullName[1],email.getText(),Long.parseLong(phoneNumber.getText()));
            store.add(currentCustomer);
            orderonCustomerClick();
            textRow1.setText("Welcome To Icy Delights "+currentCustomer.firstName());
            }
            else 
            JOptionPane.showMessageDialog(this,"Invalid name, \"FirstName LastName\" only","Invalid Name",JOptionPane.ERROR_MESSAGE);
        }
        
        if(button == JOptionPane.OK_OPTION){
            
        }

        onSaveClick();
    }

    protected void updateInventoryPanel(){
        inventoryPanel.removeAll();

        inventoryPanel.add(new JLabel(String.format("%-7s %-20s %-7s %-20s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));
        
        ArrayList<Item> inventory = store.inventory();
        for(int x = 0;x<inventory.size();x++){
            inventoryPanel.add(new JLabel(inventory.get(x).toString()));
        }

        inventoryPanel.add(addItemButton);
        inventoryPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);

        
        
    }


    protected void searchPhoneNumber(JTextField inputPhoneNumber){
        String phoneNumberToSearch = inputPhoneNumber.getText();
        String standardizedPhoneNumber = phoneNumberToSearch.replaceAll("[\\s\\-\\(\\)]+", "");
        Customer customer = store.findCustomer(Long.parseLong(standardizedPhoneNumber));
        int submit = JOptionPane.showConfirmDialog(this,"Are you looking for " + customer.firstName() + "?","Customer search",JOptionPane.YES_NO_OPTION);
        if(submit == JOptionPane.YES_OPTION){
            currentCustomer = customer;
            orderonCustomerClick();
            textRow1.setText("Welcome To Icy Delights "+currentCustomer.firstName());
        }
    }

    protected void createFlavorButtons(){
        flavorButtons = new JButton[store.inventory().size()];
        
        for(int i=0;i<store.inventory().size();i++){
        final String flavor = store.inventory().get(i).label();
        flavorButtons[i] = new JButton(flavor);
        flavorButtons[i].addActionListener(event -> buyIceCream(flavor));
        }
    }

    protected void buyIceCream(String s){
        currentOrder.addItem(store.buyIceCream(s));
        System.out.println("yummy "+store.buyIceCream(s));
        onSaveClick();
    }

    protected void onFinishClick(){
        int button = JOptionPane.showConfirmDialog(this, String.format( "%s would you like to checkout for $%.2f",currentCustomer.firstName(),currentOrder.orderTotal()), "Finish & Pay", JOptionPane.OK_CANCEL_OPTION);
        if(button == JOptionPane.OK_OPTION){
            try{
                currentOrder.save();
                currentCustomer.addOrder(currentOrder);
                onSaveClick();
            }catch(IOException e){
                System.out.println(e);
            }
            setActivePanel(bootPanel);
        }
    }
}
