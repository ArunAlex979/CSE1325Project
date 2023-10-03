package store;

import java.util.ArrayList;

public class Product {
    
    private String name;
    private long basePrice;
    private ArrayList<Option> modifications = new ArrayList<Option>();

    public Product(String name, long basePrice){
        this.name = name;
        this.basePrice = basePrice;
    }


    public long price(){
        return 0;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
