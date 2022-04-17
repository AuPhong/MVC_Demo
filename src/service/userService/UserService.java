package service.userService;

import config.ConfigUser;
import view.User;

import java.util.List;

public class UserService {
    public static String PATH = "C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\userData";
    public static List<User> userList = (List<User>) new ConfigUser().readUserFile(PATH);


}
