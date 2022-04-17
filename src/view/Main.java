package view;

import java.util.Scanner;

public class Main {
    
    public Main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================STUDENT MANAGE===================");
        System.out.println("1. CREATE CLASSROOM");
        System.out.println("2. SHOW LIST CLASS ROOM");
        System.out.println("3. CREATE STUDENT");
        System.out.println("4. SHOW LIST STUDENT");
        System.out.println("5. DELETE CLASSROOM");
        System.out.println("6. DELETE STUDENT");
        System.out.println("7. MODIFY CLASSROOM");
        System.out.println("8. MODIFY STUDENT");
        int chooseMenu = sc.nextInt();
        switch (chooseMenu) {
            case 1:
                new ClassRoomView().formCreateClassRoom();
                break;
            case 2:
                new ClassRoomView().showListClassRoom();
                break;
            case 3:
                new StudentView().creatStudent();
                break;
            case 4:
                new StudentView().showListStudent();
                break;
            case 5:
                new ClassRoomView().deleteClassRoom();
                break;
            case 6:
                new StudentView().deleteStudent();
                break;
            case 7:
                new ClassRoomView().modifyClass();
                break;
            case 8:
                new StudentView().modifyStudent();
                break;
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}
