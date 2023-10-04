package store;

import java.util.ArrayList;

public class Store {

    private String name;

    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Item>     inventory = new ArrayList<Item>();
    private ArrayList<Product>  menu      = new ArrayList<Product>();
    private ArrayList<Order>   orders    = new ArrayList<Order>();

    public Store(String name){
        this.name = name;
    }

    public String name(){
        return name;
    }

    public void add(Customer customer){
        customers.add(customer);
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
}
