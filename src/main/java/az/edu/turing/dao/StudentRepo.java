package az.edu.turing.dao;

import az.edu.turing.config.ConnectionHelper;
import az.edu.turing.entity.Student;
import az.edu.turing.exception.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements StudentDao {

    List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "INSERT INTO student (name, email, group_id) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getGroup_id());

            int row = preparedStatement.executeUpdate();
            System.out.println(row + ". row is created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Student> displayAllStudents() {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("id");
                    String studentName = resultSet.getString("name");
                    String studentEmail = resultSet.getString("email");
                    int groupId = resultSet.getInt("group_id");

                    students.add(new Student(studentId, studentName, studentEmail, groupId));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public void updateStudent(int id, Student student2) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "UPDATE student SET name = ?, email= ?, group_id = ? WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student2.getName());
            preparedStatement.setString(2, student2.getEmail());
            preparedStatement.setInt(3, student2.getGroup_id());
            preparedStatement.setInt(4, id);

            int row = preparedStatement.executeUpdate();
                System.out.println(row + ". row is updated");

            System.out.println(displayAllStudents());
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = " DELETE FROM student WHERE id = "+ id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int row = preparedStatement.executeUpdate();
            System.out.println(row + ". row is deleted");
            System.out.println(displayAllStudents());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
