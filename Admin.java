package model;
public class Admin{
    private String adminId;
    private String adminName;
    private String username;
    private String password;
    public Admin(String adminId,String adminName,String username,String password){
        this.adminId=adminId;
        this.adminName=adminName;
        this.username=username;
        this.password=password;
    }
    public String getAdminId(){
        return adminId;
    }
    public String getAdminName(){
        return adminName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}

