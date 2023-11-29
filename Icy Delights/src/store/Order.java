package store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Order{
    private static long nextOrderNumber = 1;

    private long orderNumber;
    private String customerName;
    private ArrayList<String> items = new ArrayList<String>();

    public Order(String customerName){
        this.orderNumber = nextOrderNumber++;
        this.customerName = customerName;
    }

    public long orderNumber(){
        return orderNumber;
    }
    public int numberOfItems(){
        return items.size();
    }
    public void addItem(String item){
        this.items.add(item);
    }
    public void save() throws IOException {
        String pathname = "Icy Delights\\src\\gui\\recources\\previousOrders\\Order"+orderNumber;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathname)));
        bw.write("Order: " + orderNumber+'\n');
        bw.write("Customer: " + customerName+'\n');
        for(String item: items)
        bw.write(item+" $2.50"+'\n');
        bw.write("\nRewards Points Gained: "+items.size()*25);
        bw.close();
    }

    public void setCustomer(String customerName){
        this.customerName = customerName;
    }

    public String getCustomer(){
        return customerName;
    }
    public double orderTotal(){
        return items.size()*2.50;
    }
    @Override
    public String toString(){
        return String.format("%d", orderNumber);
    }
    
}
