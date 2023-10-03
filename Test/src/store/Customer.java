package store;

public class Customer {
    
    private String firstName;
    private String lastName;
    private String email;
    private short phoneNumber;

    public long rewardPonts;

    public Customer(){
        this.firstName = "Guest";
    }

    public Customer(String firstName, String lastName, String email, Short phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        if(firstName.equals("Guest"))
            return String.format("%s",firstName);
        else
            return String.format("%-5s, %-5 %-10s %d",lastName, firstName, email, phoneNumber);
    }
}
