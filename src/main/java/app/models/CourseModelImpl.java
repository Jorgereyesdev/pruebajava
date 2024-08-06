package app.models;

import app.entities.Course;
import app.persistence.configDb.MySqlConfig;
import app.persistence.imodel.ICourseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseModelImpl implements ICourseModel {
    @Override
    public Course create(Course request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO courses(name) values (?);";

        Course course = new Course();

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getName());
            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1? request : course;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM courses WHERE id=?;";

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
