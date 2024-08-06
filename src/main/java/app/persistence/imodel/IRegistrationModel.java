package app.persistence.imodel;

import app.entities.Registration;
import app.persistence.crud.CreateModel;
import app.persistence.crud.DeleteModel;

public interface IRegistrationModel extends
        CreateModel<Registration>,
        DeleteModel<Integer> {
}
