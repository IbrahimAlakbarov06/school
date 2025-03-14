package az.edu.turing.controller;

import az.edu.turing.dao.StudentDao;
import az.edu.turing.entity.Student;
import az.edu.turing.service.StudentService;

import java.util.Scanner;

public class StudentController {
    StudentService studentService;
    Scanner scanner = new Scanner(System.in);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent(){
        System.out.print("Enter student's name: ");
        String name = scanner.next();
        System.out.print("Enter student's email: ");
        String email = scanner.next();
        System.out.print("Enter student's group ID: ");
        int group_id = scanner.nextInt();

        Student student = new Student(name, email, group_id);
        studentService.createStudent(student);
    }

    public void listStudents(){
        studentService.listStudents();
    }

    public void updateStudent(){
        System.out.print("Enter group id to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student's new name: ");
        String name = scanner.next();
        System.out.print("Enter student's new email: ");
        String email = scanner.next();
        System.out.print("Enter student's new group ID: ");
        int group_id = Integer.parseInt(scanner.nextLine());

        Student updatedStudent = new Student(name, email, group_id);
        studentService.updateStudent(id, updatedStudent);
    }

    public void deleteStudent() {
        System.out.println("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        studentService.deleteStudent(id);
    }
}
