
package model;
public class Customer{
    private int customerId;
    private String customerName;
    private String username;
    private String password;
    public Customer(int customerId,String customerName,String username,String password){
        this.customerId=customerId;
        this.customerName=customerName;
        this.username=username;
        this.password=password;
    }
    public int getCustomerId(){
        return customerId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}

