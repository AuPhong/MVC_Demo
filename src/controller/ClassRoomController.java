package controller;

import model.Classroom;
import service.classService.ClassroomServiceIMPL;

import java.util.List;

public class ClassRoomController {
    ClassroomServiceIMPL classroomServiceIMPL = new ClassroomServiceIMPL();

    public List<Classroom> showListClassRoom() {
        return classroomServiceIMPL.findAll();
    }

    public void createClassRoom(Classroom classroom) {
        classroomServiceIMPL.save(classroom);
    }

    public Classroom findById(int id) {
        return classroomServiceIMPL.findById(id);
    }

    public void deleteClass(int id) {
        classroomServiceIMPL.deleteById(id);
    }

    public void modifyById(Classroom classroom) {
        classroomServiceIMPL.modifyById(classroom);
    }
}
