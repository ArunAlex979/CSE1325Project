package store;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Customer implements Comparable{
    
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    public long rewardPoints;
    private ArrayList<Long> previousOrders = new ArrayList<Long>();

    public Customer(){
        this.firstName = "Guest";
    }

    public Customer(String firstName, String lastName, String email, long phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String br){
        String [] infoNeeded = br.split(" ");
        this.phoneNumber = Long.parseLong(infoNeeded[0]);
        this.lastName = infoNeeded[1];
        this.firstName = infoNeeded[2];
        this.email = infoNeeded[3];
        this.rewardPoints = Long.parseLong(infoNeeded[4]);
    }

    public long phoneNumber(){
        return phoneNumber;
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
    public String firstName(){
        return String.format("%s %s",firstName,lastName);
    }
    public String lastName(){
        return String.format("%s %s",firstName,lastName);
    }
    public String fullName(){
        return String.format("%s %s",firstName,lastName);
    }

    @Override
    public String toString(){
        if(firstName.equals("Guest"))
            return String.format("%s test",firstName);
        else
            return String.format("%-5s, %-5 %-10s %d",lastName, firstName, email, phoneNumber);
    }
    @Override
    public int compareTo(Object o){
        return (int) ( (int) o - phoneNumber);
    }
}
