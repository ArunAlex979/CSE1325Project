package store;

public class Item {

    private static long nextBinNumber = 1;

    private long binNumber;
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
        return String.format("%s %-5s %s %s %s",binNumber,label,price, itemType, amountInStock);
    }
}
