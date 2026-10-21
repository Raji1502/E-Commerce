package operations;

import java.util.Scanner;
import java.util.ArrayList;
import model.Admin;

import service.FileHandling;

public class AdminOperations{
    private ArrayList<Admin> admins=new ArrayList<>();

    public void createAdmin(Scanner sc){
        String adminId;
        String adminName;
        String username;
        String password;

        while(true){
            System.out.print("Enter Admin ID: ");
            adminId=sc.nextLine();

            if(!adminId.isEmpty()){
                break;
            }

            System.out.println("Admin ID cannot be empty.");
        }

        while(true){
            System.out.print("Enter Admin Name: ");
            adminName=sc.nextLine();

            if(adminName.isEmpty()){
                System.out.println("Admin Name cannot be empty.");
                continue;
            }

            if(!adminName.matches("[a-zA-Z ]+")){
                System.out.println("Invalid name. Enter letters only!");
                continue;
            }

            break;
        }

        while(true){
            System.out.print("Enter Username: ");
            username=sc.nextLine();

            if(!username.isEmpty()){
                break;
            }

            System.out.println("Username cannot be empty.");
        }

        while(true){
            System.out.print("Enter Password: ");
            password=sc.nextLine();

            if(password.isEmpty()){
                System.out.println("Password cannot be empty.");
                continue;
            }

            if(password.length()<6){
                System.out.println("Password must be at least 6 characters.");
                continue;
            }

            if(password.length()>15){
                System.out.println("Password must not exceed 15 characters.");
                continue;
            }

            if(!password.matches(".*[A-Z].*")){
                System.out.println("Password must contain at least one uppercase letter.");
                continue;
            }

            if(!password.matches(".*[a-z].*")){
                System.out.println("Password must contain at least one lowercase letter.");
                continue;
            }

            if(!password.matches(".*[0-9].*")){
                System.out.println("Password must contain at least one number.");
                continue;
            }

            if(!password.matches(".*[^a-zA-Z0-9].*")){
                System.out.println("Password must contain at least one special character.");
                continue;
            }

            break;
        }

        Admin newAdmin=new Admin(adminId,adminName,username,password);
        admins.add(newAdmin);
	FileHandling.saveAdmin(adminId,adminName,username,password);
        System.out.println("Admin created successfully.");
    }

    public Admin login(Scanner sc){
        if(admins.isEmpty()){
            System.out.println("Admin not registered.");
            return null;
        }

        String username;

        while(true){
            System.out.print("Enter Username: ");
            username=sc.nextLine();

            if(!username.isEmpty()){
                break;
            }

            System.out.println("Username cannot be empty.");
        }

        Admin loginAdmin=null;

        for(Admin admin:admins){
            if(admin.getUsername().equals(username)){
                loginAdmin=admin;
                break;
            }
        }

        if(loginAdmin==null){
            System.out.println("Invalid username.");
            return null;
        }

        while(true){
            System.out.print("Enter Password: ");
            String password=sc.nextLine();

            if(password.isEmpty()){
                System.out.println("Password cannot be empty.");
                continue;
            }

            if(loginAdmin.getPassword().equals(password)){
                System.out.println("Admin login successful.");
                return loginAdmin;
            }

            System.out.println("Wrong password. Try again.");
        } 
    }
}