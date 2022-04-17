package service.classService;

import config.ConfigReadAndWriteFile;
import controller.ClassRoomController;
import model.Classroom;

import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    public static String CLASSPATH = "C:\\Users\\Sang\\IntelliJ IDEA\\MVC_Demo\\src\\data\\classRoom.txt";
    public static List<Classroom> classroomList = new ConfigReadAndWriteFile<Classroom>().readFromFile(CLASSPATH);

    @Override
    public void modifyById(Classroom classroom) {
        int id = classroom.getId();
        if (new ClassroomServiceIMPL().findById(id)==null){
            System.out.println("Cannot find class to edit");
        }else {
            for (int i = 0; i < classroomList.size(); i++) {
                if (classroom.getId() == classroomList.get(i).getId()){
                    classroomList.get(i).setName(classroom.getName());
                }
            }
        }

    }

    @Override
    public List<Classroom> findAll() {
        new ConfigReadAndWriteFile<Classroom>().writeToFile(CLASSPATH, classroomList);
        return classroomList;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < classroomList.size(); i++) {
            if (id == classroomList.get(i).getId()) {
                classroomList.remove(classroomList.get(i));
            }
        }
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
    }


    @Override
    public Classroom findById(int id) {
        for (int i = 0; i < classroomList.size(); i++) {
            if (id == classroomList.get(i).getId()) {
                return classroomList.get(i);
            }
        }
        return null;
    }
}
