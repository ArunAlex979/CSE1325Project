package store;

public class Option{
    private String name;
    private long basePrice;

    public Option(String name, long basePrice){
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
