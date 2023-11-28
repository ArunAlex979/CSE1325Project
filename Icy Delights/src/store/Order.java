package store;

import java.util.ArrayList;

public class Order{
    private static long nextOrderNumber = 1;

    private long orderNumber;
    private short customerNumber;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(){
        this.orderNumber = nextOrderNumber++;
    }

    public void addItem(Item item){
        this.items.add(item);
        
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
