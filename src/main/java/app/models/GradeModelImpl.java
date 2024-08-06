package app.models;

import app.entities.Grade;
import app.persistence.configDb.MySqlConfig;
import app.persistence.imodel.IGradeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GradeModelImpl implements IGradeModel {
    @Override
    public Grade create(Grade request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO grades(grade, description, id_course) values(?, ?, ?)";

        Grade grade = new Grade();

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setFloat(1, request.getGrade());
            preparedStatement.setObject(2, request.getDescription());
            preparedStatement.setInt(3, request.getIdCourse());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1? request : grade;
    }

    @Override
    public Grade update(Grade request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "UPDATE grade SET grade=?, description=?, id_course=? WHERE id=?;";


        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setFloat(1, request.getGrade());
            preparedStatement.setObject(2, request.getDescription());
            preparedStatement.setInt(3, request.getIdCourse());
            preparedStatement.setInt(4, request.getId());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Grade with ID " + request.getId() + " not found");
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1? request : null;
    }
}
