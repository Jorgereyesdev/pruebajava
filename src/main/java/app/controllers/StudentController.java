package app.controllers;

import app.entities.Student;
import app.models.StudentModelImpl;
import app.persistence.imodel.IStudentModel;

import java.util.List;

public class StudentController {
    IStudentModel studentModel = new StudentModelImpl();

    public Student create(Student request) {
        return this.studentModel.create(request);
    }

    public Student update(Student request) {
        return this.studentModel.update(request);
    }

    public void delete(Integer id) {
        this.studentModel.delete(id);
    }

    public Student getStudentByEmail(String email) {
        return this.studentModel.getStudentByEmail(email);
    }

    public List<Student> findAllStudent(int size, int numberPage){
        return this.studentModel.readAll(10, 1);
    }

    public Student findStudentById(Integer id){
        return this.studentModel.readByID(id);
    }
}
