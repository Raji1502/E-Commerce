
package service;

import java.io.*;
import java.util.ArrayList;
import model.Product;

public class FileHandling {
    private static final String DATA_FOLDER = "data";

    private static void createFolder() {
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void saveAdmin(String id, String name, String username, String password) {
        createFolder();
        try (FileWriter writer = new FileWriter(DATA_FOLDER + "/admins.txt", true)) {
            writer.write(id + "," + name + "," + username + "," + password + "\n");
        } catch (IOException e) {
            System.out.println("Error saving admin: " + e.getMessage());
        }
    }

    public static void saveCustomer(String id, String name, String password) {
        createFolder();
        try (FileWriter writer = new FileWriter(DATA_FOLDER + "/customers.txt", true)) {
            writer.write(id + "," + name + "," + password + "\n");
        } catch (IOException e) {
            System.out.println("Error saving customer: " + e.getMessage());
        }
    }

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();
        createFolder();
        File file = new File(DATA_FOLDER + "/products.txt");

        if (!file.exists()) {
            return products;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);
                if (data.length == 5) {
                    products.add(new Product(
                        data[0], data[1], data[2],
                        Double.parseDouble(data[3]),
                        Integer.parseInt(data[4])
                    ));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
        return products;
    }

    public static void saveProducts(ArrayList<Product> products) {
        createFolder();
        try (FileWriter writer = new FileWriter(DATA_FOLDER + "/products.txt")) {
            for (Product product : products) {
                writer.write(
                    product.getProductId() + "," +
                    product.getProductName() + "," +
                    product.getCategory() + "," +
                    product.getPrice() + "," +
                    product.getQuantity() + "\n"
                );
            }
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }
}
