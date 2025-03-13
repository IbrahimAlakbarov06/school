package az.edu.turing.dao;

import az.edu.turing.entity.Group;

import java.util.List;

public interface GroupDao {
    void createGroup(Group group);
    List<Group> displayAllGroup();
    void updateGroup(int id, Group group2);
    void deleteGroup(int id);
}
