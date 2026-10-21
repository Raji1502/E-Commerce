
package service;

import java.io.*;
import java.util.ArrayList;
import model.Product;

public class FileHandling {

    private static final String FILE_NAME = "products.txt";

    // Save products into file
    public static void saveProducts(ArrayList<Product> products) {
        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Product p : products) {
                writer.write("Product ID: "+p.getProductId()+"\n");
                writer.write("Product Name: "+p.getProductName()+"\n");
                writer.write("Category: "+p.getCategory()+"\n");
		writer.write("Price: "+p.getPrice()+"\n");
		writer.write("Quantity: "+p.getQuantity()+"\n");
		writer.write("------------------------------------"+"\n");   
               
                
            }

            System.out.println("Products saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    // Load products from file
    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return products;
        }

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length == 5) {
                    Product product = new Product(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        Integer.parseInt(data[4])
                    );

                    products.add(product);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }

        return products;
    }

public static void saveCustomer(String customerId, String customerName,String password) {
    try (BufferedWriter writer =
             new BufferedWriter(new FileWriter("customers.txt", true))) {

        writer.write("Customer ID: " + customerId+"\n");
        
        writer.write("Customer Name: " + customerName+"\n");
        writer.write("Password: " + password+"\n");
   
        writer.write("-------------------------"+"\n");
        writer.newLine();

        System.out.println("Customer saved successfully.");

    } catch (IOException e) {
        System.out.println("Error saving customer: " + e.getMessage());
    }
}


public static void saveAdmin(String adminId,String adminName,String username,String password) {

    try (BufferedWriter writer =
             new BufferedWriter(
                 new FileWriter("admins.txt", true))) {

        writer.write("Admin ID: " + adminId+"\n");
        
        writer.write("Admin Name: " + adminName+"\n");
	writer.write("Admin Username: "+username+ "\n");
	writer.write("Password: "+password + "\n");
        
        writer.write("-------------------------"+"\n");
        writer.newLine();

        System.out.println("Admin saved successfully.");

    } catch (IOException e) {
        System.out.println("Error saving admin: " + e.getMessage());
    }
}


}
