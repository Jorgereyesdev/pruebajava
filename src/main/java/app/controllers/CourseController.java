package app.controllers;

import app.entities.Course;
import app.models.CourseModelImpl;
import app.persistence.imodel.ICourseModel;

public class CourseController {
    ICourseModel courseModel = new CourseModelImpl();

    public Course create(Course request) {
        return this.courseModel.create(request);
    }

    public void delete(Integer id) {
        this.courseModel.delete(id);
    }
}
