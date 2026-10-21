package operations;
import java.util.ArrayList;
import model.Product;

import service.FileHandling;

public class ProductOperations{
    private ArrayList<Product> products;

    public ProductOperations(){
	products=FileHandling.loadProducts();
}


    public void addProduct(Product product){
        products.add(product);
	FileHandling.saveProducts(products);
        System.out.println("Product added successfully.");
    }

    public void viewProducts(){
        if(products.isEmpty()){
            System.out.println("No products available.");
            return;
        }

        System.out.println("===== PRODUCT LIST =====");

        for(Product product:products){
            System.out.println("ID : "+product.getProductId());
            System.out.println("Name : "+product.getProductName());
            System.out.println("Category : "+product.getCategory());
            System.out.println("Price : "+product.getPrice());
            System.out.println("Quantity : "+product.getQuantity());
            System.out.println("-----------------------");
        }
    }

    public Product searchProduct(String productName){
        for(Product product:products){
            if(product.getProductName().equalsIgnoreCase(productName)){
                return product;
            }
        }
        return null;
    }


    public void updateProduct(String productName,int quantity){
        Product product=searchProduct(productName);

        if(product!=null){
            product.setQuantity(quantity);
	    FileHandling.saveProducts(products);
            System.out.println("Product updated successfully.");
        }else{
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productName){
        Product product=searchProduct(productName);

        if(product!=null){
            products.remove(product);
	    FileHandling.saveProducts(products);
            System.out.println("Product deleted successfully.");
        }else{
            System.out.println("Product not found.");
        }
    }
}