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
    private ArrayList<Item>     menu                = new ArrayList<Item>();
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
        bw.write(""+customers.size() + '\n');
        for(Customer customer: customers)
            customer.save(bw);
        bw.close();
    }

    public void load(BufferedReader br) throws IOException{
        this.name = br.readLine();
        int inventorySize = Integer.parseInt(br.readLine());
        for(int x = 0;x<inventorySize;x++){
            inventory.add(new Item(br.readLine()));
        }
        int customerSize = Integer.parseInt(br.readLine());
        for(int x = 0;x<customerSize;x++){
            customers.add(new Customer(br.readLine()));
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


    public void add(Customer customer){
        customers.add(customer);
    }

    public void addCustomer(){
        
        customers.add(new Customer());
    }
    public Object customers(){
        return this.customers;
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
