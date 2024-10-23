package org.example.service;

import org.example.model.StudentInfo;

import java.util.List;
import java.util.Optional;

public interface StudentService {

     void addStudent(StudentInfo studentInfo);

     void updateStudent(StudentInfo studentInfo);

     void deleteStudent(Integer id);

     List<StudentInfo> getAllStudents ();

     Optional<StudentInfo> searchById(Integer id);
}
