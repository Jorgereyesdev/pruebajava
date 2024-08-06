package app.models;

import app.entities.Student;
import app.persistence.configDb.MySqlConfig;
import app.persistence.imodel.IStudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModelImpl implements IStudentModel {
    @Override
    public Student create(Student request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO students(name, lastname, email, state ) values(?,?,?,?);";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getLastname());
            preparedStatement.setString(3, request.getEmail());
            preparedStatement.setObject(4, request.getState());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : null;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM students WHERE id=?;";

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

    @Override
    public List<Student> readAll(int size, int numberPage) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "SELECT * FROM students WHERE state ;";

        List<Student> students = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setLastname(resultSet.getString("lastname"));
                student.setEmail(resultSet.getString("email"));
                student.setState(resultSet.getBoolean("state"));
                students.add(student);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
        return students;
    }

    @Override
    public Student readByID(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "SELECT * FROM students WHERE id=?;";
        Student student = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, integer);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("state")
                );

                return student;
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
        return student;
    }

    @Override
    public Student getStudentByEmail(String email) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "SELECT * FROM students WHERE email=?;";

        Student student = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("state")
                );
                return student;
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return student;
    }

    @Override
    public Student update(Student request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "UPDATE students SET name=?, lastname=?, email=?, state=? WHERE id=?;";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getLastname());
            preparedStatement.setString(3, request.getEmail());
            preparedStatement.setObject(4, request.getState());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Student with ID " + request.getId() + " not found");
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : null;
    }
}
