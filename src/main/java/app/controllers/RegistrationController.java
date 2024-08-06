package app.controllers;

import app.entities.Registration;
import app.models.RegistrationModelImpl;
import app.persistence.imodel.IRegistrationModel;

public class RegistrationController {
    IRegistrationModel registrationModel = new RegistrationModelImpl();

    public Registration create(Registration request) {
        return this.registrationModel.create(request);
    }

    public void delete(Integer id) {
        this.registrationModel.delete(id);
    }
}
