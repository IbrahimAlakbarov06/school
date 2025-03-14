package az.edu.turing.service;

import az.edu.turing.dao.GroupDao;
import az.edu.turing.dto.GroupDto;
import az.edu.turing.entity.Group;
import az.edu.turing.entity.Student;
import az.edu.turing.exception.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class GroupService  {
    GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void createGroup(Group group ){
        groupDao.createGroup(group);
        System.out.println("Group succesfully is added");
    }

    public void listGroups(){
        List<Group> groups = groupDao.displayAllGroup();
        if (groups.isEmpty()) {
            throw new EntityNotFoundException("No group found");
        } else {
            groups.forEach(System.out::println);
        }
    }

    public void updateGroup(int id, Group group){
        groupDao.updateGroup(id, group);
        System.out.println("Group is updated");
    }

    public void deleteGroup(int id){
        groupDao.deleteGroup(id);
        System.out.println("Group is deleted succesfully");
    }
}
