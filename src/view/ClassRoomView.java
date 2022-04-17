package view;

import controller.ClassRoomController;
import model.Classroom;
import service.classService.ClassroomServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class ClassRoomView {
    Scanner sc = new Scanner(System.in);
    List<Classroom> classroomList = ClassroomServiceIMPL.classroomList;
    ClassRoomController controller = new ClassRoomController();

    public void formCreateClassRoom(){
        int id;
        while (true){
            if (classroomList.size()==0){
                 id = 1;
            }else {
                id = classroomList.get(classroomList.size()-1).getId()+1;
            }
            System.out.println("Enter the name of classroom: ");
            String name = sc.nextLine();
            Classroom classroom = new Classroom(id, name);
            controller.createClassRoom(classroom);
            System.out.println("Enter any key to continue create ClassRoom or Enter QUIT to come back menu: ");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new view.Main();
                //break;
            }
        }
    }

    public void showListClassRoom(){
        System.out.println(controller.showListClassRoom());
        System.out.println("Enter QUIT to comeback Menu");
        String backMenu = sc.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }

    public void deleteClassRoom(){
        while (true){
            System.out.println("Enter id of classroom to delete: ");
            int id = sc.nextInt();
            controller.deleteClass(id);
            showListClassRoom();
            System.out.println("Enter QUIT to comeback Menu");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }

    public void modifyClass(){
        while (true){
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            System.out.println("Enter name to change: ");
            sc.nextLine();
            //sc.nextLine();
            String name = sc.nextLine();
            Classroom classroom = new Classroom(id, name);
            controller.modifyById(classroom);
            System.out.println("Enter quit to comeback menu or any key to continue modify: ");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }

    }
}
