
package service;

import model.Customer;
import operations.CustomerOperations;

public class LoginService {
    private CustomerOperations customerOperations;

    public LoginService(CustomerOperations customerOperations) {
        this.customerOperations = customerOperations;
    }

    public Customer login(String username, String password) {
        Customer customer = customerOperations.searchCustomer(username);

        if (customer != null && customer.getPassword().equals(password)) {
            System.out.println("Customer login successful.");
            return customer;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }
}
