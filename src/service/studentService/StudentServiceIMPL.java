package service.studentService;

import config.ConfigReadAndWriteFile;
import model.Student;

import java.util.List;

public class StudentServiceIMPL implements IStudentService {
    public static String STUDENTPATH = "C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\student.txt";
    public static List<Student> studentList = new ConfigReadAndWriteFile<Student>().readFromFile(STUDENTPATH);

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                studentList.remove(studentList.get(i));
            }
        }
    }

    @Override
    public void modifyById(Student student) {
        int id = student.getId();
        if (new StudentServiceIMPL().findById(id) == null) {
            System.out.println("Cannot find student: ");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                if (id == studentList.get(i).getId()) {
                    studentList.get(i).setName(student.getName());
                    studentList.get(i).setAge(student.getAge());
                    studentList.get(i).setClassroom(student.getClassroom());
                }
            }
        }
    }

    @Override
    public List<Student> findAll() {
        try {
            new ConfigReadAndWriteFile<Student>().writeToFile(STUDENTPATH, studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                return studentList.get(i);
            }
        }
        return null;
    }
}
