package store;

public enum ItemType {
    FLAVOR("FLAVOR"), TOPPING("TOPPING");

    private String str;

    ItemType(String str){
        this.str = str;
    }

    public String toString(){
        return str;
    }
};
