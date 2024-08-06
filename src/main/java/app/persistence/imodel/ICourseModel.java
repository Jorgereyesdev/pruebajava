package app.persistence.imodel;

import app.entities.Course;
import app.persistence.crud.CreateModel;
import app.persistence.crud.DeleteModel;

public interface ICourseModel extends
        CreateModel<Course>,
        DeleteModel<Integer> {
}
