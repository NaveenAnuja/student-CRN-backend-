package org.example.repository;

import org.example.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentRepository extends JpaRepository<StudentInfo,Integer> {
    Optional<StudentInfo> findById(Integer id);
}
