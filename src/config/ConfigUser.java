package config;

import view.User;

import java.io.*;

public class ConfigUser {
    User user = new User();

    public User readUserFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void writeUserFile(String path, User user){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
