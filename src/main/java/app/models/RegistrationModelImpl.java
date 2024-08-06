package app.models;

import app.entities.Registration;
import app.persistence.configDb.MySqlConfig;
import app.persistence.imodel.IRegistrationModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationModelImpl implements IRegistrationModel {
    @Override
    public Registration create(Registration request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO registrations(id_course, id_student) values(?, ?)";

        Registration registration = new Registration();

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, request.getIdCourse());
            preparedStatement.setInt(2, request.getIdStudent());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : registration;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM registration WHERE id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
    }
}
