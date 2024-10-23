package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.StudentInfo;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/studentInfo")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    final StudentService studentService;

    @PostMapping("/addStudent")
    public void addStudent(@RequestPart("student") StudentInfo studentInfo, @RequestPart("image") MultipartFile file) throws IOException {
            studentInfo.setImage(file.getBytes());
            studentService.addStudent(studentInfo);
    }

    @PutMapping("/updateStudent/{stdId}")
    public void updateStudent(@RequestPart("student") StudentInfo studentInfo, @RequestPart(value = "image", required = false) MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            studentInfo.setImage(file.getBytes());
        } else {

            Optional<StudentInfo> oldStudent = studentService.searchById(studentInfo.getStdId());
            if (oldStudent.isPresent()) {
                studentInfo.setImage(oldStudent.get().getImage());
            }
        }
        studentService.addStudent(studentInfo);
    }


    @DeleteMapping("/deleteStudent/{stdId}")
    public void deleteStudent(@PathVariable("stdId") Integer id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/{stdId}")
   public Optional<StudentInfo> searchById(@PathVariable("stdId") Integer id){
        return studentService.searchById(id);
   }
    @GetMapping
    public List<StudentInfo> getAllStudents(){
        return studentService.getAllStudents();
    }
}