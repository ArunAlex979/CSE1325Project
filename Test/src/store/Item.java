package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Item {

    private static int nextBinNumber = 1;

    private int binNumber;
    private long amountInStock;
    private int price;
    private String label;
    private ItemType itemType;

    public Item(String label,int price, ItemType itemType, long amountInStock){
        this.label = label;
        this.price = price;
        this.itemType = itemType;
        this.amountInStock = amountInStock;

        this.binNumber = nextBinNumber++;
    }

    // public Item(BufferedReader br) throws IOException {
    //     this.label = br.readLine();
    //     this.price = Integer.parseInt(br.readLine());
    //     // this.itemType = (ItemType) br.readLine();
    //     this.amountInStock = Long.parseLong(br.readLine());

    //     this.binNumber = Integer.parseInt(br.readLine());
    // }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(label + '\n');
        bw.write("" + Integer.toString(price) + '\n');
        // bw.write(itemType + '\n');
        bw.write("" + Long.toString(amountInStock) + '\n');

        bw.write("" + Integer.toString(binNumber) + '\n');
    }

    public long getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return String.format("#%04d    %-20s $%05.2f %-20s %s%n",binNumber,label,price/100.0, itemType, amountInStock);
    }
}
