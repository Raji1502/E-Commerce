package model;

public class CartItem{
    private Product product;
    private String color;
    private String size;
    private int quantity;

    public CartItem(Product product,String color,String size,int quantity){
        this.product=product;
        this.color=color;
        this.size=size;
        this.quantity=quantity;
    }

    public Product getProduct(){
        return product;
    }

    public String getColor(){
        return color;
    }

    public String getSize(){
        return size;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getTotal(){
        return product.getPrice()*quantity;
    }
}