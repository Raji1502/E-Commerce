package operations;

import java.util.ArrayList;
import model.CartItem;
import model.Order;

public class OrderOperations{

    private ArrayList<Order> orders=new ArrayList<>();

    public void placeOrder(Order order){

        orders.add(order);

        System.out.println("Order placed successfully.");
        System.out.println("Order ID : "+order.getOrderId());
    }

    public void viewOrders(){

        if(orders.isEmpty()){
            System.out.println("No orders available.");
            return;
        }

        System.out.println("===== ORDER LIST =====");

        for(Order order:orders){

            System.out.println("Order ID : "+order.getOrderId());
            System.out.println("Customer ID : "+order.getCustomerId());

            for(CartItem item:order.getItems()){

                System.out.println("Product : "+item.getProduct().getProductName());

                if(!item.getColor().isEmpty()){
                    System.out.println("Color : "+item.getColor());
                }

                if(!item.getSize().isEmpty()){
                    System.out.println("Size : "+item.getSize());
                }

                System.out.println("Quantity : "+item.getQuantity());
            }

            System.out.println("Total Amount : Rs."+order.getTotalAmount());
            System.out.println("Status : "+order.getOrderStatus());
            System.out.println("---------------------");
        }
    }

    public Order searchOrder(int orderId){

        for(Order order:orders){

            if(order.getOrderId()==orderId){
                return order;
            }
        }

        return null;
    }

    public void cancelOrder(int orderId){

        Order order=searchOrder(orderId);

        if(order!=null){

            order.setOrderStatus("CANCELLED");

            System.out.println("Order cancelled successfully.");

        }else{

            System.out.println("Order not found.");
        }
    }
}