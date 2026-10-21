package service;

import java.util.ArrayList;
import model.Cart;
import model.CartItem;
import model.Order;
import operations.OrderOperations;

public class OrderService{

    private OrderOperations orderOperations;
    private int nextOrderId=1001;

    public OrderService(OrderOperations orderOperations){
        this.orderOperations=orderOperations;
    }

    public void placeOrder(Cart cart){

        if(cart.getItems().isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }

        double totalAmount=0;

        for(CartItem item:cart.getItems()){
            totalAmount=totalAmount+item.getTotal();
        }

        ArrayList<CartItem> orderItems=new ArrayList<>(cart.getItems());

        Order order=new Order(
            nextOrderId,
            cart.getCustomerId(),
            orderItems,
            totalAmount,
            "ORDER PLACED"
        );

        orderOperations.placeOrder(order);

        nextOrderId++;

        cart.getItems().clear();

        System.out.println("Total Amount : Rs."+totalAmount);
        System.out.println("Thank you for shopping!");
    }
}