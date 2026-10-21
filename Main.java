import java.util.Scanner;

import model.Product;
import model.Customer;
import model.Cart;

import operations.ProductOperations;
import operations.CustomerOperations;
import operations.CartOperations;
import operations.OrderOperations;
import operations.AdminOperations;

import service.LoginService;
import service.OrderService;

public class Main{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        ProductOperations productOperations=new ProductOperations();
        CustomerOperations customerOperations=new CustomerOperations();
        CartOperations cartOperations=new CartOperations();
        OrderOperations orderOperations=new OrderOperations();
        AdminOperations adminOperations=new AdminOperations();

        LoginService loginService=new LoginService(customerOperations);
        OrderService orderService=new OrderService(orderOperations);

        System.out.println("================================");
        System.out.println("     E-COMMERCE APPLICATION");
        System.out.println("================================");

        int mainChoice=0;

        do{

            System.out.println();
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. Create Admin");
            System.out.println("2. Admin Login");
            System.out.println("3. Customer Registration");
            System.out.println("4. Customer Login");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input=sc.nextLine();

            if(input.isEmpty()){
                System.out.println("Choice cannot be empty.");
                continue;
            }

            try{
                mainChoice=Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Please enter numbers only.");
                continue;
            }

            switch(mainChoice){

                case 1:

                    adminOperations.createAdmin(sc);

                    break;

                case 2:

                    if(adminOperations.login(sc)!=null){

                        int adminChoice=0;

                        do{

                            System.out.println();
                            System.out.println("===== ADMIN MENU =====");
                            System.out.println("1. Add Product");
                            System.out.println("2. View Products");
                            System.out.println("3. Search Product");
                            System.out.println("4. Update Product");
                            System.out.println("5. Delete Product");
                            System.out.println("6. View Customers");
                            System.out.println("7. View Orders");
                            System.out.println("8. Logout");
                            System.out.print("Enter your choice: ");

                            String adminInput=sc.nextLine();

                            if(adminInput.isEmpty()){
                                System.out.println("Choice cannot be empty.");
                                continue;
                            }

                            try{
                                adminChoice=Integer.parseInt(adminInput);
                            }catch(NumberFormatException e){
                                System.out.println("Please enter numbers only.");
                                continue;
                            }

                            switch(adminChoice){

                                case 1:

                                    String productId;
                                    String productName;
                                    String category;
                                    double price;
                                    int quantity;

                                    while(true){

                                        System.out.print("Enter Product ID: ");
                                        productId=sc.nextLine();

                                        if(!productId.isEmpty()){
                                            break;
                                        }

                                        System.out.println("Product ID cannot be empty.");
                                    }

                                    while(true){

                                        System.out.print("Enter Product Name: ");
                                        productName=sc.nextLine();

                                        if(productName.isEmpty()){
                                            System.out.println("Product Name cannot be empty.");
                                            continue;
                                        }

                                        if(!productName.matches("[a-zA-Z ]+")){
                                            System.out.println("Invalid Product Name. Enter letters only.");
                                            continue;
                                        }

                                        break;
                                    }

                                    while(true){

                                        System.out.print("Enter Category: ");
                                        category=sc.nextLine();

                                        if(category.isEmpty()){
                                            System.out.println("Category cannot be empty.");
                                            continue;
                                        }

                                        if(!category.matches("[a-zA-Z ]+")){
                                            System.out.println("Invalid Category. Enter letters only.");
                                            continue;
                                        }

                                        break;
                                    }

                                    while(true){

                                        System.out.print("Enter Price: ");
                                        String priceInput=sc.nextLine();

                                        if(!priceInput.matches("[0-9]+(\\.[0-9]+)?")){
                                            System.out.println("Please enter correct Price.");
                                            continue;
                                        }

                                        price=Double.parseDouble(priceInput);
                                        break;
                                    }

                                    while(true){

                                        System.out.print("Enter Quantity: ");
                                        String quantityInput=sc.nextLine();

                                        if(!quantityInput.matches("[0-9]+")){
                                            System.out.println("Please enter correct Quantity.");
                                            continue;
                                        }

                                        quantity=Integer.parseInt(quantityInput);
                                        break;
                                    }

                                    Product product=new Product(
                                        productId,
                                        productName,
                                        category,
                                        price,
                                        quantity
                                    );

                                    productOperations.addProduct(product);

                                    break;

                                case 2:

                                    productOperations.viewProducts();

                                    break;

                                case 3:

                                    System.out.print("Enter Product Name: ");

                                    String searchName=sc.nextLine();

                                    Product searchedProduct=
                                        productOperations.searchProduct(searchName);

                                    if(searchedProduct!=null){

                                        System.out.println("Product Found");
                                        System.out.println("ID : "+searchedProduct.getProductId());
                                        System.out.println("Name : "+searchedProduct.getProductName());
                                        System.out.println("Category : "+searchedProduct.getCategory());
                                        System.out.println("Price : "+searchedProduct.getPrice());
                                        System.out.println("Quantity : "+searchedProduct.getQuantity());

                                    }else{

                                        System.out.println("Product not found.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("Enter Product Name: ");

                                    String updateName=sc.nextLine();

                                    int newQuantity;

                                    while(true){

                                        System.out.print("Enter New Quantity: ");

                                        String newQuantityInput=sc.nextLine();

                                        if(!newQuantityInput.matches("[0-9]+")){
                                            System.out.println("Please enter correct Quantity.");
                                            continue;
                                        }

                                        newQuantity=Integer.parseInt(newQuantityInput);
                                        break;
                                    }

                                    productOperations.updateProduct(
                                        updateName,
                                        newQuantity
                                    );

                                    break;

                                case 5:

                                    System.out.print("Enter Product Name: ");

                                    String deleteName=sc.nextLine();

                                    productOperations.deleteProduct(deleteName);

                                    break;

                                case 6:

                                    customerOperations.viewCustomers();

                                    break;

                                case 7:

                                    orderOperations.viewOrders();

                                    break;

                                case 8:

                                    System.out.println("Admin logged out.");

                                    break;

                                default:

                                    System.out.println("Invalid choice. Enter 1 to 8.");
                            }

                        }while(adminChoice!=8);
                    }

                    break;

                case 3:

                    System.out.print("Enter Customer ID: ");

                    String customerIdInput=sc.nextLine();

                    if(!customerIdInput.matches("[0-9]+")){
                        System.out.println("Invalid Customer ID.");
                        break;
                    }

                    int customerId=Integer.parseInt(customerIdInput);

                    String customerName;

                    while(true){

                        System.out.print("Enter Customer Name: ");

                        customerName=sc.nextLine();

                        if(customerName.isEmpty()){
                            System.out.println("Customer Name cannot be empty.");
                            continue;
                        }

                        if(!customerName.matches("[a-zA-Z ]+")){
                            System.out.println("Invalid name. Enter letters only!");
                            continue;
                        }

                        break;
                    }

                    String customerUsername;

                    while(true){

                        System.out.print("Enter Username: ");

                        customerUsername=sc.nextLine();

                        if(!customerUsername.isEmpty()){
                            break;
                        }

                        System.out.println("Username cannot be empty.");
                    }

                    String customerPassword;

                    while(true){

                        System.out.print("Enter Password: ");

                        customerPassword=sc.nextLine();

                        if(customerPassword.isEmpty()){
                            System.out.println("Password cannot be empty.");
                            continue;
                        }

                        if(customerPassword.length()<6){
                            System.out.println("Password must be at least 6 characters.");
                            continue;
                        }

                        if(customerPassword.length()>15){
                            System.out.println("Password must not exceed 15 characters.");
                            continue;
                        }

                        if(!customerPassword.matches(".*[A-Z].*")){
                            System.out.println("Password must contain at least one uppercase letter.");
                            continue;
                        }

                        if(!customerPassword.matches(".*[a-z].*")){
                            System.out.println("Password must contain at least one lowercase letter.");
                            continue;
                        }

                        if(!customerPassword.matches(".*[0-9].*")){
                            System.out.println("Password must contain at least one number.");
                            continue;
                        }

                        if(!customerPassword.matches(".*[^a-zA-Z0-9].*")){
                            System.out.println("Password must contain at least one special character.");
                            continue;
                        }

                        break;
                    }

                    Customer newCustomer=new Customer(
                        customerId,
                        customerName,
                        customerUsername,
                        customerPassword
                    );

                    customerOperations.addCustomer(newCustomer);

                    break;

                case 4:

                    System.out.print("Enter Username: ");

                    String username=sc.nextLine();

                    System.out.print("Enter Password: ");

                    String password=sc.nextLine();

                    Customer customer=
                        loginService.login(username,password);

                    if(customer==null){
                        System.out.println("Login failed.");
                        break;
                    }

                    Cart cart=new Cart(customer.getCustomerId());

                    int customerChoice=0;

                    do{

                        System.out.println();
                        System.out.println("===== CUSTOMER MENU =====");
                        System.out.println("1. View Products");
                        System.out.println("2. Search Product");
                        System.out.println("3. Add to Cart");
                        System.out.println("4. View Cart");
                        System.out.println("5. Remove from Cart");
                        System.out.println("6. Place Order");
                        System.out.println("7. View Orders");
                        System.out.println("8. Logout");
                        System.out.print("Enter your choice: ");

                        String customerInput=sc.nextLine();

                        if(customerInput.isEmpty()){
                            System.out.println("Choice cannot be empty.");
                            continue;
                        }

                        try{
                            customerChoice=Integer.parseInt(customerInput);
                        }catch(NumberFormatException e){
                            System.out.println("Please enter numbers only.");
                            continue;
                        }

                        switch(customerChoice){

                            case 1:

                                productOperations.viewProducts();

                                break;

                            case 2:

                                System.out.print("Enter Product Name: ");

                                String searchProductName=sc.nextLine();

                                Product customerSearchProduct=
                                    productOperations.searchProduct(searchProductName);

                                if(customerSearchProduct!=null){

                                    System.out.println("Product Found");
                                    System.out.println("ID : "+customerSearchProduct.getProductId());
                                    System.out.println("Name : "+customerSearchProduct.getProductName());
                                    System.out.println("Category : "+customerSearchProduct.getCategory());
                                    System.out.println("Price : "+customerSearchProduct.getPrice());
                                    System.out.println("Quantity : "+customerSearchProduct.getQuantity());

                                }else{

                                    System.out.println("Product not found.");
                                }

                                break;

                            case 3:

                                System.out.print("Enter Product Name: ");

                                String selectedProductName=sc.nextLine();

                                Product selectedProduct=
                                    productOperations.searchProduct(selectedProductName);

                                if(selectedProduct==null){

                                    System.out.println("Product not found.");

                                    break;
                                }

                                String color="";
                                String size="";

                                if(selectedProduct.getCategory().equalsIgnoreCase("Dress") ||
                                   selectedProduct.getCategory().equalsIgnoreCase("Clothing")){

                                    System.out.println();
                                    System.out.println("Select Color:");
                                    System.out.println("1. Black");
                                    System.out.println("2. White");
                                    System.out.println("3. Blue");
                                    System.out.println("4. Red");
                                    System.out.print("Enter your choice: ");

                                    String colorChoice=sc.nextLine();

                                    switch(colorChoice){

                                        case "1":
                                            color="Black";
                                            break;

                                        case "2":
                                            color="White";
                                            break;

                                        case "3":
                                            color="Blue";
                                            break;

                                        case "4":
                                            color="Red";
                                            break;

                                        default:
                                            System.out.println("Invalid color choice.");
                                            break;
                                    }

                                    if(color.isEmpty()){
                                        break;
                                    }

                                    System.out.println();
                                    System.out.println("Select Size:");
                                    System.out.println("1. S");
                                    System.out.println("2. M");
                                    System.out.println("3. L");
                                    System.out.println("4. XL");
                                    System.out.print("Enter your choice: ");

                                    String sizeChoice=sc.nextLine();

                                    switch(sizeChoice){

                                        case "1":
                                            size="S";
                                            break;

                                        case "2":
                                            size="M";
                                            break;

                                        case "3":
                                            size="L";
                                            break;

                                        case "4":
                                            size="XL";
                                            break;

                                        default:
                                            System.out.println("Invalid size choice.");
                                            break;
                                    }

                                    if(size.isEmpty()){
                                        break;
                                    }
                                }

                                else if(selectedProduct.getCategory().equalsIgnoreCase("Slipper") ||
                                        selectedProduct.getCategory().equalsIgnoreCase("Footwear")){

                                    System.out.println();
                                    System.out.println("Select Color:");
                                    System.out.println("1. Black");
                                    System.out.println("2. White");
                                    System.out.println("3. Blue");
                                    System.out.println("4. Brown");
                                    System.out.print("Enter your choice: ");

                                    String colorChoice=sc.nextLine();

                                    switch(colorChoice){

                                        case "1":
                                            color="Black";
                                            break;

                                        case "2":
                                            color="White";
                                            break;

                                        case "3":
                                            color="Blue";
                                            break;

                                        case "4":
                                            color="Brown";
                                            break;

                                        default:
                                            System.out.println("Invalid color choice.");
                                            break;
                                    }

                                    if(color.isEmpty()){
                                        break;
                                    }

                                    System.out.println();
                                    System.out.println("Select Size:");
                                    System.out.println("1. 6");
                                    System.out.println("2. 7");
                                    System.out.println("3. 8");
                                    System.out.println("4. 9");
                                    System.out.println("5. 10");
                                    System.out.print("Enter your choice: ");

                                    String sizeChoice=sc.nextLine();

                                    switch(sizeChoice){

                                        case "1":
                                            size="6";
                                            break;

                                        case "2":
                                            size="7";
                                            break;

                                        case "3":
                                            size="8";
                                            break;

                                        case "4":
                                            size="9";
                                            break;

                                        case "5":
                                            size="10";
                                            break;

                                        default:
                                            System.out.println("Invalid size choice.");
                                            break;
                                    }

                                    if(size.isEmpty()){
                                        break;
                                    }
                                }

                                System.out.print("Enter Quantity: ");

                                String cartQuantityInput=sc.nextLine();

                                if(!cartQuantityInput.matches("[0-9]+")){

                                    System.out.println("Invalid quantity.");

                                    break;
                                }

                                int cartQuantity=
                                    Integer.parseInt(cartQuantityInput);

                                if(cartQuantity<=0){

                                    System.out.println("Invalid quantity.");

                                    break;
                                }

                                cartOperations.addToCart(
                                    cart,
                                    selectedProduct,
                                    color,
                                    size,
                                    cartQuantity
                                );

                                break;

                            case 4:

                                cartOperations.viewCart(cart);

                                break;

                            case 5:

                                System.out.print("Enter Product Name: ");

                                String removeName=sc.nextLine();

                                cartOperations.removeFromCart(
                                    cart,
                                    removeName
                                );

                                break;

                            case 6:

                                orderService.placeOrder(cart);

                                break;

                            case 7:

                                orderOperations.viewOrders();

                                break;

                            case 8:

                                System.out.println("Customer logged out.");

                                break;

                            default:

                                System.out.println("Invalid choice. Enter 1 to 8.");
                        }

                    }while(customerChoice!=8);

                    break;

                case 5:

                    System.out.println("Thank you for using E-Commerce Application.");

                    break;

                default:

                    System.out.println("Invalid choice. Enter 1 to 5.");
            }

        }while(mainChoice!=5);

        sc.close();
    }
}