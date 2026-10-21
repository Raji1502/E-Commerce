
package model;
public class Product{
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
   
    public Product(String productId,String productName,String category,double price,int quantity){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.price=price;
        this.quantity=quantity;
	
    }
    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
}