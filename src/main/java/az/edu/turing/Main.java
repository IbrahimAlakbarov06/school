package az.edu.turing;

import az.edu.turing.controller.GroupController;
import az.edu.turing.controller.StudentController;
import az.edu.turing.dao.GroupDao;
import az.edu.turing.dao.GroupRepo;
import az.edu.turing.dao.StudentDao;
import az.edu.turing.dao.StudentRepo;
import az.edu.turing.entity.Group;
import az.edu.turing.entity.Student;
import az.edu.turing.service.GroupService;
import az.edu.turing.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroupDao groupDao = new GroupRepo();
        StudentDao studentDao= new StudentRepo() ;

        GroupService groupService = new GroupService(groupDao);
        StudentService studentService = new StudentService(studentDao);

        GroupController groupController = new GroupController(groupService);
        StudentController studentController = new StudentController(studentService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Welcome to Student & Group Management System =====");

        while (running) {
            // Əsas menyunu göstərmək
            System.out.println("\nSelect an operation:");
            System.out.println("----- Group Operations -----");
            System.out.println("1. Create New Group");
            System.out.println("2. List All Groups");
            System.out.println("3. Update Group");
            System.out.println("4. Delete Group");

            System.out.println("----- Student Operations -----");
            System.out.println("5. Add New Student");
            System.out.println("6. List All Students");
            System.out.println("7. Update Student");
            System.out.println("8. Delete Student");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> groupController.createGroup();
                case 2 -> groupController.displayAllGroups();
                case 3 -> groupController.updateGroup();
                case 4 -> groupController.deleteGroup();

                case 5 -> studentController.createStudent();
                case 6 -> studentController.listStudents();
                case 7 -> studentController.updateStudent();
                case 8 -> studentController.deleteStudent();

                case 0 -> {
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice! Please select from the menu.");
            }
        }
//        Group group = new Group( "dsfa", "ff");
//        Group group1 = new Group( "vasfhjfsbhsvf", "sahbhsvffsv");
//        Group group2= new Group( "a", "b");
//
//        GroupDao groupDao = new GroupRepo();
//        groupDao.updateGroup(2, group2);
//
//        System.out.println(groupDao.displayAllGroup());
//
//        Student student = new Student("ibis","salamafa", 2);
//        Student student1 = new Student("madin","salamitos", 3);
//        StudentDao studentDao = new StudentRepo();
//        studentDao.addStudent(student);
////        studentDao.addStudent(student1);
//        studentDao.deleteStudent(2);

//        System.out.println(studentDao.displayAllStudents());

//        studentDao.updateStudent(2, new Student("ibi","adfdsa",1));
    }
}