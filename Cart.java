package model;

import java.util.ArrayList;

public class Cart{
    private int customerId;
    private ArrayList<CartItem> items;

    public Cart(int customerId){
        this.customerId=customerId;
        this.items=new ArrayList<>();
    }

    public int getCustomerId(){
        return customerId;
    }

    public ArrayList<CartItem> getItems(){
        return items;
    }
}
