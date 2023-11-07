//  import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// class BackgroundImageJFrame extends JFrame
// {
// JButton shopButtom;
// JButton menuButtom;
// JLabel l1;

// 	public BackgroundImageJFrame()
// 	{
// 	setTitle(" ICY Delights");
// 	setSize(1000,1000);
// 	setLocationRelativeTo(null);
// 	setDefaultCloseOperation(EXIT_ON_CLOSE);
// 	setVisible(true);

// 	setLayout(new BorderLayout());
// 	JLabel background=new JLabel(new ImageIcon("gui\\recources\\logo.png"));
// 	add(background);
// 	background.setLayout(new FlowLayout());

// 	l1=new JLabel("Welcome to ICY Delights");
// 	shopButtom=new JButton("Shop Now");
// 	menuButtom=new JButton("Menu");
	
// 	background.add(l1);
// 	background.add(shopButtom);	
// 	background.add(menuButtom);


	

// // Another way
// 	// setLayout(new BorderLayout());
// 	// setContentPane(new JLabel(new ImageIcon("gui\\recources\\logo.png")));
// 	// setLayout(new FlowLayout());
// 	// l1=new JLabel("Here is a button");
// 	// shopButtom=new JButton("I am a button");
// 	// add(l1);
// 	// add(shopButtom);

// 	// Just for refresh :) Not optional!
// 	setSize(399,399);
// 	setSize(500,400);
// 	}
  
	
// }






// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// class BackgroundImageJFrame extends JFrame {
//     JButton shopButton;
//     JButton menuButton;
//     JLabel l1;

//     public BackgroundImageJFrame() {
//         setTitle("ICY Delights");
//         setSize(1000, 1000);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setVisible(true);

//         setLayout(new BorderLayout());
//         JLabel background = new JLabel(new ImageIcon("gui\\resources\\logo.png"));
//         add(background);
//         background.setLayout(new FlowLayout());

//         l1 = new JLabel("Welcome to ICY Delights");
//         shopButton = new JButton("Shop Now");
//         menuButton = new JButton("Menu");

//         background.add(l1);
//         background.add(shopButton);
//         background.add(menuButton);

//         // Add an ActionListener to the "Shop Now" button
//         shopButton.addActionListener(new ShopButtonActionListener());

//         // Just for refresh :) Not optional!
//         setSize(399, 399);
//         setSize(500, 400);
//     }

//     // ActionListener class for the "Shop Now" button
//     class ShopButtonActionListener implements ActionListener {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             // Add your action logic here when the "Shop Now" button is clicked
//             // For example, you can open a new window or perform some other action.
// 			System.out.println(1);
//         }
//     }

   
// }





import java.awt.Color;

import javax.swing.*;    
import java.awt.event.*; 
 class BackgroundImageJFrame {  
public BackgroundImageJFrame()  {  
	/* 
	This is the background color for the frame that is used
	in the main window.
	Found the RGB numbers using "Windows Paint" color picker tool to color match
	Changed the background of the buttom to match the background of the frame. 
	*/
	Color colors[] = new Color[5];
	colors[4] = new Color(238,238,238);


    JFrame mainWindow=new JFrame("ICY DELIGHTS");  
    
	JButton shopNow=new JButton("SHOP NOW!");  
	shopNow.setBackground(colors[4]);
    shopNow.setBounds(650,225,150,30); 
	

	JButton logo=new JButton(new ImageIcon("ICY\\gui\\recources\\logo.png")); 
	logo.setBackground(colors[4]);
	logo.setBounds(225,0,930, 220); // 225,225,1000, 400 was in the middle of teh frame

	// JButton logoICY=new JButton(new ImageIcon("gui\\recources\\logoICY.png")); 
	// logoICY.setBackground(colors[4]);
	// logoICY.setBounds(0,0,245, 140); 
	
	/*
	https://www.veryicon.com/icons/miscellaneous/general-icon-library/menu-bar-1.html
	https://www.veryicon.com/icons/miscellaneous/rongyiguang/menu-bar-shopping-cart.html

	Got the icons( menuBar & menuShoppingcart ) form those wesite 
	 */
	JButton menuBar=new JButton(new ImageIcon("ICY\\gui\\recources\\menu-bar-1-64.png")); 
	menuBar.setBackground(colors[4]);
	menuBar.setBounds(1400,10,50,40); 
	
	JButton menuShoppingcart=new JButton(new ImageIcon("ICY\\gui\\recources\\menu-bar-shopping-cart-64.png")); 
	menuShoppingcart.setBackground(colors[4]);
	menuShoppingcart.setBounds(0,10,60,55); 


	mainWindow.add(logo);
	//mainWindow.add(logoICY);
    mainWindow.add(shopNow);  
	mainWindow.add(menuBar);
	mainWindow.add(menuShoppingcart);

    mainWindow.setSize(1500,800);  
    mainWindow.setLayout(null);  
    mainWindow.setVisible(true);   
}  
}  