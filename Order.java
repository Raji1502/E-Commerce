package model;

import java.util.ArrayList;

public class Order{
    private int orderId;
    private int customerId;
    private ArrayList<CartItem> items;
    private double totalAmount;
    private String orderStatus;

    public Order(int orderId,int customerId,ArrayList<CartItem> items,double totalAmount,String orderStatus){
        this.orderId=orderId;
        this.customerId=customerId;
        this.items=items;
        this.totalAmount=totalAmount;
        this.orderStatus=orderStatus;
    }

    public int getOrderId(){
        return orderId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public ArrayList<CartItem> getItems(){
        return items;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public String getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }
}