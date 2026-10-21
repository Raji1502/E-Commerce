
package operations;
import java.util.ArrayList;
import model.Customer;

import service.FileHandling;

public class CustomerOperations{
    private ArrayList<Customer> customers=new ArrayList<>();
    public void addCustomer(Customer customer){
        customers.add(customer);
       FileHandling.saveCustomer(String.valueOf(customer.getCustomerId()), customer.getCustomerName(), customer.getPassword());
        System.out.println("Customer registered successfully.");
    }
    public void viewCustomers(){
        if(customers.isEmpty()){
            System.out.println("No customers available.");
            return;
        }
        System.out.println("===== CUSTOMER LIST =====");
        for(Customer customer:customers){
            System.out.println("ID : "+customer.getCustomerId());
            System.out.println("Name : "+customer.getCustomerName());
            System.out.println("Username : "+customer.getUsername());
            System.out.println("-------------------------");
        }
    }
    public Customer searchCustomer(String username){
        for(Customer customer:customers){
            if(customer.getUsername().equals(username)){
                return customer;
            }
        }
        return null;
    }
}

