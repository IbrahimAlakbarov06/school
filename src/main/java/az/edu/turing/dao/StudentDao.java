package az.edu.turing.dao;

import az.edu.turing.entity.Student;

public interface StudentDao {
    void addStudent(Student student);
    void displayAllStudents(Student student);
    void updateStudent(int id);
    void deleteStudent(int id);
}
