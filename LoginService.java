package service;
import operations.CustomerOperations;
import model.Customer;
public class LoginService{
    private CustomerOperations customerOperations;
    public LoginService(CustomerOperations customerOperations){
        this.customerOperations=customerOperations;
    }
    public Customer login(String username,String password){
        Customer customer=customerOperations.searchCustomer(username);
        if(customer!=null){
            if(customer.getPassword().equals(password)){
                System.out.println("Login successful.");
                return customer;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }
}