package store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
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
    public void save() throws IOException {
        String pathname = "Icy Delights\\src\\gui\\recources\\previousOrders\\Order"+orderNumber;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathname)));
        bw.write("Order #" + orderNumber+'\n');
        for(Item item: items)
        bw.write(item.toString()+'\n');
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
