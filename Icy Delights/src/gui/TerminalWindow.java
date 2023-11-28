package gui;
import store.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalWindow  extends JFrame{
    
    private Store store;
    private File fileName = new File("Icy Delights\\src\\gui\\recources\\SavedInfo.txt");

    private JPanel activePanel;
    private JPanel bootPanel;
    private JPanel adminPanel;
    private JPanel customerPanel;
    private JPanel inventoryPanel;
    private JPanel finishPanel;
    private JPanel menuPanel;
    private JPanel previousOrNewCustomerPanel;
    private JPanel previousCustomerPanel;
    private JPanel newCustomerPanel;

    private JButton returnButton;
    private JButton addItemButton;
    private JButton addProductButton;

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image logo = tk.getImage("Icy Delights\\src\\gui\\recources\\logoICY.png");
    
    public TerminalWindow(String name) throws IOException{

        /* 
	This is the background color for the frame that is used
	in the main window.
	Found the RGB numbers using "Windows Paint" color picker tool to color match
	Changed the background of the buttom to match the background of the frame. 
	*/
	Color colors[] = new Color[5];
	colors[4] = new Color(238,238,238);



        // cleares all of the data off the files 
    new FileWriter("total.txt", false).close();
    new FileWriter("orderCusINFO.txt", false).close();
    new FileWriter("order.txt", false).close();
    new FileWriter(" previousCustomerPanelcustomerPhoneOutput.txt", false).close();
    new FileWriter("currentOrderINFO.txt", false).close();
    new FileWriter("customerEmailOutput.txt", false).close();
    new FileWriter("customerNameOutput.txt", false).close();
    new FileWriter("customerPhone#Output.txt", false).close();
    new FileWriter("finishPageINFO.txt", false).close();

    try{
        FileWriter fstream = new FileWriter("finishPageINFO.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("YourName,1234567890,000");
        out.close();
    }catch (Exception e){
          System.err.println("Error while writing to file: " +
          e.getMessage());
    }


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Admin Panel /////////////////////////////////////////////////////////////////////////////////////

        adminPanel = new JPanel();

        JToolBar toolbar = new JToolBar("Icy Delights Toolbar");
        toolbar.setOrientation(1);
        toolbar.add(Box.createVerticalGlue());

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem quit       = new JMenuItem("Quit");

        JMenu     insert     = new JMenu("Insert");
        JMenuItem iCustomer  = new JMenuItem("Customer");
        JMenuItem iOption    = new JMenuItem("Option");
        JMenuItem iComputer  = new JMenuItem("Computer");
        
        JMenu     view       = new JMenu("View");
        JMenuItem vCustomer  = new JMenuItem("Customers");
        JMenuItem vOption    = new JMenuItem("Options");
        JMenuItem vComputer  = new JMenuItem("Computers");
        
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        
        setJMenuBar(menubar);
        // Create Fields
        JButton customerInfoButton = new JButton("Customer Info");
        JButton inventoryButton    = new JButton("Inventory");
        JButton logoutButton       = new JButton("Logout");
        JButton menuButton         = new JButton("Menu");
        JButton pastOrdersButton   = new JButton("Past Orders");
        JButton saveButton         = new JButton("Save");
        JButton loadButton         = new JButton("Load");

        // Add Listeners
        customerInfoButton.addActionListener(event -> onNewCustomerClick());
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

        // We are using BorderLayout for the boot panael 
       bootPanel = new JPanel(new BorderLayout(100,100));

        
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
        //customerButton.addActionListener(event -> onCustomerClick());
        customerButton.addActionListener(event -> onCustomerClick());

        // Add Buttons
        bootPanel.add(adminButton, BorderLayout.SOUTH);
      
        
        bootPanel.add(logoBootPanel, BorderLayout.NORTH);

        bootPanel.add(customerButton, BorderLayout.CENTER);


        Font myFont = new Font("Ink Free",Font.BOLD,30);
        Font smallFont = new Font("Ink Free",Font.BOLD,20);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // New or Previous  Customer Panel /////////////////////////////////////////////////////////////////
        previousOrNewCustomerPanel = new JPanel(new BorderLayout(100,100));
        
        // Create Fields

        JButton logoPreviousOrNewCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logo.png")); 
        JButton PreviousOrNewCustomerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton previousCustomerButton = new JButton("Previous Customer");
        JButton newCustomerButton = new JButton("New Customer");
        
        // Color Change for the buttons
        logoPreviousOrNewCustomerPanel.setBackground(colors[4]);
        PreviousOrNewCustomerPanelAdminButton.setBackground(colors[4]);
        previousCustomerButton.setBackground(colors[4]);
        newCustomerButton.setBackground(colors[4]);
        previousCustomerButton.setFont(myFont);
        newCustomerButton.setFont(myFont);

        // Add Buttons
        previousOrNewCustomerPanel.add(PreviousOrNewCustomerPanelAdminButton, BorderLayout.SOUTH);
        previousOrNewCustomerPanel.add(logoPreviousOrNewCustomerPanel, BorderLayout.NORTH);
        previousOrNewCustomerPanel.add(previousCustomerButton, BorderLayout.WEST);

        previousOrNewCustomerPanel.add(newCustomerButton, BorderLayout.CENTER);

        PreviousOrNewCustomerPanelAdminButton   .addActionListener(event -> onAdminClick());
        previousCustomerButton.addActionListener(event -> previousCustomerPanelClick());
        
        //newCustomerButton.addActionListener(event -> newCustomerClick());
        newCustomerButton.addActionListener(event -> orderonCustomerClick());


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Previous Customer Panel /////////////////////////////////////////////////////////////////////////

       // previousCustomerPanel = new JPanel(new BorderLayout(100,100));
        previousCustomerPanel = new JPanel();
        // Create Fields
        TextField inputPhoneNumber = new TextField(20);

        JButton logopreviousCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoD.png")); 
        JButton previousCustomerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton previousCustomerPanelPhoneNumber = new JButton("Enter Your Phone Number");
        JButton previousCustomerPanelSubmit = new JButton("Submit");

        // Color Change for the buttons
        logopreviousCustomerPanel.setBackground(colors[4]);
        previousCustomerPanelAdminButton.setBackground(colors[4]);
        previousCustomerPanelPhoneNumber.setBackground(colors[4]);
        previousCustomerPanelSubmit.setBackground(colors[4]);
        previousCustomerPanelPhoneNumber.setFont(myFont);
        previousCustomerPanelSubmit.setFont(myFont);
        inputPhoneNumber.setFont(myFont);
        // Add Buttons
        previousCustomerPanel.add(logopreviousCustomerPanel);
        previousCustomerPanel.add(previousCustomerPanelPhoneNumber);
        previousCustomerPanel.add(inputPhoneNumber);
        previousCustomerPanel.add(previousCustomerPanelSubmit);
        previousCustomerPanel.add(previousCustomerPanelAdminButton);

        previousCustomerPanelAdminButton   .addActionListener(event -> onLogoutClick());
        previousCustomerPanelSubmit.addActionListener(event -> orderonCustomerClick());
        previousCustomerPanel.setLayout(new GridLayout(5, 0, 20, 30));
      
   ActionListener inputPhoneNumberClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
           // customerName[0] = nameFinishPanel.getText();
            System.out.println("Phone Number: " + inputPhoneNumber.getText());

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("previousCustomerPanelcustomerPhoneOutput.txt"));
                writer.write(inputPhoneNumber.getText()+"\n" );

                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } 
        }

    };
 

      ActionListener searchPhoneNumberClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
            // searchPhoneNumber(inputPhoneNumber.getText());

           String filePath = "rewardsHistory.txt";
        
        String phoneNumberToSearch = inputPhoneNumber.getText();
        String  normalizePhoneNumber = phoneNumberToSearch.replaceAll("[\\s\\-\\(\\)]+", "");


 try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[1].equals(normalizePhoneNumber)) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    int rewardPoints = Integer.parseInt(parts[2]);


try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("currentOrderINFO.txt"));
        writer.write(name+","+phoneNumber+","+rewardPoints+"\n"  );


 try {
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("finishPageINFO.txt"));
        writer2.write(name+","+phoneNumber+","+rewardPoints+"\n"  );
         
        writer2.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    }



         if (phoneNumber != phoneNumberToSearch){
                        System.out.println("Phone Number not found");
                    }
        writer.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    } 
                    System.out.println("Name: " + name);
                    System.out.println("Phone Number: " + phoneNumber);
                    System.out.println("Reward Points: " + rewardPoints);
                   

                    break;
                }
            }

            // Close the file
            reader.close();


            


        } catch (IOException ei) {
            ei.printStackTrace();
        }
            
    
            }
    };

    previousCustomerPanelSubmit.addActionListener(searchPhoneNumberClickListener);

   // searchPhoneNumber(inputPhoneNumber.getText());

    previousCustomerPanelSubmit.addActionListener(inputPhoneNumberClickListener);


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // New Customer Panel //////////////////////////////////////////////////////////////////////////////

        newCustomerPanel = new JPanel();
        JButton logonewCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoD.png")); 
        JButton newCustomerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        
        JButton newCustomerPanelSubmit = new JButton("Submit");

       

        newCustomerPanel.add(logonewCustomerPanel);
        newCustomerPanel.add(newCustomerPanelAdminButton);
        newCustomerPanel.add(newCustomerPanelSubmit);

         newCustomerPanelAdminButton   .addActionListener(event -> onLogoutClick());

         
        //newCustomerPanel.add(new JLabel(String.format("%-7s %-15s %-4s %-15s %s%n","Bin #","Label","Price", "Item Type", "Quantity")));

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Customer Panel //////////////////////////////////////////////////////////////////////////////////
 
        // Setup Panel
        customerPanel = new JPanel();

       /* 
        JRadioButton vanillaButton; 
        JRadioButton ChocolateButton; 
        JRadioButton strawberryButton;

        ImageIcon vanillaIcon;
        
        ImageIcon ChocolateIcon;
        ImageIcon strawberryIcon;
        
        

        customerPanel.setLayout(new FlowLayout());

    // vanillaIcon = new ImageIcon("Icy Delights\\src\\gui\\recources\\vanilla.png");
    // ChocolateIcon = new ImageIcon("Icy Delights\\src\\gui\\recources\\chocolate.png");
    // strawberryIcon = new ImageIcon("Icy Delights\\src\\gui\\recources\\strawberry.png");
    
  //hotdogIcon = new ImageIcon("hotdog.png");
  //String pizza = "pizza"; 
  vanillaButton = new JRadioButton("Vanilla");
  ChocolateButton = new JRadioButton("Chocolate");
  strawberryButton = new JRadioButton("Strawberry");
  ButtonGroup group = new ButtonGroup();
    group.add(vanillaButton);
    group.add(ChocolateButton);
    group.add(strawberryButton);


// vanillaButton.setIcon(vanillaIcon);
// ChocolateButton.setIcon(ChocolateIcon);
// strawberryButton.setIcon(strawberryIcon);


vanillaButton.addActionListener(event -> TESTClick("Vanilla "));
ChocolateButton.addActionListener(event -> TESTClick("Chocolate "));
strawberryButton.addActionListener(event -> TESTClick("Strawberry "));

customerPanel.add(vanillaButton);
customerPanel.add(ChocolateButton);
customerPanel.add(strawberryButton);
*/
       // Create Fields
        TextField textRow1 = new TextField(20);
        TextField textRow2 = new TextField(20);
        TextField textRow3 = new TextField(20);
        TextField textRow4 = new TextField(20);
        textRow1.setFont(smallFont);
        textRow2.setFont(smallFont);
        textRow3.setFont(smallFont);
        textRow4.setFont(smallFont);

	
        JButton logoCustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton logo2CustomerPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
        JButton customerPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
        JButton customerPanelBackButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\back.png"));

        
        
        String vanillaString = "$2.45 Vanilla "; 
        String chocolateString = "$2.30 Chocolate ";
        String strawberryString = "$3.00 Strawberry ";
        String mintString = "$2.45 Mint ";
        String cookieDoughString = "$3.00 CookieDough ";
        String rockyRoadString = "$3.25 RockyRoad ";
        String mochaString = "$2.95 Mocha ";
        String coffeeString = "$2.50 Coffee ";
        String bananaString = "$2.50 Banana ";
        String peachString = "$3.00 Peach ";
        String caramelString = "$2.45 Caramel ";

        
        JButton vanilla       = new JButton(vanillaString);
        JButton chocolate     = new JButton(chocolateString);
        JButton strawberry    = new JButton(strawberryString);
        JButton mint          = new JButton(mintString);
        JButton cookieDough   = new JButton(cookieDoughString);
        JButton rockyRoad     = new JButton(rockyRoadString);
        JButton mocha         = new JButton(mochaString);
        JButton coffee        = new JButton(coffeeString);
        JButton caramel       = new JButton(caramelString);
        
        JButton banana        = new JButton(bananaString);
        JButton peach         = new JButton(peachString);
        JButton finish       = new JButton("Finish");
       

       // Changing the color of the button. 
       
    customerPanelAdminButton.setBackground(colors[4]);
    logoCustomerPanel.setBackground(colors[4]);
    logo2CustomerPanel.setBackground(colors[4]);
    customerPanelBackButton.setBackground(colors[4]);
    finish.setBackground(Color.MAGENTA);
        
        // Add Listeners
    customerPanelAdminButton   .addActionListener(event -> onLogoutClick());
    


// textRow1.setText("Vanilla Button Clicked");

     
// String filePath = "orderCusINFO.txt"; // Update with the actual file path
//     try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//         while (reader.readLine() == null) {
        
//             System.out.println("Hello");
        
//         }
//     }

// Add Buttons
        customerPanel.add(logoCustomerPanel);
    customerPanel.add(logo2CustomerPanel);
    customerPanel.add(textRow1);

   customerPanel.add(customerPanelAdminButton);
    customerPanel.add(vanilla);
    customerPanel.add(chocolate);
    customerPanel.add(strawberry);
    customerPanel.add(textRow2);

    customerPanel.add(mint);
    customerPanel.add(cookieDough);
    customerPanel.add(rockyRoad);
    customerPanel.add(textRow3);

    customerPanel.add(mocha);
    customerPanel.add(caramel);
    customerPanel.add(coffee);
    customerPanel.add(textRow4);

    customerPanel.add(banana);
    customerPanel.add(peach);
    customerPanel.add(finish);
    customerPanel.add(customerPanelBackButton);
    textRow1.setText("Welcome To Icy Delights ");
    
 
  

   // vanilla.addActionListener(event -> textfield.setText("Added Vanilla ice cream"));
   
    finish.addActionListener(event -> finishOnClick());
    customerPanelBackButton.addActionListener(event -> onCustomerClick());
    customerPanel.setLayout(new GridLayout(5, 5, 20, 30));

    // String firstString = "Hello";
    // String secondString = "World";
    // String combinedString = firstString.concat(secondString);
    // System.out.println(combinedString);




    // String combinedString = "";
    // String combinedStringPre = "";


    ActionListener vanillaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // //  String combinedString = combinedStringPre.concat(vanillaString);
            //  textRow1.setText(combinedString);
            textRow2.setText("Vanilla Added to Cart");
            
             TESTClick("($2.45 Vanilla) ");
             //  vanilla.setBackground(colors[4]);


        }
    };
   
    ActionListener chocolateClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow2.setText("Chocolate Added to Cart");
            // String tempCombinedString = ""; 
            // tempCombinedString = tempCombinedString.concat(chocolateString);
            // textRow1.setText(tempCombinedString);
           TESTClick("($2.30 Chocolate) ");
        }
    };

    ActionListener strawberryClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow2.setText("Strawberry Added to Cart");
             TESTClick("($3.00 Strawberry) ");
        }
    };
     ActionListener mintClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow3.setText("Mint Added to Cart");
            TESTClick("($2.45 Mint) ");
        }
    };
     ActionListener cookieDoughClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow3.setText("CookieDough Added to Cart");
             TESTClick("($3.00 CookieDough) ");
        }
    };
     ActionListener rockyRoadClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow3.setText("RockyRoad Added to Cart");
            TESTClick("($3.25 RockyRoad) ");
        }
    };
     ActionListener mochaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow4.setText("Mocha Added to Cart");
            TESTClick("($2.95 Mocha) ");
        }
    };
     ActionListener coffeeClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow4.setText("Coffee Added to Cart");
            TESTClick("($2.50 Coffee)");
        }
    };
     ActionListener bananaClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow4.setText("Banana Added to Cart");
            TESTClick("($2.50 Banana) ");
        }
    };
     ActionListener peachClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow4.setText("Peach Added to Cart");
            TESTClick("($3.00 Peach) ");
        }
    };
      ActionListener caramelClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textRow4.setText("Caramel Added to Cart");
            TESTClick("($2.45 Caramel) ");
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
    caramel.addActionListener(caramelClickListener);
   


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Finish Panel ////////////////////////////////////////////////////////////////////////////////////
    
//    finishPanel = new JPanel();
//     //JFrame finishframe = new JFrame("Finish Page");  

//     finishPanel = new JPanel();

//     JTextField totalFinishPanel;
//     JTextField  nameFinishPanel;
//     JTextField  phoneNumberFinishPanel;
//     JTextField  emailFinishPanel;
   


//         totalFinishPanel = new JTextField();
//         nameFinishPanel = new JTextField();
//         phoneNumberFinishPanel = new JTextField();
//         emailFinishPanel = new JTextField();
//         totalFinishPanel.setFont(myFont);

//     JButton logofinishPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 
//     JButton logo2finishPanel=new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\logoICY.png")); 

//     JButton finishPanelAdminButton= new JButton(new ImageIcon("Icy Delights\\src\\gui\\recources\\menu-bar-1-64.png"));
//    JButton nameLogo       = new JButton("Enter Your Name Here -->");
//    JButton phoneLogo       = new JButton("Enter Your Phone Number Here -->");
//    JButton emailLogo       = new JButton("Enter Your Email Here -->");
//    JButton totalLogo       = new JButton("Your Total -->");
      
//    JButton submitTotalLogo       = new JButton("Place Order");
//    JButton submitNameLogo       = new JButton("Submit");
//    JButton submitPhoneLogo       = new JButton("Submit");
//    JButton submitEmailLogo       = new JButton("Submit");



//     nameLogo.setFont(myFont);
//     phoneLogo.setFont(myFont);
//     emailLogo.setFont(myFont);
//     totalLogo.setFont(myFont);

//     submitTotalLogo.setFont(myFont);
//     submitNameLogo.setFont(myFont);
//     submitPhoneLogo.setFont(myFont);
//     submitEmailLogo.setFont(myFont);

//     // color 
//     finishPanelAdminButton.setBackground(colors[4]);
//     logofinishPanel.setBackground(colors[4]);
//     logo2finishPanel.setBackground(colors[4]);
//     nameLogo.setBackground(colors[4]);
//     phoneLogo.setBackground(colors[4]);
//     emailLogo.setBackground(colors[4]);
//     totalLogo.setBackground(colors[4]);

   

//     finishPanel.add(logofinishPanel);
//     finishPanel.add(logo2finishPanel);
//     finishPanel.add(finishPanelAdminButton);

//     finishPanel.add(nameLogo);
//     finishPanel.add(nameFinishPanel);
//     finishPanel.add(submitNameLogo);

//     finishPanel.add(phoneLogo);
//     finishPanel.add(phoneNumberFinishPanel);
//     finishPanel.add(submitPhoneLogo);

//     finishPanel.add(emailLogo); 
//     finishPanel.add(emailFinishPanel); 
//     finishPanel.add(submitEmailLogo);

//     finishPanel.add(totalLogo);
//     finishPanel.add(totalFinishPanel);
//     finishPanel.add(submitTotalLogo);

//     // // save  customer name / phone Number / Email in a text file.  write 
//     // try {
//     //     BufferedWriter writer = new BufferedWriter(new FileWriter("customerOutput.txt"));
//     //     writer.write("text write ");
//     //     writer.write("\n here is another line text write ");
//     //     writer.close();
//     // } catch (IOException e1) {
//     //     // TODO Auto-generated catch block
//     //     e1.printStackTrace();
//     // } 
// // reader form the file 
// // try {
// //     BufferedReader reader  = new BufferedReader(new FileReader ("customerOutput.txt"));
// //     String line; 
// //     while ((line = reader.readLine()) != null) {
// //         System.out.println(line);
// //     }
// //    // System.out.println(   reader.readLine());
// //     reader.close(); 
// // } catch (IOException e1) {
// //     // TODO Auto-generated catch block
// //     e1.printStackTrace();
// // }


//  //final String[] customerName = {""};

 

//     ActionListener submitNameLogoClickListener = new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
            
//            // customerName[0] = nameFinishPanel.getText();
//             System.out.println("Name: " + nameFinishPanel.getText());


// try {
//         BufferedWriter writer = new BufferedWriter(new FileWriter("customerNameOutput.txt"));
//         writer.write(nameFinishPanel.getText() );
//         writer.close();
//     } catch (IOException e1) {
//         e1.printStackTrace();
//     } 
//         }
//     };

    

//     ActionListener submitPhoneLogoClickListener = new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//         System.out.println("Phone #: " + phoneNumberFinishPanel.getText());


// try {
//         BufferedWriter writer2 = new BufferedWriter(new FileWriter("customerPhone#Output.txt"));
//        // writer2.write("\n");
//         writer2.write( phoneNumberFinishPanel.getText() );
//         writer2.close();
//     } catch (IOException e1) {
//         e1.printStackTrace();
//     } 
//         }
//     };
    
//     ActionListener submitEmailLogoClickListener = new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             System.out.println("Email: " + emailFinishPanel.getText());


// try {
//         BufferedWriter writer3 = new BufferedWriter(new FileWriter("customerEmailOutput.txt"));
//         //writer3.write("\n");
//         writer3.write(emailFinishPanel.getText());
//         writer3.close();
//     } catch (IOException e1) {
//         e1.printStackTrace();
//     } 
//         }
//     };




//     submitNameLogo.addActionListener(submitNameLogoClickListener);
//     submitPhoneLogo.addActionListener(submitPhoneLogoClickListener);
//     submitEmailLogo.addActionListener(submitEmailLogoClickListener);

//     finishPanelAdminButton.addActionListener(event -> onLogoutClick());

//     // finishframe.add(finishPanel);  
//     // finishframe.setSize(200, 300);  
//     // finishframe.setLocationRelativeTo(null);  
//     // finishframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//     // finishframe.setVisible(true);
 
 
    // finishPanel.setLayout(new GridLayout(5, 3, 20, 30)); 

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
        // addProductButton.addActionListener(event -> onNewProductClick());

        // Add Buttons
        menuPanel.add(addProductButton);
        menuPanel.add(returnButton,JPanel.BOTTOM_ALIGNMENT);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Set up JFrame /////////////////////////////////////////////////////////////////////////////////// 

        activePanel    = new JPanel();
        store = new Store(name);
        onLoadClick();
        setActivePanel(bootPanel);
        this.setName(name);
        this.setIconImage(logo);
        this.setSize(1500,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    // public TerminalWindow(Store store){
    //     this(store.name());
    // }

    protected void onSaveClick(){
        System.out.println("Save Button Clicked");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            store.save(bw);
            bw.close();
        }catch(Exception e){
            System.out.println(fileName.toPath());
            JOptionPane.showMessageDialog(this,"Im going to" + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }

    protected void onLoadClick(){
        System.out.println("Load Button Clicked");
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            store.load(br);
            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Unable to can PLEASE PLEASE PLEASE" + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
        }
        
    }


   int TESTClick(String IceName){
       // System.out.println("TEST Button Clicked");
       
        System.out.println(IceName);
        //setActivePanel(customerPanel);

        //String inputString =IceName;

  try{
	  FileWriter fstream = new FileWriter("order.txt",true);
	  BufferedWriter out = new BufferedWriter(fstream);
      //	  out.write("Line Added on: " + new java.util.Date()+"\n");

	  out.write(IceName);
	  out.close();
  }catch (Exception e){
	 System.err.println("Error while writing to file: " +
          e.getMessage());
  }






//finishPageINFO.txt
try {
    String inputString = new String(Files.readAllBytes(Paths.get("order.txt")));

     
            // Define a regular expression pattern to extract name and price
            Pattern pattern = Pattern.compile("\\(\\$(\\d+\\.\\d+)\\s(\\w+)\\)");
            
            // Create a HashMap to store the count of each name and its total price
            Map<String, Integer> nameCount = new HashMap<>();
            Map<String, Double> totalPrice = new HashMap<>();
            
            // Create a matcher for the input string
            Matcher matcher = pattern.matcher(inputString);
            
            // Find matches and process them
            while (matcher.find()) {
                // Extract price and name from the match
                double price = Double.parseDouble(matcher.group(1));
                String name = matcher.group(2);
                
                // Update count and total price for each name
                nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
                totalPrice.put(name, totalPrice.getOrDefault(name, 0.0) + price);
            }
            
            // Check if each name appears an odd or even number of times
            for (String name : nameCount.keySet()) {
                int count = nameCount.get(name);
                double price = totalPrice.get(name);
                
                System.out.println(name + ": " + (count % 2 == 0 ? "false" : "true"));
                
                if (count % 2 != 0) {
                    System.out.println("Total Price for " + name + ": $" + price);
                } else {
                    // If the count is even, remove the price from the total
                    totalPrice.put(name,0.0);
                }
            }
            
            // Add up all the true prices
            double totalTruePrices = totalPrice.values().stream()
                    .filter(price -> nameCount.getOrDefault(getNameByValue(totalPrice, price), 0) % 2 != 0)
                    .mapToDouble(Double::doubleValue)
                    .sum();
            
            System.out.println("Total True Prices: $" + totalTruePrices);










    String str = String.valueOf(totalTruePrices);


try{
	  FileWriter fstream = new FileWriter("finishPageINFO.txt",true);
	  BufferedWriter out = new BufferedWriter(fstream);

	  out.write("\n");
      out.write(str);
	  out.close();
  }catch (Exception e){
	 System.err.println("Error while writing to file: " +
          e.getMessage());
  }







            
        } catch (IOException e) {
            e.printStackTrace();
        }



  


    return 1;

//   try{
// 	  FileWriter fstream = new FileWriter("order.txt",true);
// 	  BufferedWriter out = new BufferedWriter(fstream);
//       //	  out.write("Line Added on: " + new java.util.Date()+"\n");

// 	  out.write(IceName);
// 	  out.close();
//   }catch (Exception e){
// 	 System.err.println("Error while writing to file: " +
//           e.getMessage());
//   }
  

// try {
//     BufferedReader reader  = new BufferedReader(new FileReader ("order.txt"));
//     String line; 
//     while ((line = reader.readLine()) != null) {
//         System.out.println(line);

//         String inputString = line; 

//         // Split the input string into an array of names
//         String[] names = inputString.split(" ");
        
//         // Create a HashMap to store the count of each name
//         Map<String, Integer> nameCount = new HashMap<>();
        
//         // Count the occurrences of each name
//         for (String name : names) {
//             nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
//         }
        
//         // Check if each name appears an odd or even number of times
//         for (String name : nameCount.keySet()) {
//             int count = nameCount.get(name);
            
//             System.out.println(name + ": " + (count % 2 == 0 ? "false" : "true"));




//   try{
// 	  FileWriter fstream = new FileWriter("total.txt",true);
// 	  BufferedWriter out = new BufferedWriter(fstream);
//       //	  out.write("Line Added on: " + new java.util.Date()+"\n");
    

//     out.write(name + ": " + (count % 2 == 0 ? "false" : "true"));
//     out.write("\n");

// 	out.close();
     
  

//   }catch (Exception e){
// 	 System.err.println("Error while writing to file: " +
//           e.getMessage());
//   }




//         }

       
        
//     }
//     //System.out.println( " sdsdsd" +  reader.readLine());
//     reader.close(); 
// } catch (IOException e1) {

//     e1.printStackTrace();
// }


//     return 1;
  
  }

    private static String getNameByValue(Map<String, Double> map, double value) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
 
//     int searchPhoneNumber(String tempSearchPhoneNumber){

//         System.out.println("Phone Number: " + tempSearchPhoneNumber);

          
       
//         String filePath = "rewardsHistory.txt";
        
//         String phoneNumberToSearch = tempSearchPhoneNumber;

//         try {

//             BufferedReader reader = new BufferedReader(new FileReader(filePath));
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] parts = line.split(" ");
//                 if (parts.length >= 3 && parts[1].equals(phoneNumberToSearch)) {
//                     String name = parts[0];
//                     String phoneNumber = parts[1];
//                     int rewardPoints = Integer.parseInt(parts[2]);

//                     System.out.println("Name: " + name);
//                     System.out.println("Phone Number: " + phoneNumber);
//                     System.out.println("Reward Points: " + rewardPoints);
//                     break;
//                 }
//             }

//             // Close the file
//             reader.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
           

// return 1; 
//     }




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
    protected void finishOnClick(){
        
        System.out.println("finish Button Clicked");
        //setActivePanel(finishPanel);


    Font myFont = new Font("Ink Free",Font.BOLD,30);
    Color colors[] = new Color[5];
	colors[4] = new Color(238,238,238);



// previousCustomerPanelcustomerPhoneOutput.txt

try {
    BufferedReader reader  = new BufferedReader(new FileReader ("finishPageINFO.txt"));
    String line;
//     if ((line = reader.readLine()) == null){
// System.out.println("1ame: " );
//     }
            while (((line = reader.readLine()) != null) ) {
                String[] parts = line.split(",");
                //if (okey == 0 ) {
                if (parts.length >= 3) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    int rewardPoints = Integer.parseInt(parts[2]);
                    System.out.println("Name: " + name);
                    System.out.println("Phone Number: " + phoneNumber);
                    System.out.println("Reward Points: " + rewardPoints);
                    
                    


                    String lastLine = null;

                    while ((line = reader.readLine()) != null) {
                        lastLine = line;
                    }
        
                    if (lastLine != null) {
                        System.out.println("Last line of the file: " + lastLine);
                    } else {
                        System.out.println("The file is empty.");
                    }

                        System.out.println("TOTAL: " + lastLine);









 JFrame finishframe = new JFrame("Finish Page");  

    finishPanel = new JPanel();

    JTextField totalFinishPanel;
    JTextField  nameFinishPanel;
    JTextField  phoneNumberFinishPanel;
    JTextField  emailFinishPanel;
    JTextField  rewardPointsFinishPanel;


    totalFinishPanel = new JTextField();
    nameFinishPanel = new JTextField();
    phoneNumberFinishPanel = new JTextField();
    emailFinishPanel = new JTextField();
    rewardPointsFinishPanel = new JTextField();
    rewardPointsFinishPanel.setFont(myFont);
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

   double exchangeRate = 0.001; // 1000 reward point is $1
   double cash = rewardPoints * exchangeRate;
   if (name != null){
   nameFinishPanel.setText(name);
  }
  if (phoneNumber != null){
   phoneNumberFinishPanel.setText(phoneNumber);
  }
   if (lastLine != null){
   totalFinishPanel.setText("$"+lastLine+" - ($"+cash+")");
  }
   if (rewardPoints != -1){
   rewardPointsFinishPanel.setText("Your Reward Points: "+rewardPoints);
  }
 

    nameLogo.setFont(myFont);
    phoneLogo.setFont(myFont);
    emailLogo.setFont(myFont);
    totalLogo.setFont(myFont);

    submitTotalLogo.setFont(myFont);
    submitNameLogo.setFont(myFont);
    submitPhoneLogo.setFont(myFont);
    submitEmailLogo.setFont(myFont);

   
    nameFinishPanel.setFont(myFont);
    phoneNumberFinishPanel.setFont(myFont);
    emailFinishPanel.setFont(myFont);

    // color 
    finishPanelAdminButton.setBackground(colors[4]);
    logofinishPanel.setBackground(colors[4]);
    logo2finishPanel.setBackground(colors[4]);
    nameLogo.setBackground(colors[4]);
    phoneLogo.setBackground(colors[4]);
    emailLogo.setBackground(colors[4]);
    totalLogo.setBackground(colors[4]);

   

    finishPanel.add(logofinishPanel);
    finishPanel.add(rewardPointsFinishPanel);
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

    // // save  customer name / phone Number / Email in a text file.  write 
    // try {
    //     BufferedWriter writer = new BufferedWriter(new FileWriter("customerOutput.txt"));
    //     writer.write("text write ");
    //     writer.write("\n here is another line text write ");
    //     writer.close();
    // } catch (IOException e1) {
    //     // TODO Auto-generated catch block
    //     e1.printStackTrace();
    // } 
// reader form the file 
// try {
//     BufferedReader reader  = new BufferedReader(new FileReader ("customerOutput.txt"));
//     String line; 
//     while ((line = reader.readLine()) != null) {
//         System.out.println(line);
//     }
//    // System.out.println(   reader.readLine());
//     reader.close(); 
// } catch (IOException e1) {
//     // TODO Auto-generated catch block
//     e1.printStackTrace();
// }


 //final String[] customerName = {""};

 

    ActionListener submitNameLogoClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
           // customerName[0] = nameFinishPanel.getText();
            System.out.println("Name: " + nameFinishPanel.getText());


try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("customerNameOutput.txt"));
        writer.write(nameFinishPanel.getText() );
        writer.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    } 
        }
    };

    

    ActionListener submitPhoneLogoClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        System.out.println("Phone #: " + phoneNumberFinishPanel.getText());


try {
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("customerPhone#Output.txt"));
       // writer2.write("\n");
        writer2.write( phoneNumberFinishPanel.getText() );
        writer2.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    } 
        }
    };
    
    ActionListener submitEmailLogoClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Email: " + emailFinishPanel.getText());


try {
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("customerEmailOutput.txt"));
        //writer3.write("\n");
        writer3.write(emailFinishPanel.getText());
        writer3.close();
    } catch (IOException e1) {
        e1.printStackTrace();
    } 
        }
    };
    submitNameLogo.addActionListener(submitNameLogoClickListener);
    submitPhoneLogo.addActionListener(submitPhoneLogoClickListener);
    submitEmailLogo.addActionListener(submitEmailLogoClickListener);

    finishPanelAdminButton.addActionListener(event -> onLogoutClick());

    finishframe.add(finishPanel);  
    finishframe.setSize(1500, 500);  
    finishframe.setLocationRelativeTo(null);  
    finishframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    finishframe.setVisible(true);




finishPanel.setLayout(new GridLayout(5, 3, 20, 30)); 

    }
     
}
   // System.out.println(   reader.readLine());
    reader.close(); 
} catch (IOException e1) {
    e1.printStackTrace();    
}

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
protected void newCustomerClick(){
        
        System.out.println("New Customer Clicked");

         setActivePanel(newCustomerPanel);


    }

    protected void onLogoutClick(){
        
        System.out.println("Logout Button Clicked");

        setActivePanel(bootPanel);

    }
    protected void onCustomerClick(){

        System.out.println("Customer Button Clicked");

        //setActivePanel(customerPanel);
        setActivePanel(previousOrNewCustomerPanel);
    }
    protected void orderonCustomerClick(){

        System.out.println(" Order Customer Button Clicked");

        setActivePanel(customerPanel);
        
    }
     protected void  previousCustomerPanelClick(){

        System.out.println("Previous Customer Panel Button Clicked");

         setActivePanel(previousCustomerPanel);

    }
    
    protected void onProductsClick(){

        System.out.println("Products Button Clicked");

        setActivePanel(menuPanel);
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
            store.add(new Customer(fullName[0],fullName[1],email.getText(),Long.parseLong(phoneNumber.getText())));;
            updateInventoryPanel();
            setActivePanel(inventoryPanel);
        }
        
        onSaveClick();
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

}
