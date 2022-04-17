package controller;

import model.Student;
import service.studentService.StudentServiceIMPL;

import java.util.List;

public class StudentController {
    StudentServiceIMPL studentServiceIMPL = new StudentServiceIMPL();
    public List<Student> showList(){
        return studentServiceIMPL.findAll();
    }

    public void createStudent(Student student){
        studentServiceIMPL.save(student);
    }

    public Student findById(int id){
        return studentServiceIMPL.findById(id);
    }

    public void deleteStudent(int id){
        studentServiceIMPL.deleteById(id);
    }

    public void modifyStudent(Student student){
        studentServiceIMPL.modifyById(student);
    }


}
