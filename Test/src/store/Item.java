package store;

public class Item {

    private static int nextBinNumber = 1;

    private int binNumber;
    private long amountInStock;
    private long price;
    private String label;
    private ItemType itemType;

    public Item(String label,long price, ItemType itemType, long amountInStock){
        this.label = label;
        this.price = price;
        this.itemType = itemType;
        this.amountInStock = amountInStock;

        this.binNumber = nextBinNumber++;
    }

    public long getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return String.format("%04d %-15s %-4s %-15s %s",binNumber,label,price, itemType, amountInStock);
    }
}
