package view;

import controller.ClassRoomController;
import controller.StudentController;
import model.Classroom;
import model.Student;
import service.studentService.StudentServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    List<Student> studentList = StudentServiceIMPL.studentList;
    StudentController studentController = new StudentController();
    Scanner sc = new Scanner(System.in);
    ClassRoomController classRoomController = new ClassRoomController();

    public  void showListStudent(){
        System.out.println(studentController.showList());
        System.out.println("Enter QUIT to comeback menu!");
        String backMenu = sc.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }

    public void creatStudent(){
        int id;
        while (true){
            if (studentList.size()==0){
                id=1;
            }else {
                id = studentList.get(studentList.size()-1).getId()+1;
            }
            System.out.println("Enter student's name: ");
            String name = sc.nextLine();
            System.out.println("Enter student's age: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the id of classroom: ");
            int idClassroom = Integer.parseInt(sc.nextLine());
            Classroom classroom = classRoomController.findById(idClassroom);
            Student student = new Student(id, name, age, classroom);
            studentController.createStudent(student);
            System.out.println("Enter any key to continue create Student or Enter QUIT to come back menu: ");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }

    public void deleteStudent(){
        while (true){
            System.out.println("Enter id of student to delete: ");
            int id = sc.nextInt();
            studentController.deleteStudent(id);
            showListStudent();
            System.out.println("Enter QUIT to comeback Menu");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }

    public void modifyStudent(){
        while (true){
            System.out.println("Enter student's id to edit: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student's name to edit: ");
            String name = sc.nextLine();
            System.out.println("Enter student's age to edit: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter class's id: ");
            int idClass = sc.nextInt();
            sc.nextLine();
            Classroom classroom = classRoomController.findById(idClass);
            Student student = new Student(id,name,age,classroom);
            studentController.modifyStudent(student);
            System.out.println("Press any key to continue modify or enter QUIT to come back menu: ");
            String backMenu = sc.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }

    }
}
