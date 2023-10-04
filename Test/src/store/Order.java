package store;

import java.util.ArrayList;

public class Order{
    private static long nextOrderUmber = 1;

    private long orderNumber;
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Order(){

    }

    public void addProduct(Product product){
        this.products.add(product);
        
    }

    

    @Override
    public String toString(){
        return String.format("%d", orderNumber);
    }
    
}
