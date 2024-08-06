package app.persistence.imodel;

import app.entities.Student;
import app.persistence.crud.*;

public interface IStudentModel extends
        CreateModel<Student>,
        DeleteModel<Integer>,
        UpdateModel<Student>,
        ReadAllModel<Student>,
        ReadByIdModel<Integer, Student> {
    Student getStudentByEmail(String email);
}
