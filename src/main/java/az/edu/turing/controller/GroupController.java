package az.edu.turing.controller;

import az.edu.turing.entity.Group;
import az.edu.turing.service.GroupService;

import java.util.Scanner;

public class GroupController {

     GroupService groupService;
     Scanner scanner = new Scanner(System.in);


    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public void createGroup() {
        System.out.print("Enter group name: ");
        String name = scanner.nextLine();
        System.out.print("Enter group description: ");
        String description = scanner.nextLine();

        Group group = new Group(name, description);
        groupService.createGroup(group);
        System.out.println("Group created successfully!");
    }

    public void displayAllGroups() {
        groupService.listGroups();
    }

    public void updateGroup() {
        System.out.print("Enter group id to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new group name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();

        Group updatedGroup = new Group( name, description);
        groupService.updateGroup(id, updatedGroup);
        System.out.println("Group updated!");
    }

    public void deleteGroup() {
        System.out.print("Enter group id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        groupService.deleteGroup(id);
        System.out.println("Group deleted!");
    }
}

