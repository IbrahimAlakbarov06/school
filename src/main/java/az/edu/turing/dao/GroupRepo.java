package az.edu.turing.dao;

import az.edu.turing.config.ConnectionHelper;
import az.edu.turing.entity.Group;
import az.edu.turing.exception.DatabaseException;
import az.edu.turing.exception.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepo implements GroupDao{

    List<Group> groups = new ArrayList<>();

    @Override
    public void createGroup(Group group) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "INSERT INTO groups (name, description) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getDescription());

            int row = preparedStatement.executeUpdate();
            System.out.println(row + " row is created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Group> displayAllGroup() {
        String query = "SELECT * FROM groups";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int groupId = resultSet.getInt("id");
                    String groupName = resultSet.getString("name");
                    String groupDescription = resultSet.getString("description");

                    groups.add(new Group(groupId, groupName, groupDescription));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user: " + e.getMessage());
        }
        return groups;
    }

    public void updateGroup(int id, Group group2) {
        String query = "UPDATE groups SET name = ?, description = ? WHERE id = ?";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, group2.getName());
            preparedStatement.setString(2, group2.getDescription());
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new EntityNotFoundException("Group not found with ID: " + id);
            }

            System.out.println("Group with ID " + id + " updated successfully to '" + group2.getName() + "'");
        } catch (SQLException e) {
            throw new DatabaseException("Error updating group: " + e.getMessage());
        }
    }

    @Override
    public void deleteGroup(int id) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "delete from groups where id ="+id;
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            int row = preparedStatement.executeUpdate();
            System.out.println(row + ". row is deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
