package operations;

import model.Cart;
import model.CartItem;
import model.Product;

public class CartOperations{

    public void addToCart(Cart cart,Product product,String color,String size,int quantity){

        if(product==null){
            System.out.println("Product not found.");
            return;
        }

        if(quantity<=0){
            System.out.println("Invalid quantity.");
            return;
        }

        if(quantity>product.getQuantity()){
            System.out.println("Not enough stock.");
            return;
        }

        CartItem item=new CartItem(product,color,size,quantity);

        cart.getItems().add(item);

        product.setQuantity(product.getQuantity()-quantity);

        System.out.println("Product added to cart.");
    }

    public void viewCart(Cart cart){

        if(cart.getItems().isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("===== YOUR CART =====");

        double total=0;

        for(CartItem item:cart.getItems()){

            System.out.println("Product : "+item.getProduct().getProductName());

            if(!item.getColor().isEmpty()){
                System.out.println("Color : "+item.getColor());
            }

            if(!item.getSize().isEmpty()){
                System.out.println("Size : "+item.getSize());
            }

            System.out.println("Quantity : "+item.getQuantity());
            System.out.println("Price : Rs."+item.getProduct().getPrice());
            System.out.println("Total : Rs."+item.getTotal());
            System.out.println("--------------------");

            total=total+item.getTotal();
        }

        System.out.println("Cart Total : Rs."+total);
    }

    public void removeFromCart(Cart cart,String productName){

        for(int i=0;i<cart.getItems().size();i++){

            CartItem item=cart.getItems().get(i);

            if(item.getProduct().getProductName().equalsIgnoreCase(productName)){

                item.getProduct().setQuantity(
                    item.getProduct().getQuantity()+item.getQuantity()
                );

                cart.getItems().remove(i);

                System.out.println("Product removed from cart.");
                return;
            }
        }

        System.out.println("Product not found in cart.");
    }

    public double calculateTotal(Cart cart){

        double total=0;

        for(CartItem item:cart.getItems()){
            total=total+item.getTotal();
        }

        return total;
    }
}