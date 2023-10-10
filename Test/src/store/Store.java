package store;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private String name;

    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Item>     inventory = new ArrayList<Item>();
    private ArrayList<Product>  menu      = new ArrayList<Product>();
    private ArrayList<Order>   orders    = new ArrayList<Order>();

    private Scanner kb = new Scanner(System.in);

    public Store(String name){
        this.name = name;
        System.out.printf("Hello, welcome to %s\n",name);
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
        switch(kb.nextInt()){
            case 1 : addCustomer();break;
            case 2 : System.out.println(customers());break;
            case 3 : addCustomer();break;
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
