package az.edu.turing.service;

import az.edu.turing.dao.StudentDao;
import az.edu.turing.entity.Student;
import az.edu.turing.exception.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService  {
    StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void createStudent(Student student){
        studentDao.addStudent(student);
        System.out.println("Student succesfully added");
    }

    public void listStudents(){
        List<Student> students = studentDao.displayAllStudents();
        if (students.isEmpty()) {
            throw new EntityNotFoundException("No student found");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void updateStudent(int id, Student student){
        studentDao.updateStudent(id, student);
        System.out.println("Student is updated");
    }

    public void deleteStudent(int id){
        studentDao.deleteStudent(id);
        System.out.println("Student is deleted succesfully");
    }
}
