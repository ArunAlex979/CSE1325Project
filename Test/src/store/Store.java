package store;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Store {

    private String name;

    private ArrayList<Customer> customers           = new ArrayList<Customer>();
    private ArrayList<Item>     inventory           = new ArrayList<Item>();
    // private ArrayList<Item>     consumableInventory = new ArrayList<Item>();
    private ArrayList<Product>  menu                = new ArrayList<Product>();
    private ArrayList<Order>    orders              = new ArrayList<Order>();

    private Scanner kb = new Scanner(System.in);

    public Store(String name){
        this.name = name;
        System.out.printf("Hello, welcome to %s\n",name);
    }

    public Store(File fileName){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            load(br);
            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(),"Unable to can " + fileName + 'n' + e,"Failed",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        System.out.println("Checkpoint 1 " + name);
        bw.write("" + inventory.size()+'\n');
        for(Item item: inventory)
            item.save(bw);
        System.out.println("Checkpoint 2");
    }

    public void load(BufferedReader br) throws IOException{
        this.name = br.readLine();
        int inventorySize = Integer.parseInt(br.readLine());
        for(int x = 0;x<inventorySize;x++){
            inventory.add(new Item(br.readLine(),Integer.parseInt(br.readLine()),ItemType.CONSUMABLE,Long.parseLong(br.readLine())));
        }
    }

    public void close(){
        this.name = null;
        customers.clear();
        inventory.clear();
        menu.clear();
        orders.clear();
    }
    public String name(){
        return name;
    }

    public void showOptions(){
        System.out.println("What would you like to do:");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");
        System.out.println("3. Add Item");
        System.out.println("4. View Items");
        System.out.println("5. Exit");
        System.out.print("Enter Option (1-5) ->");
        switch(kb.nextInt()){
            case 1 : addCustomer();break;
            case 2 : System.out.println(customers());break;
            // case 3 : addItem();break;
            case 4 : System.out.println(customers());break;
            case 5 : System.exit(0);
        }
    }

    public void add(Customer customer){
        customers.add(customer);
    }

    public void addCustomer(){
        
        customers.add(new Customer());
    }
    public Object customers(){
        return this.customers;
    }

    public void add(Product product){

    }

    public Object menu(){
        return this.menu;
    }

    public void add(Order order){

    }

    public Object orders(){
        return this.orders;
    }

    public void add(Item item){
        inventory.add(item);
    }

    public Object [] inventory(){
        return this.inventory.toArray();
    }

}
