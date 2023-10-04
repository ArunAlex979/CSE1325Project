package store;

import java.util.ArrayList;

public class Product {
    
    private String name;
    private long price;
    private ItemType itemType;
    private ArrayList<Item> ingredients = new ArrayList<Item>();

    public Product(String name, ArrayList<Item> ingredients, ItemType itemType){
        this.name = name;
        this.price = 0;
        for(int x =0;x<ingredients.size();x++){
            this.ingredients.add(ingredients.get(x));
            price += ingredients.get(x).getPrice();
        }
        this.itemType = itemType;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Variable Retrival Methods ///////////////////////////////////////////////////

    public Object getIngrediets(){
        return this.ingredients.toArray();
    }
    public long getPrice(){
        return price;
    }
    public ItemType getItemType(){
        return itemType;
    }


    @Override
    public String toString(){
        return String.format("%s $%.2f",this.name, this.price/100.0);
    }
}
