package store;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Customer {
    
    private String firstName;
    private String lastName;
    private String email;
    private short phoneNumber;
    public long rewardPoints;
    private ArrayList<Long> previousOrders = new ArrayList<Long>();

    public Customer(){
        this.firstName = "Guest";
    }

    public Customer(String firstName, String lastName, String email, Short phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

     public void save(BufferedWriter bw) throws IOException {
        bw.write(""+ phoneNumber + ' ');
        bw.write(lastName + ' ');
        bw.write(firstName + ' ');
        bw.write(email + ' ');
        bw.write(""+ rewardPoints + '\n');
    }

    public void addOrder(long orderNumber, long rewardPoints){
        this.previousOrders.add(orderNumber);
        this.rewardPoints += rewardPoints;
    }

    public void useReward(long rewardPoints){
        this.rewardPoints -= rewardPoints;
    }

    @Override
    public String toString(){
        if(firstName.equals("Guest"))
            return String.format("%s test",firstName);
        else
            return String.format("%-5s, %-5 %-10s %d",lastName, firstName, email, phoneNumber);
    }
}
