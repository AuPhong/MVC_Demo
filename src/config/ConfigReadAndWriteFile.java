package config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFile <T>{
    public List<T> tList = new ArrayList<>();
    public  List<T> readFromFile(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tList;
    }

    public void writeToFile(String path, List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
