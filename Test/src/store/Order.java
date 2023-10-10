package store;

import java.util.ArrayList;

public class Order{
    private static long nextOrderNumber = 1;

    private long orderNumber;
    private short customerNumber;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Order(){
        this.orderNumber = nextOrderNumber++;
    }

    public void addProduct(Product product){
        this.products.add(product);
        
    }

    public void setCustomer(short customerNumber){
        this.customerNumber = customerNumber;
    }

    public short getCustomer(){
        return customerNumber;
    }
    @Override
    public String toString(){
        return String.format("%d", orderNumber);
    }
    
}
