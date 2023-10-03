package store;

import java.util.ArrayList;

public class Store {

    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Option> options = new ArrayList<Option>();
    private ArrayList<Option> orders = new ArrayList<Option>();
    private ArrayList<Product> products = new ArrayList<Product>();

    public Store(String name){
        this.name = name;
    }

    public String name(){
        return name;
    }

    public void add(Customer customer){

    }

    public Object customers(){
        return this.customers;
    }

    public void add(Option option){

    }

    public Object options(){
        return this.options;
    }
    public void add(Product product){

    }

    public Object products(){
        return this.products;
    }

    public void add(Order order){

    }

    public Object orders(){
        return this.orders;
    }
}
