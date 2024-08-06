package app.controllers;

import app.entities.Grade;
import app.models.GradeModelImpl;
import app.persistence.imodel.IGradeModel;

public class GradeController {
    IGradeModel gradeModel = new GradeModelImpl();

    public Grade create(Grade request){ return this.gradeModel.create(request); }

    public Grade update(Grade request) {
        return this.gradeModel.update(request);
    }
}
