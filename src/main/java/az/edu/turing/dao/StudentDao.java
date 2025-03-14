package az.edu.turing.dao;

import az.edu.turing.entity.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    List<Student> displayAllStudents();
    void updateStudent(int id, Student student2);
    void deleteStudent(int id);
}
