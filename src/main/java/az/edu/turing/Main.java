package az.edu.turing;

import az.edu.turing.dao.GroupDao;
import az.edu.turing.dao.GroupRepo;
import az.edu.turing.entity.Group;

public class Main {
    public static void main(String[] args) {
        Group group = new Group( "dsfa", "ff");
        Group group1 = new Group( "vasfhjfsbhsvf", "sahbhsvffsv");
        Group group2= new Group( "a", "b");

        GroupDao groupDao = new GroupRepo();
        groupDao.updateGroup(2, group2);

        System.out.println(groupDao.displayAllGroup());

    }
}