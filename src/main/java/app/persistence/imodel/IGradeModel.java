package app.persistence.imodel;

import app.entities.Grade;
import app.persistence.crud.CreateModel;
import app.persistence.crud.UpdateModel;

public interface IGradeModel extends
        CreateModel<Grade>,
        UpdateModel<Grade>{
}
