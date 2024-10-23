package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.StudentInfo;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository repository;

    @Override
    public void addStudent(StudentInfo studentInfo) {
        repository.save(studentInfo);
    }

    @Override
    public void updateStudent(StudentInfo studentInfo) {
        repository.save(studentInfo);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudentInfo> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<StudentInfo> searchById(Integer id) {
        return repository.findById(id);
    }
}
