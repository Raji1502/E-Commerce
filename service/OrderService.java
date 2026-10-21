
package service;

import model.Cart;
import operations.OrderOperations;

public class OrderService {
    private OrderOperations orderOperations;

    public OrderService(OrderOperations orderOperations) {
        this.orderOperations = orderOperations;
    }

    public void placeOrder(Cart cart) {
        System.out.println("OrderService connected successfully.");
        System.out.println("Cart received for order processing.");
    }
}
