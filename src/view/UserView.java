package view;

import config.ConfigUser;
import model.Role;

import java.util.Scanner;

public class UserView {
    Scanner sc = new Scanner(System.in);
    User userData = new ConfigUser().readUserFile("C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\userLoginData.txt");
    public void RegisterView() {
        while (true){
            System.out.println("Enter username: ");
            String username = sc.nextLine();
            System.out.println("Enter password: ");
            String password = sc.nextLine();
            System.out.println("Enter role: ");
            String setRole = sc.nextLine();
            Role role = null;
            switch (setRole){
                case "admin": role = Role.ADMIN;
                    break;
                case "user": role = Role.USER;
                    break;
            }
            User user = new User(username,password,role);
            new ConfigUser().writeUserFile("C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\userLoginData.txt",user);
            LoginView();
        }

    }

    public int LoginView(){
        System.out.println("Enter login username: ");
        String username = sc.nextLine();
        System.out.println("Enter login password: ");
        String password = sc.nextLine();
        if (username==userData.getUsername() && password==userData.getPassword() && userData.getRole()==Role.ADMIN){
            return 1;
        }
        else if (username==userData.getUsername() && password==userData.getPassword() && userData.getRole()==Role.USER){
            return 2;
        }
        else {
            return 0;
        }
    }

    public void Logout(){
        new ConfigUser().writeUserFile("C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\userLoginData.txt",null);
    }
}
